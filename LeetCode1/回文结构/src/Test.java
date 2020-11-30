public class Test {
    public boolean chkPalindrome (ListNode head){
        if (head == null)return false;
        if (head.next == null)return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        while (cur != null){
            ListNode curnext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curnext;
        }
        while (head != slow){
            if (head.val != slow.val){
                return false;
            }
            if (head.next == slow){
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}
