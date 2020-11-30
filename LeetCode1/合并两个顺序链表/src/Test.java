public class Test {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode ret = new ListNode();
        ListNode head = ret;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                ret.next = l1;
                ret = ret.next;
                l1 = l1.next;
            }else {
                ret.next = l2;
                ret = ret.next;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            ret.next = l2;
        }else {
            ret.next = l1;
        }
        return head.next;
    }
}
