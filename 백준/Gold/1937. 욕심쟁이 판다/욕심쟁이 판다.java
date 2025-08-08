import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		//판다를 놓았을때 그 지점에서 시작해서
		// 점차 움직일 수 있는 칸이 많아야한다.

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		ans =0;
		dp = new int[N][N];
		// 모든 지점에서 모두 시행
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				ans = Math.max(ans ,solve(i, j));
			}
		}
		System.out.println(ans);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static int solve(int x, int y){
		// dfs를 돌면서 만약 중간에 값이 0이 아닐경우에는
		// 그 좌표의 dp 값을 리턴
		if(dp[x][y] != 0) return dp[x][y];

		// 해당 좌표에서 판다가 사는 것을 의미하므로 좌표 1을 설정
		dp[x][y] = 1;

		// 이동할 수 있는 좌표로 이동
		for(int idx = 0 ; idx < 4 ; idx++){
			int nx = x + dx[idx];
			int ny = y + dy[idx];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[x][y] >= arr[nx][ny]) continue;

			dp[x][y] = Math.max(dp[x][y] , solve(nx,ny) +1);

		}

		return dp[x][y];
	}

}