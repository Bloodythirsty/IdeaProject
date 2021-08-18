import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int[] nkiller = new int[n];
        // int[] nFire = new int[n];
        int m = sc.nextInt();
        // int[] mkiller = new int[m];
        // int[] mFire = new int[m];
        int k = sc.nextInt();

        long nAllFiles = countAllFile(sc, n, k);
        long mAllFiles = countAllFile(sc, m, k);

        System.out.println(nAllFiles + " " + mAllFiles);
        if (nAllFiles > mAllFiles){
            System.out.println("A");
        }else {
            System.out.println("B");
        }
    }

    private static long countAllFile(Scanner sc, int n, int k) {
        long iRes = 0;
        for (int i = 0; i < n; i++) {
            int iKiller =  sc.nextInt();
           int iFile = sc.nextInt();
           if (iFile >= k){
               iRes = iKiller * iFile + iRes;
           }
        }
        return iRes;
    }
}
