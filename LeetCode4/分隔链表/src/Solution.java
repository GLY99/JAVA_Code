/**给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

 你应当保留两个分区中每个节点的初始相对位置。*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode node1 = new ListNode(-1);//小于等于x的结点
        ListNode n1 = node1;
        ListNode node2 = new ListNode(-1);//大于等于x的结点
        ListNode n2 = node2;
        ListNode cur = head;
        while (cur != null){
            if (cur.val < x){
                n1.next = cur;
                cur = cur.next;
                n1 = n1.next;
            }else {
                n2.next = cur;
                cur = cur.next;
                n2 = n2.next;
            }
        }
        n2.next = null;
        n1.next = node2.next;
        return node1.next;
    }
}
