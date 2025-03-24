import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] dp = new int[10001][4]; // 숫자는 10000까지
		dp[1][1] = 1; // 1
		dp[2][1] = 1; // 1 + 1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 1+ 1 + 1
		dp[3][2] = 1; // 1 + 2
		dp[3][3] = 1; // 3
		for(int i = 4 ; i < 10001;i++){
			dp[i][1] = dp[i-1][1]; // 1을 더하는 경우
			dp[i][2] = dp[i-2][1] + dp[i-2][2]; // 2를 더하는 경우 ( 2 단독 or 1 + 1)
			dp[i][3] = dp[i-3][3] + dp[i-3][2] + dp[i-3][1];
		}
		for(int tc = 0 ;  tc< T ; tc++){
			int num = sc.nextInt();
			System.out.println(dp[num][1]+dp[num][2]+dp[num][3]);
		}



	}

}