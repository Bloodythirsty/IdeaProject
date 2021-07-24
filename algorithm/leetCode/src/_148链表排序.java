import listNode.ListNode;

public class _148链表排序 {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i : arr) {
            p.next = new ListNode(i);
            p = p.next;
        }
        sortList(head.next);
    }
     static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head , fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode fastHead = slow.next;
        slow.next = null;
        ListNode leftHead =  sortList(head);
        ListNode rightHead =  sortList(fastHead);
        return mergeList(leftHead,rightHead);
    }

    static ListNode mergeList(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null){
            return head1 == null ? head2 : head1;
        }
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                p.next = head1;
                head1 = head1.next;
            }else{
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        p.next = (head1 == null) ? head2 : head1;
        return newHead.next;
    }
}
