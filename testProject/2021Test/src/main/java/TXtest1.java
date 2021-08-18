import com.google.common.collect.Comparators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TXtest1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        ListNode solve = solve(head);

    }

    public static ListNode solve (ListNode S) {
        // write code here
        int size = 0;
        ListNode p = S;
        while (p!=null){
            size++;
            p = p.next;
        }
        int[][] recrew = new int[size][size];
        p = S;
        for (int i = 0; i < size; i++) {
            recrew[0][i] = p.val;
            p = p.next;
        }

        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size; j++) {
                recrew[i+1][(j+1)%size] = recrew[i][j] ;
            }
        }

        int minJ = 0;
        List<Long> lists = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                sb.append(recrew[i][j]);
            }
            lists.add(Long.parseLong(sb.toString()));
        }

        Long min = lists.stream().min(Comparator.comparingLong(a -> a)).get();
        int i = lists.indexOf(min);

        ListNode head = new ListNode(recrew[i][0]);
        p = head;
        for (int j = 1; j < size; j++) {
            p.next = new ListNode(recrew[i][j]);
            p = p.next;
        }

        return  head;
    }
}


class ListNode {
   int val;
   public ListNode(int val){
       this.val = val;
   }
    ListNode next = null;
 }

