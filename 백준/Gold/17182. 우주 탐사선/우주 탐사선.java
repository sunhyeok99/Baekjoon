import java.util.*;
import java.io.*;

public class Main {
	static int N, M ;
	static int ans;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// +거리 단축시켜주기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(arr[i][k] + arr[k][j] < arr[i][j]){
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		// 하나씩 시작
		visited = new boolean[N];
		visited[M] = true;
		ans = Integer.MAX_VALUE;
		solve(M, 0, 1);
		System.out.println(ans);


	}
	public static void solve(int num, int dis, int cnt){
		if(cnt == N){
			ans = Math.min(dis, ans);
			return;
		}

		// num부터 시작해서
		// 방문안한곳으로 dfs 실행
		for(int i = 0; i < N; i++) {
			if(visited[i]){
				continue;
			}
			visited[i] = true;
			solve(i, dis + arr[num][i], cnt+1);
			visited[i] = false;
		}

	}

}