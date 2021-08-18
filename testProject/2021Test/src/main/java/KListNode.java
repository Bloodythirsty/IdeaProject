public class KListNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseKGroup(head,2);

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode p = tempHead;
        while(p!=null){

            ListNode temp = p;
            int i = 1;
            while(i <= k && temp.next!=null){
                i++;
                temp = temp.next;
            }

            ListNode newTail = p.next;

            if(i-1 == k){
                ListNode pre = p.next;
                ListNode aft = pre.next;
                ListNode secd = aft.next;
                while(aft != temp){
                    aft.next = pre;
                    pre = aft;
                    aft = secd;
                    secd = secd.next;
                }
                aft.next = pre;
                p.next = aft;
                newTail.next = secd;
                p = newTail;
            }else{
                p = null;
            }
        }
        return tempHead.next;
    }
}
