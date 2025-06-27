import java.util.*;

public class Main {
	static int N, M ;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 우선순위 큐해서 거리의 차이 - 거리 해서 얼만큼 이익나는지 내림차순해서 먼저 선정해도 될듯
		// 그러면 적용못하는 경우가 있을 수 있으므로 -> dp를 해보자
		int[][] arr = new int[N][3];
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}
		int [] dp = new int[M+1];
		for(int i = 0; i < M+1; i++) {
			dp[i] = i;
		}
		// 1~10000까지 넣어놓음
		for(int i = 1;i<=M;i++){
			// 1~10000까지 길중에서 도착지점이 i인 점을 기준으로
			// dp 실행
			dp[i] = Math.min(dp[i], dp[i-1] +1);
			for(int j = 0;j<N;j++){
				if(arr[j][1] == i){
					dp[i] = Math.min(dp[i], dp[arr[j][0]] + arr[j][2]);
				}
			}
		}

		System.out.println(dp[M]);

	}

}