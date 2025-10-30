import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[] arr;
	static boolean[] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 0에서 시작해서 N-1까지 이동
		// 각 dfs하면서 중간에 좌표 저장해서 도전
		dp = new int[N+ 100];
		ans = -1;
		for(int i = 0; i < N; i++) {
			dp[i] = 987654321;
		}
		dp[0] = 0;
		for(int i = 0 ; i < N-1; i++){
			for(int j = 1 ; j <= arr[i] ; j ++){
				int nx = j + i;
				dp[nx] = Math.min(dp[nx] , dp[i] + 1);
			}
		}
		if(dp[N-1] == 987654321){
			System.out.println(-1);
		}
		else{
			System.out.println(dp[N-1]);
		}

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};


}