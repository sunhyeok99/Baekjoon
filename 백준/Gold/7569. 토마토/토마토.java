import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][][] arr;
	static int[] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static Queue<node> q;
	static int count;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();

		arr = new int[N][M][K];
		q = new LinkedList<node>();
		count = 0;
		for (int k = 0; k < K; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j][k] = sc.nextInt();
					if (arr[i][j][k] == 1) {
						q.add(new node(i, j, k, 0));
						count++;
					}
					if(arr[i][j][k] == -1) {
						count++;
					}
				}
			}
		}
		// 입력부터 1인 애들은 큐에다가 넣음
		// 하루가 지날때마다 6방향으로 퍼져가며, 새롭게 익는애들을 큐에다가 추가해줌
		ans = 0;
		solve();
		if (count != N * M * K) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	public static int[] dx = {1, -1, 0, 0, 0, 0};
	public static int[] dy = {0, 0, 1, -1, 0, 0};
	public static int[] dk = {0, 0, 0, 0, 1, -1};

	static class node {
		int x, y, z, day;

		node(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}

	}

	static void solve() {
		while (!q.isEmpty()) {
			node n = q.poll();
			// 일단 최대값을 갱신하고
			// 이 좌표에서 퍼져갈 수 있는 0인지점으로 퍼져가면서 큐에추가
			ans = Math.max(ans, n.day);
			for (int in = 0; in < 6; in++) {
				int nx = n.x + dx[in];
				int ny = n.y + dy[in];
				int nk = n.z + dk[in];
				if (nx < 0 || ny < 0 || nk < 0 || nx >= N || ny >= M || nk >= K || arr[nx][ny][nk] != 0) {
					continue;
				}
				arr[nx][ny][nk] = 1;
				q.add(new node(nx, ny, nk, n.day + 1));
				count++;
			}

		}

	}

}