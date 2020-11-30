public class Test {
    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        ListNode cur = head;
        while (cur != slow){
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}
