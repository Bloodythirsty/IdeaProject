package Y2020M4;

import java.util.ArrayDeque;

public class 简直offer06 {
    public static void main(String[] args) {
        ListNode1 head = new ListNode1(10);
        ListNode1 p = head;
        for (int i = 5; i > 0; i--,p=p.next) {
            p.next = new ListNode1(i);
        }
        int[] ints = reversePrint(head);
    }

    public static int[] reversePrint(ListNode1 head) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ListNode1 p = head;
        while(p!=null){
            queue.push(p.val);
            p = p.next;
        }
        int sezi = queue.size();
        int[] res = new int[sezi];
        for(int i=0;i<sezi;i++){
            res[i] = queue.pop();
        }
        return res;
    }
}

class ListNode1 {
    int val;
    ListNode1 next;
     ListNode1(int x) { val = x; }
}
