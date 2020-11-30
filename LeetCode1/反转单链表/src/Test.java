class  ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
    }
}
public class Test {
    public ListNode reverseList(ListNode head) {
        if (head == null)return null;
        ListNode cur = head;
        ListNode curnext = null;
        ListNode prev = null;
        ListNode newhead = null;
        while (cur != null){
            curnext = cur.next;
            if (curnext == null){
                newhead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curnext;
        }
        return newhead;
    }
    public ListNode reverseList2(ListNode head){
        if (head == null)return null;
        ListNode cur = head.next;
        ListNode newhead = head;//定义新的头结点
        while (cur != null){
            ListNode curnext = cur.next;//保存cur的下一个结点
            cur.next = newhead;//头插
            newhead = cur;//移动头
            cur = curnext;//遍历下一个结点
        }
        head.next = null;
        return newhead;
    }
}
