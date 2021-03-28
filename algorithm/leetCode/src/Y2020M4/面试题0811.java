package Y2020M4;

public class 面试题0811 {
    public static void main(String[] args) {
        System.out.println(waysToChange(9));
    }
    public static int waysToChange(int n) {
        int[] coins = {1,5,10,25};
        int[] f = new int[n+1];
        f[0] = 1;

        //开始，注意开始下标
        for(int j = 0; j < coins.length; j++){
                for(int i = 1 ; i <= n;i++){
                    if(i>=coins[j]){
                    f[i] += f[i-coins[j]];
                }
            }
        }
        return f[n];
    }
}
