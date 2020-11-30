class ListNode{
    int val;
    ListNode next;
    public ListNode (int x){
        val = x;
    }
}
public class Test {
    public ListNode getKthFromEnd(ListNode head, int k){
        if (k <= 0 || head == null)return null;
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 1;i <= k-1;i++){
            if (fast.next != null){
                fast = fast.next;
            }else {
                return null;
            }
        }
        while (fast.next != null){
                fast = fast.next;
                slow = slow.next;
        }
        return slow;
    }
}
