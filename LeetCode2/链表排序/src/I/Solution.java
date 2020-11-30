package I;
//链表归并排序
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if (head.next == null)return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = null;
        while (fast != null && fast.next !=null){
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        mid.next = null;
        ListNode h1 = mergeSort(head);
        ListNode h2 = mergeSort(slow);
        return merge(h1,h2);
    }
    public ListNode merge(ListNode h1,ListNode h2){
        ListNode newhead = new ListNode(-1);
        ListNode p = newhead;
        while (h1 != null && h2 != null){
            if (h1.val <= h2.val){
                p.next = h1;
                p = p.next;
                h1 = h1.next;
            }else {
                p.next = h2;
                p = p.next;
                h2 = h2.next;
            }
        }
        if (h1 != null){
            p.next = h1;
        }
        if (h2 != null){
            p.next = h2;
        }
        return newhead.next;
    }
}

