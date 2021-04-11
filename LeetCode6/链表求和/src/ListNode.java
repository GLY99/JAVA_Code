class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = null;
        ListNode tail = null;
        int sum = 0;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            int s1 = l1 == null ? 0 : l1.val;
            int s2 = l2 == null ? 0 : l2.val;
            sum = s1 + s2 + carry;//某一位的和
            carry = sum / 10;//进位
            ListNode node = new ListNode(sum % 10);
            if (head == null){
                head = node;
                tail = node;
            }else {
                tail.next = node;
                tail = node;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }
}