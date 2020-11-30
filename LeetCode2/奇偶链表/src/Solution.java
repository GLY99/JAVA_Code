//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode head1 = head.next;
        ListNode p0 = head;
        ListNode p1 = head.next;
        while (p0.next != null && p1.next != null){
            p0.next = p1.next;
            p1.next = p0.next.next;
            p0 = p0.next;
            p1 = p1.next;
        }
        p0.next = head1;

        return head;
    }
}
