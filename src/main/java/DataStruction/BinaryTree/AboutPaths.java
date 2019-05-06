package DataStruction.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tianbo on 2019/2/28.
 */
public class AboutPaths {
    public static void main(String[] args) {

        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(4);
        TreeNode b5 = new TreeNode(5);
        TreeNode b6 = new TreeNode(4);
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
        b3.left = b6;
        b3.right = b7;


        AboutPaths aboutPaths=new AboutPaths();
        aboutPaths.findPaths(b1,8);
    }


    //------------------给定一颗二叉树和一个整数，找出所有树内路径上节点值等于该整数的所有路径---------------
    public void findPaths(TreeNode root,int num){

        Stack<Integer> path=new Stack<Integer>();

        pathIterator(path,root,num);

    }

    public void pathIterator(Stack<Integer> path,TreeNode root,int num){
        if(root==null)return;
        num-=root.val;
        if(root.left==null&&root.right==null&&num==0){
            System.out.println("one path:");
            for(int i=0;i<path.size();i++)System.out.print(path.get(i)+" ");

            System.out.print(root.val);
        }else{
            path.push(root.val);
            pathIterator(path,root.left,num);
            pathIterator(path,root.right,num);
            path.pop();
        }

    }
}
