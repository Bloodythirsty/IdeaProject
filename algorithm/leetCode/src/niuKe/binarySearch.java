package niuKe;

import org.junit.Test;

public class binarySearch {
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int low = 0,heigh = n-1,middle = (n)/2;
        while(low<=heigh){
            if(a[middle]==v){
//                 while(((--middle)>0) && a[middle]==v);
//                 return middle+1;
                while(middle>=0){
                    if(a[middle] != v) break;
                    middle--;
                }
                return middle+2;
            }
            else if(a[middle] > v) heigh=middle-1;
            else if(a[middle] < v) low = middle+1;
            middle = (low + heigh)/2;
        }
        return n+1;
    }

    @Test
    public void test(){
        int[] a= {2,3,4,4,4,7,7,8,10,10,11,12,13,14,15,15,17,18,19,23,24,24,24,24,25,26,26,26,27,27,28,29,29,30,33,36,38,38,40,40,41,43,43,43,44,46,46,47,51,52,52,53,54,56,57,57,57,58,58,61,61,61,62,64,64,66,66,67,67,67,70,72,74,74,74,75,75,78,78,78,79,79,80,83,83,83,83,84,84,86,88,89,89,90,91,91,92,93,93,96};
        int i = upper_bound_(100, 93, a);
        System.out.println("i = " + i);
    }
}
