package DataStruction.BinaryTree;

import java.util.*;

/**
 * Created by tianbo on 2018/8/13.
 */
public class PreOrder {

    public static int maxDeep=1;

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
        //List<List<Integer>> list=layerTraversal(b1);
        //System.out.println(list.size());
        //getMaxDeep(b1,1);
        //System.out.println(maxDeep);
        //System.out.println(getMaxDeepUp(b1));
        //System.out.println(isSymmetric(b1));
        //System.out.println(hasPathSum(b1,8));
        preorderTraversal2(b1);
    }

    //层序遍历---------
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


    //先序遍历-----------------
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        result=order(root,result);
        return result;
    }
    public List<Integer> order(TreeNode root,List<Integer> list){
        list.add(root.val);
        if(root.left!=null){
            list.add(root.val);
            if(root.left!=null) order(root.left,list);
            if(root.right!=null)order(root.right, list);
        }
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

    //
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}