import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] dp = new int[N+1];
		
		// 해당 N을 포함했을때랑 안했을 때 max값 다 계산?
		int[] day = new int[N];
		int[] cost = new int[N];
		for(int i = 0 ; i < N;i++) {
			day[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}
		// 각자 입력 끝
		for(int i = 0 ; i < N;i++) {
			// 0번째부터 시작
			// N보다 작다면 얘랑 비교해서
			if(i + day[i] <= N) {
				// 현재를 포함할때랑 안했을때 비교
				dp[i + day[i]] = Math.max(dp[i+ day[i]], dp[i] + cost[i]); 
			}
			// 다음꺼는 현재까지 진행했던 값들중 최대값으로 비교 -> 현재 아무것도 안함을 의미
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			
		}
		System.out.println(dp[N]);
		
		
	}
	
	
}
