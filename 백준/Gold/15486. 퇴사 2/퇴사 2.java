import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+2][2];
		for(int i = 1; i <= N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i][0] = a; // 날짜
			arr[i][1] = b; // 급여
		}
		// 입력완료
		dp = new int[N+2]; // 마지막날 1일 수행경우때문
		// 이제 dp를 할건데
		// 해당일자 상담을 했을 때 or 안했을 때(+1해주기) 2가지 경우 진행
		int max = 0;
		for(int i = 1; i <= N+1; i++) {
			// max값은 현재일자까지의 최대 보수값( 진행안하는 날도 있어서 그날을 위해 max값은 항상 최대로 갱신)
			max = Math.max(max, dp[i]);

			if(i + arr[i][0] > N+1){
				continue;
			}
			dp[i + arr[i][0]] = Math.max(dp[i+ arr[i][0]] , max + arr[i][1]); // 진행 했을 경우
		}
		// 이렇게 진행하고 맨앞에서 부터 N까지 최대값
		System.out.println(max);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

}