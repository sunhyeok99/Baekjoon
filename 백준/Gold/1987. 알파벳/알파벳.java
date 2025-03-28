import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				arr[i][j] = line.substring(j,j+1).charAt(0)-64;
			}
		}
		int[] cnt = new int[27]; // 1~26까지 사용
		// 0,0 부터시작해서 개수가 +1되면 더이상 가지지 못함
		cnt[arr[0][0]]++;
		ans = 0;
		dfs(0,0, cnt, 1);
		System.out.println(ans);
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void dfs(int x, int y, int[] num, int cnt){
		ans = Math.max(ans, cnt);
		// System.out.println(x +" "+ y + cnt);
		for(int in = 0 ; in < 4; in++){
			int nx = x + dx[in];
			int ny = y + dy[in];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || num[arr[nx][ny]] > 0){
				continue;
			}
			// 이게 아니면 이동 가능
			num[arr[nx][ny]]++;
			dfs(nx, ny, num, cnt+1);
			num[arr[nx][ny]]--;
		}
		return;

	}


}