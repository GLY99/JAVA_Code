public class Test {
    public ListNode deleteDuplication(ListNode pHead){
        ListNode newhead = new ListNode(-1);
        ListNode tmp = newhead;
        ListNode cur = pHead;
        while (cur != null){
            if (cur.next != null && cur.val == cur.next.val){
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;

            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newhead;
    }
}
