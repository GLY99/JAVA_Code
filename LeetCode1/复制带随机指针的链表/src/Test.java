import java.util.HashMap;

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
public class Test {
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        Node cur = head;
        //在每个结点的后面都复制一个结点
        while(cur != null){
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        //将新复制的结点的random指向对应结点
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node newhead = new Node(-1);
        Node p = newhead;
        //分离链表
        while(cur != null){
            p.next = cur.next;
            cur.next = cur.next.next;
            p = p.next;
            cur = cur.next;
        }
        return newhead.next;
    }
    public Node copyRandomListI(Node head){
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<>();
        while (cur != null){
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }//用map存储新旧链表的映射关系
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }//将新链表按照旧链表连接
        return map.get(head);
    }
}
