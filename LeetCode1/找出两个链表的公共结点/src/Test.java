public class Test {
    //公共链表结点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        int lena = 0;
        ListNode cura = headA;
        while (cura != null){
            cura = cura.next;
            lena ++;
        }
        int lenb = 0;
        ListNode curb = headB;
        while (curb != null){
            curb = curb.next;
            lenb ++;
        }
        if (lena > lenb){
            for (int i = 0;i <lena - lenb;i++){
                headA = headA.next;
            }
        }else {
            for (int i = 0;i < lenb - lena;i++){
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
