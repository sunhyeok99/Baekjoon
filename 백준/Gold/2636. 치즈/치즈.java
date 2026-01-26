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
	static ArrayList<Integer> ar[];
	static int ansX, ansY;
	static Queue<int[]> q;
	static int tmp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// 우선 입력 다받고
		// 치즈 내부의 공기층은 2로 입력받는다.
		// 처음 시도에서는 0과 닿아있는 치즈들 모두 큐에 넣고
		// 한번에 0으로 바꿔주면서 날짜 +1
		// 치즈 한번 바꾼 이후에는 치즈 내부 2들이 0과 닿아있는지 확인

		N = sc.nextInt();
		M = sc.nextInt();
		tmp = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					tmp++;
				}
			}
		}
		// 입력은 끝
		// 0,0에서 시작해서 치즈를 만날때 큐에다가 넣고 한번에 바꿈
		q = new LinkedList<>();
		int day = 0;
		ans = 0;
		while (tmp > 0) {
			// 0,0에서 시작
			flag = new boolean[N][M];
			solve(0, 0);
			// 큐 비우는 작업
			day++;
			ans = q.size();
			tmp -= q.size();
			empty();
		}
		System.out.println(day);
		System.out.println(ans);

	}

	public static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
	public static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};

	public static void solve(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || flag[nx][ny])
				continue;
			// 1인경우만 큐에 추가
			flag[nx][ny] = true;
			if (map[nx][ny] == 1) {
				q.add(new int[] {nx, ny});
			} else {
				solve(nx, ny);
			}
		}

	}

	public static void empty() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			map[x][y] = 0;
		}
	}

}