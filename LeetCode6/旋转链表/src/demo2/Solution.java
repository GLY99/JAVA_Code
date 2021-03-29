package demo2;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        int len = 0;
        ListNode tail = null;
        ListNode cur = head;
        while (cur != null){
            tail = cur;
            cur = cur.next;
            len++;
        }
        k = k % len;
        if (k == 0){
            return head;
        }
        //首位相连
        tail.next = head;
        cur = head;
        tail = null;
        for (int i = 1;i < len -  k + 1;i++){
            tail = cur;
            cur = cur.next;
        }
        tail.next = null;
        return cur;
    }
}
