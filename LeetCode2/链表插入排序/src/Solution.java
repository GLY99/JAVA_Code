class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)return null;
        ListNode newHead = head;
        ListNode newLast = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val >= newLast.val){
                newLast = cur;
            }else {
                if (cur.val < newHead.val){
                    newLast.next = cur.next;
                    cur.next = newHead;
                    newHead = cur;
                }else {
                    ListNode tm = newHead.next;
                    ListNode tmPrev = newHead;
                    while (tm.val <= cur.val){
                        tmPrev = tm;
                        tm = tm.next;
                    }
                    newLast.next = cur.next;
                    cur.next = tm;
                    tmPrev.next = cur;
                }
            }
            cur = newLast.next;
        }
        return newHead;
    }
}
