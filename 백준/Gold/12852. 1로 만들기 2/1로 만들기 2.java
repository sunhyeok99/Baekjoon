import java.util.*;
	import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[] arr;
	static boolean[] visited;
	static int[] dp;
	static int[] selected;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// dp
		N = sc.nextInt();
		// 역으로 3 곱 or 2 곱 or +!해서 N이 최소값일때 확인
		dp = new int[N+1];

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1; // 1을 빼는 연산
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 현재값이 2에서왔을때
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 현재값이 3에서 왔을떄
		}

		System.out.println(dp[N]);

		// 이제 경로추적
		while(N > 0){
			// 현재 N의값에서 시작해서
			// 각값이랑 dp에 저장된 횟수가 같다면 출력
			System.out.print(N +" ");
			// 각자 실행
			if(N == 1){
				break;
			}
			if(N %3 == 0 && (dp[N/3] == dp[N]-1)){
				N/=3;
			}
			else if(N%2 == 0 && (dp[N/2] == dp[N]-1)){
				N/=2;
			}
			else{
				N-=1;
			}

		}



	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};




}