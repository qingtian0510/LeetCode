package DataStruction.BinaryTree;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by tianbo on 2019/3/10.
 */
public class TreeSortTest {
    public static void main(String[] args) {

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
        b3.left = b6;
        b3.right = b7;

        //preOrder2(b1);
        NpostOrder(b1);
//        List<List<Integer>> result=layerTraversal(b1);
//        System.out.print(result.size());
    }

    public static List<List<Integer>> layerTraversal(TreeNode root){
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        if(root==null)return result;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()>0){
            int len=queue.size();
            List<Integer> temp=new ArrayList<Integer>();
            for(int i=0;i<len;i++){
                TreeNode node=queue.poll();
                temp.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            result.add(temp);
        }
        return result;
    }

    public static void preOrder2(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(stack.size()>0||root!=null){
            while(root!=null){
                stack.push(root);
                System.out.print(root.val);
                root=root.left;
            }
            if(stack.size()>0){
                root=stack.pop();
                root=root.right;
            }
        }
    }

    public static void inOrder2(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(stack.size()>0||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            System.out.print(root.val);
            root=root.right;
        }
    }

//    public static void afterOrder2(TreeNode root){
//        Stack<TreeNode> stack=new Stack<TreeNode>();
//        while(stack.size()>0||root!=null){
//            while(root!=null){
//                stack.push(root);
//                root=root.left;
//            }
//            root=stack.pop();
//            if(root.right!=)
//            System.out.print(root.val);
//        }
//    }
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

}
