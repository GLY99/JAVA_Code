class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    public Node head;
    public MyLinkedList() {

    }
    public int get(int index) {
        if (index < 0)return -1;
        Node cur = this.head;
        int count = 0;
        while (count != index){
            count++;
            cur = cur.next;
            if (cur == null){
                return -1;
            }
        }
        return cur.val;
    }
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = this.head;
        this.head = node;
    }
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    public void addAtIndex(int index, int val) {
        Node cur = this.head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        Node node = new Node(val);
        if (index <= 0){
            addAtHead(val);
            return;
        }
        if (index == len){
            addAtTail(val);
            return;
        }
        if (index > len)return;
        cur = this.head;
        for (int i = 0;i < index - 1;i++){
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }
    public void deleteAtIndex(int index) {
        Node cur = this.head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        if (index < 0 || index > len - 1)return;
        if (index == 0){
            this.head = this.head.next;
            return;
        }
        cur = this.head;
        for (int i = 0;i < index - 1;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
}
