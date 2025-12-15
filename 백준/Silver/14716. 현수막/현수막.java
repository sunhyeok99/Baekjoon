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
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 1을발견하고 한번 실행시마다 주변 다 0으로 바꾸고
		// 좌표다 큐에 추가
		ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					solve(i, j);
					ans++;
				}
			}
		}

		System.out.println(ans);

	}

	public static int[] dx = {1, -1, 0, 0,-1,-1,1,1};
	public static int[] dy = {0, 0, 1, -1,-1,1,-1,1};

	public static void solve(int a , int b){
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(a);
		qy.add(b);
		while(!qx.isEmpty()){
			int x = qx.poll();
			int y = qy.poll();
			for(int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>= N || ny >= M || nx < 0 || ny < 0 || map[nx][ny] == 0) continue;
				qx.add(nx);
				qy.add(ny);
				map[nx][ny] = 0;
			}

		}



	}

}