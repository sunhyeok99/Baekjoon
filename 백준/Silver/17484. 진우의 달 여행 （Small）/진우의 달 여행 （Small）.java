import java.util.*;

public class Main {
    static int N,M;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1][M];
        int[][][] dp = new int[N][M][3];
        // dy에 해당하는 값을 3번째 배열 값으로 설정
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                Arrays.fill(dp[i][j], (int)1e9);
            }
        }
        for(int j = 0; j < M; j++) {

            dp[0][j][0] = arr[0][j];
            dp[0][j][1] = arr[0][j];
            dp[0][j][2] = arr[0][j];
        }
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(j == 0) {
                    // 가장 왼쪽항은 직선 or 대각선왼쪽 두가지 방법만 가능
                    // 1. 직선의 경우에는 그 전에 대각선만 허용
                    // 2. 대각선의 경우에는 대각선오른쪽 or 직선의 경우에만 가능
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + arr[i][j];
                } else if(j == M - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + arr[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + arr[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + arr[i][j];
                }
            }
        }
        int min = (int)1e9;
        for(int j = 0; j < M; j++) {
            for (int i = 0; i < 3; i++) {
                min = Math.min(min, dp[N - 1][j][i]);
            }
        }
        System.out.println(min);


    }

}