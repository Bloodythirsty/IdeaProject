package _0808HaoWeiLai;

/**
 * @author zhangkangkang
 * @date 2021/08/08 14:51
 */
public class TestWeilai1 {
    public static void main(String[] args) {
        //if(head1 == null) return head2;
        //if(head2 == null) return head1;
        //ListNode newHead = (head1.val <= head2.val) ? head1 : head2;
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        ListNode pre = newHead, point = null;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                point = head1;
                head1 = head1.next;
            }else{
                point = head2;
                head2 = head2.next;
            }
            if(pre.val != point.val){
                pre.next = point;
                pre = point;
            }
        }

        while(head1 != null){
            if(pre.val != head1.val){
                pre.next = head1;
                pre = head1;
            }
            head1 = head1.next;
        }

        while(head2 != null){
            if(pre.val != head2.val){
                pre.next = head2;
                pre = head2;
            }
            head2 = head2.next;
        }

        pre.next = null;
        return newHead.next;
    }
}
