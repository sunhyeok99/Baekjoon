import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[] arr;
	static int[][] map;
	static boolean[] visited;
	static boolean[][] flag;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static int ansX, ansY;
	static PriorityQueue<Integer> q;
	static int tmp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++){
			String tmp = sc.next();
			for(int j = 0 ; j < M  ; j++){
				map[i][j] = Integer.parseInt(tmp.substring(j,j+1));
			}
		}
		flag = new boolean[N][M];
		// N이 0인애들에서 시작해서 n이 n-1이 나오면 끝
		for(int i = 0 ; i < M ; i++){
			if(map[0][i] == 0 && !flag[0][i]){
				flag[0][i] = true;
				dfs(0,i);
			}
		}

		System.out.println("NO");

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void dfs(int x, int y){
		if(x == N-1){
			System.out.println("YES");
			System.exit(0);
		}
		for(int in = 0 ; in< 4 ;in++){
			int nx = x + dx[in];
			int ny = y + dy[in];
			if(nx >=N || ny >= M || nx<0 || ny <0 || map[nx][ny] == 1 || flag[nx][ny]){
				continue;
			}
			flag[nx][ny] = true;
			dfs(nx, ny);
		}



	}


}