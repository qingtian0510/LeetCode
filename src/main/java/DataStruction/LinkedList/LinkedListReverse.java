package DataStruction.LinkedList;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by tianbo on 2019/3/3.
 */
public class LinkedListReverse {
    public static void main(String[] args){
        Node linkNode1 = new Node();
        linkNode1.data = 1;
        Node linkNode2 = new Node();
        linkNode2.data = 2;
        Node linkNode3 = new Node();
        linkNode3.data = 3;
        Node linkNode4 = new Node();
        linkNode4.data = 4;
        Node linkNode5 = new Node();
        linkNode5.data = 5;
        Node linkNode6 = new Node();
        linkNode6.data = 6;
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;

        Node node=reverseLinkedList3(linkNode1);
        System.out.print(node.data);
    }


    public static Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node headNode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }

    /*
    * 非递归
    *
    * 思路：定义的这个三个指针，目的就是防止断链之后无法继续遍历链表以后的结点，实现全部的反转。
    * 当 pnow 的 next 指向 pnow 的前驱pre（初始化是 null）的时候，已经实现了 pnow 和前驱pre的方向反转，
    * 但是 pnow 此时就和后继pnext断链了，那么使用 pre 后移的方式，指向 pnow，
    * 同时 pnow 也后移，指向 pnext，而 pnext 继续指向更新之后的 pnow 的 next 结点即可。
    * 从而实现了状态的保存，继续遍历全部结点，实现链表反转。
    * */
    public static Node reverseLinkedList2(Node node) {
        Node now=node;
        Node pre=null;
        Node next=null;

        Node tail=null;
        while(now!=null){

            if(now.next==null){
                tail=now;
            }
            next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
        return tail;
    }

    /*
    迭代法。先将下一节点纪录下来，然后让当前节点指向上一节点，再将当前节点纪录下来,再让下一节点变为当前节点
    * */
    public static Node reverseLinkedList3(Node node) {
        Node now=node;
        Node pre=null;
        while(now!=null){
            Node next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
        return pre;
    }

}
class Node {
    Integer data;
    Node next;
}

