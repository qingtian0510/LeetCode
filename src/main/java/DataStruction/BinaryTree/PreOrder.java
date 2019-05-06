package DataStruction.BinaryTree;

import java.util.*;

/**
 * Created by tianbo on 2018/8/13.
 */
public class PreOrder {

    public static int maxDeep=1;

    public static int index=0;
    public static void main(String[] args){

        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(4);
        TreeNode b5 = new TreeNode(5);
        TreeNode b6 = new TreeNode(6);
        TreeNode b7 = new TreeNode(7);

        /**
         *      1
         *     / \
         *    2   3
         *   / \ / \
         *  4  5 6  7
         */
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b3.left=b6;
        b3.right=b7;

       //List<Integer> re=inorderTraversal(b1);
//        System.out.print(re);
        //inorderTraversal2(b1);
//        List<List<Integer>> list=layerTraversal(b1);
        //System.out.println(list.size());
        //getMaxDeep(b1,1);
        //System.out.println(maxDeep);
        //System.out.println(getMaxDeepUp(b1));
        //System.out.println(isSymmetric(b1));
        //System.out.println(hasPathSum(b1,8));
        //preorderTraversal2(b1);

//        int[] inorder={3,9,20,15,7};
//        int[] postorder={9,3,15,20,7};
//
//        TreeNode root=buildTree2(inorder,postorder);

        //TreeNode root=lowestCommonAncestor(b1,b6,b7);
        String str=serialize(b1);
        TreeNode root=deserialize(str);
        //System.out.println(str);

//        PreOrder preOrder=new PreOrder();
//        List<Integer> result=preOrder.preorderTraversal(b1);
//        System.out.print(run(b1));

    }

    //层序遍历---------
    /*
    * 层次遍历的步骤是：

        1.对于不为空的结点，先把该结点加入到队列中
        2.从队中拿出结点并访问，如果该结点的左右结点不为空，就分别把左右结点加入到队列中
        3.重复以上操作直到队列为空
    *
    * */
    public static List<List<Integer>> layerTraversal(TreeNode root){

        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(root==null)return list;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()>0){
            int len=queue.size();
            List<Integer> l=new ArrayList<Integer>();
            for(int i=0;i<len;i++){
                TreeNode node=queue.poll();
                l.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            list.add(l);
        }

        return list;
    }
    //最大深度(自顶向下)----------
    public static void getMaxDeep(TreeNode root,int deep){
       if(root==null)return;
        if(root.left==null&&root.right==null){
            maxDeep=Math.max(maxDeep,deep);
        }
        getMaxDeep(root.left,deep+1);
        getMaxDeep(root.right,deep+1);
    }

    //最大深度（自底相上）---------
    public static int getMaxDeepUp(TreeNode root){
        if(root==null)return 0;
        int left_depth=getMaxDeepUp(root.left);
        int right_depth=getMaxDeepUp(root.right);
        return Math.max(left_depth,right_depth)+1;
    }


     /*
    *  求解二叉树的最小路径
    * */

    public static int run(TreeNode node){
        if(node==null)return 0;
        if(node.left==null&&node.right!=null){
            return run(node.right)+1;
        }else if(node.right==null&&node.left!=null){
            return run(node.left)+1;
        }else{
            return run(node.left)>run(node.right) ? run(node.right)+1:run(node.left)+1;
        }
    }

