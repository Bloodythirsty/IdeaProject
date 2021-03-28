package niuKe;

import org.junit.Test;

public class TopK {
    public int quickSort(int[] a,int start,int end,int K){
        int pivot = a[start];
        int low = start;
        int high = end;
        while(low<high){
            while((low<high)&&(a[high] <=pivot))
                high--;
            a[low] = a[high];
            while((low<high)&&(a[low] >=pivot))
                low++;
            a[high] = a[low];
        }
        a[low]=pivot;
        //再次查找
        if(low == (K-1)) return a[low];
        else if(low > (K-1)) return quickSort(a,start,low-1,K);
        // 下面是end，而不是high！！！！！！！！！
        // else return quickSort(a,low+1,high,K);
        else return quickSort(a,low+1,high,K);
    }

    public void quickSort_111(int[] a,int start,int end,int K){
        if (start >= end) return;
        int pivot = a[start];
        int low = start;
        int high = end;
        while(low<high){
            while((low<high)&&(a[high] <=pivot))
                high--;
            a[low] = a[high];
            while((low<high)&&(a[low] >=pivot))
                low++;
            a[high] = a[low];
        }
        a[low]=pivot;
        //再次查找
        quickSort_111(a,start,low-1,K);
        quickSort_111(a,low+1,end,K);
    }

    @Test
    public  void test(){
        // int[] a = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        int[] a = {3,1,2,5,6,1,3,1,2};
        quickSort_111(a, 0, a.length-1, 3);
        for (int i1 = 0; i1 < a.length; i1++) {
            System.out.print(i1+" ");
        }
    }
}
/*

        while(low<high){
            while((low<high)&&(a[high] <pivot))
                high--;
            a[low] = a[high];
            while((low<high)&&(a[low] >pivot))
                low++;
            a[high] = a[low];
        }
        问题：3,1,2,5,6,1,3,1,2
        当查找这个数组时，while会进入无限循环，因为 high=6(在右边的3时)，pivot=3，3和3交换，数组没变！！
        同理，low=0（3）时，交换了high=6(3)，数组还是没变！
 */