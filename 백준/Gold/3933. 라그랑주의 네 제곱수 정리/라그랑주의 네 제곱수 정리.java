
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        // 숫자가 하나씩 늘떄마다 그전수의 값을 이용 가능 ( 5가 2개로 했다면 6은 3개로 만드는 식)
        // 미리 계산해놓고 숫자 들어오면 리턴해주자

        //각 칸은 2의15승보다 작음
        int[][] dp = new int[32800][5];

        for (int i = 1; i * i < 32800; i++) {
            dp[i * i][1] = 1;

            for (int j = i * i; j < 32800; j++) {
                dp[j][2] += dp[j - i * i][1];
                dp[j][3] += dp[j - i * i][2];
                dp[j][4] += dp[j - i * i][3];
            }
        }
        while(true) {
            int n = sc.nextInt();
            // 0입력시 종료
            if(n==0){
                break;
            }
            int ans =0;
            for (int i = 1; i <= 4; i++) {
                ans += dp[n][i];
            }

            System.out.println(ans);
        }



    }

}
