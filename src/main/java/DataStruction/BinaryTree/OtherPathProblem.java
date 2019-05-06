package DataStruction.BinaryTree;

/**
 * Created by tianbo on 2019/3/5.
 */
public class OtherPathProblem {
    public static void main(String[] args){
        TreeNodeWithParent b1 = new TreeNodeWithParent(1);
        TreeNodeWithParent b2 = new TreeNodeWithParent(2);
        TreeNodeWithParent b3 = new TreeNodeWithParent(3);
        TreeNodeWithParent b4 = new TreeNodeWithParent(4);
        TreeNodeWithParent b5 = new TreeNodeWithParent(5);
        TreeNodeWithParent b6 = new TreeNodeWithParent(6);
        TreeNodeWithParent b7 = new TreeNodeWithParent(7);

        /**
         *      1
         *     / \
         *    2   3
         *   / \ / \
         *  4  5 6  7
         */
        b1.left = b2;
        b1.right = b3;
        b2.parent=b1;
        b3.parent=b1;

        b2.left = b4;
        b2.right = b5;
        b4.parent=b2;
        b5.parent=b2;

        b3.left=b6;
        b3.right=b7;
        b6.parent=b3;
        b7.parent=b3;

        TreeNodeWithParent node=getInorderNext(b3);
        System.out.print(node.val);

    }


    /*
    * 给定一颗带由带parent的节点组成的二叉树，和一个指定的节点，输出中序遍历该节点后的节点，限制条件：不遍历整棵树
    *
    * 思路：根据中序遍历的规则，当前节点current的下一个节点分三种情况讨论：
    * 1.current.right!=null
    *    右子树不为空，遍历右子树，找到最左边的叶子节点
    * 2.current.right==null&&current.parent!=null
    *    右子树为空，父节点不为空。向上找，直到某个节点node是其父节点的左节点返回。如果没有，则返回null
    * 3.current.right==null&&current.parent==null
    *    return null
    *
    *
    * */

    public static TreeNodeWithParent getInorderNext(TreeNodeWithParent node){

        if(node.right!=null){
            node=node.right;
            while(node.left!=null){
                node=node.left;
            }
            return node;
        }else if(node.parent!=null){
            while(node!=null){
                if(node.parent.left==node){

                    return node.parent;
                }
                else node=node.parent;
            }
            return null;
        }else return null;
    }

}
class TreeNodeWithParent {
    int val;
    TreeNodeWithParent left;
    TreeNodeWithParent right;
    TreeNodeWithParent parent;


    TreeNodeWithParent(int x) {
        val = x;
    }
}
