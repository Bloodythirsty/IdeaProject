import java.util.*;

public class TXtest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nUsers = sc.nextInt();
        int kMails = sc.nextInt();
        int[] times = new int[nUsers];
        int[] res = new int[kMails];

        for (int i = 0; i < nUsers; i++) {
            times[i] = sc.nextInt();
        }

        int kThMail = 0;
        for (int i = 1; ; i++) {
            if (kMails == kThMail) break;
            for (int j = 0; j < nUsers; j++) {
                if (kMails == kThMail) break;
                if (i % times[j] == 0){
                    res[kThMail++] = j;
                }
            }
        }

        for (int re : res) {
            System.out.println(re+1);
        }

    }
}
