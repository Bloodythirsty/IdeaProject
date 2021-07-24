public class _offer56 {
    public static void main(String[] args) {
        int[] arr = {3,4,3,3};
        singleNumber(arr);
    }

    public static int singleNumber(int[] nums) {
        int[] mutl = new int[32];
        for(int num:nums){
            for(int i=0;i<32;i++){
                if((num & (1<<i)) != 0){
                    mutl[i]++;
                }
            }
        }

        int res = 0;
        for(int i=0;i<32;i++){
            if(mutl[i] % 3 != 0){
                res |= (1<<i);
            }
        }
        return res;
    }
}
