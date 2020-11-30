public class Test {
    public ListNode partition(ListNode pHead,int x){
        if (pHead == null)return null;
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = pHead;
        while (cur != null){
            if (cur.val < x){
                if (bs == null){
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if (as == null){
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if (bs != null && as != null){
            be.next = as;
            ae.next =null;
            return bs;
        }else {
            if (bs == null){
                return as;
            }else {
                return bs;
            }
        }
    }
}
