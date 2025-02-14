import java.util.*;

public class Main {

    static int N,M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp=new int[M+1];

        for(int i=1;i<=M;i++){
            dp[i]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=N;i++){
            for(int j=arr[i];j<=M;j++){
                dp[j]=Math.min(dp[j],dp[j-arr[i]]+1);
            }
        }

        if(dp[M]==Integer.MAX_VALUE-1)
            System.out.println(-1);
        else
            System.out.println(dp[M]);



    }
}
