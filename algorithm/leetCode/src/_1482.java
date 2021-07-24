public class _1482 {

    // 875 1011

    public static void main(String[] args) {
        int[] arr = {7,7,7,7,12,7,7};
        minDays(arr,2,3);
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)return -1;
        int low=1,high=1;
        for(int i:bloomDay){
            high=Math.max(high,i);
        }
        /*
            1. 此处只要 m*k > bloomDay.length， 就一定能选出来
            2. 因此，low==high时候，就不用多遍历一次了
            3. 成功后，可能还有更小的天数，因此 high=mid，继续查找一遍
         */
        while(low<high){
            int mid=low+(high-low)/2;
            if(isSuccess(bloomDay,mid,m,k)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return high;
    }

    public static boolean isSuccess(int[] bloomDay,int days,int m,int k){
        int sum=0,flowers=0;
        for(int i=0;i<bloomDay.length&&sum<m;i++){
            if(bloomDay[i]<=days){
                flowers++;
                if(flowers==k){
                    sum++;
                    flowers=0;
                }
            }else{
                flowers=0;
            }
        }
        return sum>=m;
    }
}
