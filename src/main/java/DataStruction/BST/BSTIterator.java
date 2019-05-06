package DataStruction.BST;

import java.util.Stack;

/**
 * Created by tianbo on 2018/9/12.
 *
 * 实现搜索二叉树的迭代器
 *
 *
 */
public class BSTIterator {

    private Stack<TreeNode> stack=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {

        TreeNode current=root;
        while(current!=null){
            stack.push(current);
            current=current.left;
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {

        TreeNode current=stack.pop();
        int val=current.val;
        if(current.right!=null){
            TreeNode node=current.right;
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
        }
        return val;
    }
}
