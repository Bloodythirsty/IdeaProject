import listNode.ListNode;

public class _92反转链表 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i : arr) {
            p.next = new ListNode(i);
            p = p.next;
        }

        reverseBetween(head.next, 2,4);

    }

    static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode reverseHead = newHead, reverseTail = newHead;
        ListNode reverseHeadPre = null, reverseTailNext = null;
        for (int i=left;i>0;i--){
            if(i == 1){
                reverseHeadPre = reverseHead;
            }
            reverseHead = reverseHead.next;
        }
        while(right-->0){
            reverseTail = reverseTail.next;
        }
        reverseTailNext = reverseTail.next;
        reverseTail.next = null;
        ListNode p = reverse(reverseHead);

        reverseHeadPre.next = p;
        while(p.next!=null){
            p = p.next;
        }
        p.next = reverseTailNext;

        return newHead.next;

    }

    static ListNode reverse(ListNode head){
        ListNode newHead = new ListNode(0);

        ListNode headNext = head.next;
        while(headNext != null){
            head.next = newHead.next;
            newHead.next = head;

            head = headNext;
            headNext = headNext.next;
        }
        head.next = newHead.next;
        newHead.next = head;
        return newHead.next;
    }
}
