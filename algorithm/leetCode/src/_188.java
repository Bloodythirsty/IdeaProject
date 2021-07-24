public class _188 {
    public static void main(String[] args) {
        int[] arr = {2,4,1};
        int k=2;
        maxProfit(k,arr);
    }

    public static int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1 ) return 0;
        int[][] state = new int[k+1][2];
        state[1][0] = -prices[0];
        state[1][1] = 0;

        for(int i=1;i<prices.length;i++){
            for(int j=1;j<k;j++){
                // int newBuy = state[j][0], newShell = state[j][1];
                if(j==1){
                    state[j][0] = Math.max(state[j][0],-prices[i]);
                    state[j][1] = Math.max(state[j][1],state[j][0]+prices[i]);
                }else{
                    state[j+1][0] = Math.max(state[j+1][0], state[j][1] - prices[i]);
                    state[j+1][1] = Math.max(state[j+1][1], state[j+1][0]+prices[i]);
                }
            }
        }
        return state[k][1];
    }
}
