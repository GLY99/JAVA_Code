package II;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {
    public Node copyRandomList(Node head){
        if (head == null)return null;
        Node cur = head;
        //在每个结点后面复制一个新的结点
        while (cur != null){
            Node copynode = new Node(cur.val);
            copynode.next = cur.next;
            cur.next = copynode;
            cur = cur.next.next;
        }
        //连接random域
        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //分离链表
        Node newhead = new Node(-1);
        cur = head;
        Node node = newhead;
        while (cur != null){
            node.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            node = node.next;
        }
        return newhead.next;
    }
}
