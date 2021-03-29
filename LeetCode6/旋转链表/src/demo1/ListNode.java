package demo1;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        int len = 0;
        ListNode cur = head;
        ListNode last = null;
        while (cur != null){
            last = cur;
            cur = cur.next;
            len++;
        }
        //k可能大于等于len
        k = k % len;
        //等于或者是len的整数倍直接返回
        if (k == 0){
            return head;
        }
        cur = head;
        ListNode prev = null;
        //倒数第k个结点就是新头
        for (int i = 1;i < len - k + 1;i++){
            prev = cur;
            cur = cur.next;
        }
        //cur为新的头结点
        prev.next = null;
        ListNode newHead = new ListNode(-1);
        newHead.next = cur;
        last.next = head;
        return newHead.next;
    }
}