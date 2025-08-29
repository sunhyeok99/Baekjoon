import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dp;
	static Queue<node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 흔한 dfs or bfs
		// 클래스 만들어서 좌표와 몇번 움직였는지, k가 얼마남았는지 저장해서 큐로 돌림

		visited = new boolean[N][M][K + 1];
		ans = Integer.MAX_VALUE;
		bfs();
		if(ans==Integer.MAX_VALUE){
			ans = -1;
		}
		System.out.println(ans);
	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2}; //말이 이동할 수 있는 8방향
	static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};

	public static class node {
		int x, y, cnt, k;

		public node(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}

	}

	public static void bfs() {
		// 좌표에서 시작 , 장애물 있는곳 못감 + 방문처리
		visited[0][0][K] = true;
		q.add(new node(0, 0, 0, K));

		while (!q.isEmpty()) {
			node n = q.poll();
			if (n.x == N - 1 && n.y == M - 1) {
				ans = Math.min(ans, n.cnt);
			}
			// 4방향 탐문 시작 + k방문처리
			for (int in = 0; in < 4; in++) {
				int nx = n.x + dx[in];
				int ny = n.y + dy[in];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != 0 || visited[nx][ny][n.k])
					continue;

				// 방문처리 + 큐추가
				visited[nx][ny][n.k] = true;
				q.add(new node(nx, ny, n.cnt + 1, n.k));
			}
			// 말이 이동할 수 있는자리 이동
			if (n.k > 0) {
				for (int in = 0; in < 8; in++) {
					int nx = n.x + hdx[in];
					int ny = n.y + hdy[in];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != 0 || visited[nx][ny][n.k - 1])
						continue;

					visited[nx][ny][n.k - 1] = true;
					q.add(new node(nx, ny, n.cnt + 1, n.k - 1));
				}
			}

		}

	}

}