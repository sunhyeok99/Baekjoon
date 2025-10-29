import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		// M명을 늘리기 위해 투자해야하는 금액
		arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		dp = new int[1101]; // 1~ 1100
		// 1부터 M까지 진행하는데
		// 만약 i번째-arr[i][0]값이 0이상이라면
		// Math값 비교
		for(int i = 1; i < dp.length; i++) {
			dp[i] = 987654321;
		}
		// M까지가 아니라 1000의 최대값 1100까지해야함
		for(int i = 1 ; i <dp.length; i++){
			for(int j = 0 ; j < N ; j ++){
				int cnt = arr[j][0];
				int num = arr[j][1];
				if(i - num < 0){
					continue;
				}
				dp[i] = Math.min(dp[i - num] + cnt , dp[i]);
			}

		}
		ans = 987654321;
		for(int i = M ; i < dp.length ; i++) {
			ans = Math.min(ans, dp[i]);
		}
		System.out.println(ans);
	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};



}