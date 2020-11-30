class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
    }
}
public class Test {
    public ListNode middleNode(ListNode head){
        if (head == null)return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
