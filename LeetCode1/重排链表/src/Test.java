public class Test {
    //给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
    //将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public void reorderList(ListNode head){
         if(head == null)return;
         ListNode cur = head;
         int len = 0;
         while (cur != null){
             len++;
             cur = cur.next;
         }
         cur = head;
        ListNode[] listNodes = new ListNode[len];
         for (int i = 0;i < len;i++){
             listNodes[i] = cur;
             cur = cur.next;
         }
         cur = head;
         int i = 0;
         int j = len - 1;
         while (i < j){
             listNodes[i].next = listNodes[j];
             i++;
             listNodes[j].next =listNodes[i];
             j--;
         }
         listNodes[i].next = null;
    }
}
