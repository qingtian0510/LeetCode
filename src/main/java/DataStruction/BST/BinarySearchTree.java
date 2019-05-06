package DataStruction.BST;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianbo on 2018/9/12.
 */
public class BinarySearchTree {
    public static void main(String[] args){
        TreeNode b1 = new TreeNode(4);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(5);
        TreeNode b4 = new TreeNode(1);
        TreeNode b5 = new TreeNode(3);
        //TreeNode b6 = new TreeNode(6);
        TreeNode b7 = new TreeNode(7);

        /**
         *      4
         *     / \
         *    2   5
         *   / \  \
         *  1  3   7
         */
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b3.right=b7;
        BinarySearchTree binarySearchTree=new BinarySearchTree();

        //binarySearchTree.isValidBST(b1);
        //TreeNode node=binarySearchTree.searchBST(b1, 2);
        binarySearchTree.insertIntoBST(b1, 6);
//        binarySearchTree.deleteNode(b1,2);
//        System.out.println(b1.val);


        System.out.print(binarySearchTree.lowestCommonAncestor(b1, b4, b5).val);
    }

    //-----------验证是否是BST搜索二叉树---------------
    public boolean isValidBST(TreeNode root) {

        List<Integer> list=inorder(root);
        Boolean bool=upordown(list,true);
        return bool;
    }
    //中序遍历
    public  List<Integer> inorder(TreeNode root){
        List<Integer> list=new ArrayList<Integer>();

        inorderCore(root, list);
        return list;
    }
    public  void inorderCore(TreeNode root,List<Integer> list){
        if(root==null)return;
        inorderCore(root.left, list);
        list.add(root.val);
        inorderCore(root.right,list);
    }

    //判断是否有序
    public boolean upordown(List<Integer> list,boolean up){
        boolean bool=true;

       for(int i=0;i<list.size()-1;i++){
           if(up){
               if(list.get(i)>list.get(i+1)){
                   bool=false;
                   break;
               }
           }else {
               if(list.get(i)<list.get(i+1)){
                   bool=false;
                   break;
               }
           }
       }

        return bool;
    }
    //------------------------------------------------


    //-------------------搜索固定的值------------------
    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null)return null;
        if(root.val==val)return root;
        else if(root.val<val) return searchBST(root.right,val);
        else return searchBST(root.left,val);
    }
    //------------------------------------------------

    //------------------二叉搜索数插入值----------------
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode node=new TreeNode(val);
        if(root==null)return node;

        TreeNode current=root;
        while(true){
            if(current.val<=val){
                if(current.right!=null)current=current.right;
                else{
                    current.right=node;
                    return root;
                }
            }
            else {
                if(current.left!=null)current=current.left;
                else{
                    current.left=node;
                    return root;
                }
            }
        }
    }

    //---------------------二叉搜索树删除节点--------------------

    /*
    *
    * 关键点：
    * 1.先找到要删除的节点
    * 2.如果该节点为叶子节点，返回null
    * 3.如果左子树和右子数存在一个，返回这个子数
    * 4.如果左子树和右子数同时存在，找到右子数中最小的值（推广到所有二叉树，为右子数的递归到最后的左子节点），将该值赋给要删除的节点，然后对右子数删除这个最小的值
    *
    * */
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null)return null;
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else{
            //如果左右子数不同时存在
            if(root.left==null||root.right==null){
                root= (root.left==null) ? root.right:root.left;
            }else{//左右子数同时存在
                TreeNode current=root.right;
                while(current.left!=null)current=current.left;
                root.val=current.val;
                root.right=deleteNode(root.right,current.val);
            }
        }
        return root;
    }
    //----------------------------------------------------------


    //--------------------二叉树通用删除方法-----------------------
    public TreeNode deleteNodeCommon(TreeNode root, int key) {
        TreeNode current=root;//当前节点
        TreeNode pre=null;//父节点
        while(current!=null){
            if(current.val==key)break;
            pre=current;
            if(current.val>key)current=current.left;
            else current=current.right;
        }
        if(current==null)return root;
        if(pre!=null)return del(current);
        if(pre.left!=null&&pre.left.val==key)pre.left=del(current);
        else pre.right=del(current);
        return root;
    }
    public TreeNode del(TreeNode node){
        if(node.left==null&&node.right==null)return null;
        if(node.left==null||node.right==null)return (node.left==null)? node.right:node.left;
        TreeNode pre=node;
        TreeNode current=node.right;
        while(current.left!=null){
            pre=node;
            current=current.left;
        }
        node.val=current.val;
        if(pre==node){
            node.right=current.right;
        }else{
            pre.left=current.right;
        }
        return node;
    }

    //-------------------------------------------------------------

    //----------------------二叉搜索树的最近公共祖先------------------
    /*
    * 如果p和q都小于root，去左边找就行。如果p和q在两侧的，直接就是root，这个可以通过val来判断。
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p==root||q==root||root==null){ //root==null  对应，qp不在此树中
            return root;
        }
        if(p.val<root.val&&q.val<root.val)return lowestCommonAncestor(root.left,p,q);
        else if(p.val>root.val&&q.val>root.val)return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
    //----------------------------------------------------------------




}
