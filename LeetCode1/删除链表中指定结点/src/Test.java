class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
//删除链表中指定结点（要删除单向链表的结点找到他的前一个结点）
public class Test {
    public ListNode deleteNode(ListNode head, int val){
        if (head == null)return null;
        if (head.val == val){
            head = head.next;
            return head;
        }
        ListNode cur = head;
        while (cur.next != null){
            if (cur.next.val == val){
                break;
            }else {
                cur = cur.next;
            }
        }
        cur.next = cur.next.next;
        return head;
    }
}
