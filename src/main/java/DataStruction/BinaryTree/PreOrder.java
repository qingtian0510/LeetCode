package DataStruction.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianbo on 2018/8/13.
 */
public class PreOrder {


    public static void main(String[] args){
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(4);
        TreeNode b5 = new TreeNode(5);

        /**
         *      a
         *     / /
         *    b   c
         *   / /
         *  d   e
         */
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        result=order(root,result);
        return result;
    }
    public List<Integer> order(TreeNode root,List<Integer> list){
        list.add(root.val);
        if(root.left!=null){
            list.add(root.val);
            if(root.left!=null) preorderTraversal(root.left);
            if(root.right!=null)preorderTraversal(root.right);
        }
        return list;
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