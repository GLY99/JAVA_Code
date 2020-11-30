public class Test {
     class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null)return l2;
            if(l2 == null)return l1;
            ListNode cur = new ListNode();
            int temp = 0;
            ListNode newhead = new ListNode(-1);
            ListNode head = newhead;
            while(l1 != null && l2 != null){
                cur.val = l1.val + l2.val;
                cur.val += temp;
                temp = cur.val / 10;
                cur.val = cur.val % 10;
                head.next = cur;
                head = cur;
                cur = new ListNode();
                l1 = l1.next;
                l2 = l2.next;
            }
            if(l1 == null && l2 == null && temp != 0){
                cur = new ListNode();
                cur.val = temp;
                head.next = cur;
                head = cur;
            }
            if(l2 == null && l1 != null){
                while(l1 != null){
                    cur.val = l1.val;
                    cur.val += temp;
                    temp = cur.val / 10;
                    cur.val = cur.val % 10;
                    head.next = cur;
                    head = cur;
                    cur = new ListNode();
                    l1 = l1.next;
                }
                if(temp != 0){
                    cur = new ListNode();
                    cur.val = temp;
                    head.next = cur;
                }
            }
            if(l1 == null && l2 != null){
                while(l2 != null){
                    cur.val = l2.val;
                    cur.val += temp;
                    temp = cur.val / 10;
                    cur.val = cur.val % 10;
                    head.next = cur;
                    head = cur;
                    cur = new ListNode();
                    l2 = l2.next;
                }
                if(temp != 0){
                    cur = new ListNode();
                    cur.val = temp;
                    head.next = cur;
                }
            }
            return newhead.next;
     }
}
