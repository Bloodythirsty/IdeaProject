package listNode;

import org.junit.Test;

public class TestNode {
    public ListNode buildList(Integer[] a){
        ListNode head = null;
        int i=0;
        if (head==null){
            while(i<a.length && a[i++]==null) ;
            head = new ListNode(a[i-1]);
        }
        ListNode p = head;
        for(;i<a.length;i++){
            if (a[i]!=null){
                p.next = new ListNode(a[i]);
                p = p.next;
            }
        }
        return head;
    }

    @Test
    public void testBuildList(){
        Integer[] a = {1,2,3,4,5,null,7};
        ListNode listNode = buildList(a);
    }

    /*
            合并链表
     */
    public ListNode mergeList(ListNode l1,ListNode l2){
        ListNode pre = new ListNode(-2);
        ListNode p = pre;
        //都不为空，比较
        while(l1!=null && l2 !=null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        //有一个为空
        if(l1==null) p.next = l2;
        if (l2 ==null) p.next = l1;
        return pre.next;
    }

    @Test
    public void testMerge(){
        Integer[] a = {1,2,4};
        Integer[] b = {1,3,4,5,9,10};
        ListNode head = mergeList(buildList(a), buildList(b));
        ListNode p = head;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
}