    //先序遍历-----------------
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        result=order(root,result);
        return result;
    }
    public List<Integer> order(TreeNode root,List<Integer> list){
       // list.add(root.val);
//        if(root.left!=null){
//            list.add(root.val);
//            if(root.left!=null) order(root.left,list);
//            if(root.right!=null)order(root.right, list);
//        }

        list.add(root.val);
        if(root.left!=null) order(root.left,list);
        if(root.right!=null)order(root.right, list);


        return list;
    }

    //先序遍历（非递归）-----------------
    public static void preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();

        while(stack.size()!=0||root!=null){

            while(root!=null){
                stack.push(root);
                System.out.println(root.val);
                root=root.left;
            }
            if(stack.size()!=0){
                root=stack.pop();
                root=root.right;
            }
        }
    }


    //中序遍历
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<Integer>();
        result=inorder(root,result);
        return result;
    }
    public static List<Integer> inorder(TreeNode root,List<Integer> list){

        if(root.left!=null)inorder(root.left,list);
        list.add(root.val);
        if(root.right!=null)inorder(root.right,list);

        return list;
    }

    //中序遍历（非递归）
    /*
    * 思路：
    * 循环遍历直至数的左子节点为空，然后把栈里节点推出并打印，然后把右子节点压入栈内，循环刚才的过程。
    *
    * */
    public static void inorderTraversal2(TreeNode root){

        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(stack.size()!=0||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }

            root=stack.pop();
            System.out.println(root.val);
            root=root.right;

        }

    }

    //非递归后序遍历
    public static void NpostOrder(TreeNode node){
        Stack<TreeNode> s1=new Stack<TreeNode>();//第一次入栈
        Stack<TreeNode> s2=new Stack<TreeNode>();//第二次入栈
        TreeNode n=node;
        while(!s1.isEmpty()||n!=null){
            if(n!=null){
                s1.push(n);
                s2.push(n);
                n=n.right;
            }
            else{
                n=s1.pop();
                n=n.left;
            }
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().val);
        }

    }

    //判断二叉树是否镜像对称
    public static boolean isSymmetric(TreeNode root){

        if(root==null)return true;
        return Symmetric(root.left,root.right);
    }
    public static boolean Symmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        if(left.val!=right.val)return false;

        return (Symmetric(left.left,right.right)&&Symmetric(left.right,right.left));
    }

    //判断二叉树中是否存在路径值的和等于给定的值sum
    public static boolean hasPathSum(TreeNode root,int sum){

        return hasPathSumScore(root,sum,0);

    }
    public static boolean hasPathSumScore(TreeNode root,int sum,int score){
        if(root==null)return false;

        if(root.left==null&&root.right==null){
            if((score+root.val)==sum)return true;
        }else{
            score+=root.val;
        }
        System.out.println("current:"+root.val+",score:"+score);
        boolean left_bool=hasPathSumScore(root.left,sum,score);
        boolean right_bool=hasPathSumScore(root.right, sum, score);

        return (left_bool||right_bool);
    }


    //根据中序和后序构造二叉树
    public static TreeNode buildTree(int[] inorder, int[] postorder) {


        return build(inorder,postorder);

    }
    public static TreeNode build(int[] inorder,int[] postorder){
        if(inorder.length==0||postorder.length==0)return null;
        int flag=0;
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==postorder[postorder.length-1]){
                flag=i;
                break;
            }
        }
        root.left=build(Arrays.copyOfRange(inorder,0,flag),Arrays.copyOfRange(postorder,0,flag));
        root.right=build(Arrays.copyOfRange(inorder,flag+1,inorder.length),Arrays.copyOfRange(postorder,flag,postorder.length-1));
        return root;
    }

    //根据中序和前序构造二叉树
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        return build2(preorder, inorder);
    }
    public static TreeNode build2(int[] preorder,int[] inorder){
        if(inorder.length==0||preorder.length==0)return null;
        int flag=0;
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                flag=i;
                break;
            }
        }
        root.left=build2(Arrays.copyOfRange(preorder,1,flag+1),Arrays.copyOfRange(inorder,0,flag));
        root.right=build2(Arrays.copyOfRange(preorder,flag+1,preorder.length),Arrays.copyOfRange(inorder,flag+1,inorder.length));
        return root;
    }

    //寻找二叉树中两个节点的最近公共祖先
    //https://www.cnblogs.com/simplepaul/p/7702655.html
    /**思路：从根节点开始遍历，如果node1和node2中的任一个和root匹配，那么root就是最低公共祖先。
     * 如果都不匹配，则分别递归左、右子树，如果有一个 节点出现在左子树，并且另一个节点出现在右子树，
     * 则root就是最低公共祖先.  如果两个节点都出现在左子树，则说明最低公共祖先在左子树中，否则在右子树。*/
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 左右子树探索时发现目标节点，则通过返回值标记
        if(root == null || p == root || q == root) {
            return root;
        }

        // 查看左子树中是否有目标结点，没有为null
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        // 查看右子树中是否有目标结点，没有为null
        TreeNode r = lowestCommonAncestor(root.right,p,q);

        //都不为空，说明做右子树都有目标结点，则公共祖先就是本身
        if(l!= null && r!= null) {
            return root;
        }
        // 其他情况，则要继续向上标记，显示此节点下边有目标节点
        return l != null?l:r;
    }


    //序列化二叉树
    public static String serialize(TreeNode root) {
        StringBuffer str=new StringBuffer();
        serializePreOrder(root,str);
        return str.toString();
    }

    public static void serializePreOrder(TreeNode root,StringBuffer str){
        if(root==null){
            str.append("#!");
            return;
        }
        str.append(root.val+"!");
        serializePreOrder(root.left,str);
        serializePreOrder(root.right,str);
    }

    //反序列化二叉树
    public static TreeNode deserialize(String data) {


        String[] strs=data.split("!");
        TreeNode root=deserializeCore(strs);
        return root;
    }

    public static TreeNode deserializeCore(String[] strs){
        if("#".equals(strs[index])){
            index++;
            return  null;
        }else{
            TreeNode node=new TreeNode(Integer.parseInt(strs[index]));
            index++;
            node.left=deserializeCore(strs);
            node.right=deserializeCore(strs);
            return node;
        }
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}