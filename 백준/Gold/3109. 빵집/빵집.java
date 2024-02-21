import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] dir;
	static int ans;
	static boolean[][] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		flag = new boolean[N][M];
		dir = new int[N][M];
		for(int i = 0;i<N;i++) {
			String tmp = sc.next();
			for(int j =0;j<M;j++) {
				if(tmp.substring(j,j+1).equals("x")) {
					arr[i][j] = 1;
				}
			}
		}
		// dfs를 통해서 하나씩 계싼
		// 만약 true처리되면 ans++ , 아니면 flag자리 다시 false
		ans = 0;
		
		for(int i =0;i<N;i++) {
			if(solve(i,0)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};

	public static boolean solve(int x, int y) {
		flag[x][y] = true;
		// 먼저 방문처리를 함
		if(y == M-1) {
			return true;
		}
		for(int in = 0; in<3;in++) {
			int nx = x + dx[in];
			int ny = y + dy[in];
			if(nx>=0 && nx <N && arr[nx][ny] ==0 && !flag[nx][ny] && solve(nx,ny)) {
				return true;
			}
		}
		return false;
	}


}