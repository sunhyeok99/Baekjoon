import java.util.*;
import java.io.*;

public class Main {
	static int N, M ;
	static int ans;
	static int[] arr;
	static int[][] dp;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// dp 문제인데
		// 처음부터 시작해서
		// 1일권, 3일권, 5일권 각각 살때를 더하고
		// 그 다음날부터 계산
		arr = new int[N+1];
		for(int i = 1; i <= M; i++){
			arr[sc.nextInt()] = 1;
		}
		// 1로 차있는날은 불가능한 날

		dp = new int[N+1][N+1];
		for(int i=0; i<N+1; i++) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println(solve(1, 0));
	}

	static int solve(int day, int coupon){
		if(day > N) {
			return 0;
		}
		if(dp[day][coupon] != -1) return dp[day][coupon];

		dp[day][coupon] = Integer.MAX_VALUE;
		if(arr[day] == 1) {
			return dp[day][coupon] = Math.min(dp[day][coupon], solve(day+1, coupon));
		}
		else {
			if(coupon >= 3 ) {
				dp[day][coupon] = Math.min(dp[day][coupon], solve(day+1, coupon-3));
			}
			dp[day][coupon] = Math.min(dp[day][coupon], solve(day+1, coupon)+ 10000);
			dp[day][coupon] = Math.min(dp[day][coupon], solve(day+3, coupon+1) +25000);
			dp[day][coupon] = Math.min(dp[day][coupon], solve(day+5, coupon+2) + 37000);

		}

		return dp[day][coupon];


	}


}