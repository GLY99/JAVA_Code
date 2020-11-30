public class Solution {
    public int[] reversePrint(ListNode head){
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        int[] ret = new int[count];
        int size = count - 1;
        cur = head;
        while (cur != null){
            ret[size--] = cur.val;
            cur = cur.next;
        }
        return ret;
    }
}
