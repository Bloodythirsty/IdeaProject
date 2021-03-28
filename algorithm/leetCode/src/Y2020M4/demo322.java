package Y2020M4;

public class demo322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] f = new int[amount+1];
        int length = coins.length;

        f[0] = 0;

        int i,j;
        for( i = 1 ; i < amount ; i++){
            f[i] = Integer.MAX_VALUE;
            for(j = 0 ; j < length; j++){
                if( i >= coins[j] && f[i-coins[j]] != Integer.MAX_VALUE)
                    f[i] = Math.min(f[i-coins[j]]+1,f[i]);
            }
        }

        if(f[amount] == Integer.MAX_VALUE){
            f[amount] = -1;
        }
        return f[amount];
    }
}
