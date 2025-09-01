import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dp;

	static int tmp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// 1. 컨트롤 c 저장
		// 2. 붙여넣기
		// 3. 화면에서 1개 삭제

		// 1개에서 시작해서 S개가 되기까지 -> bfs 진행하면 될듯(방문처리 필수)
		// 숫자 늘리는 저장+ 붙여넣기는 2초걸림
		// 1개삭제는 1초걸림

		// 저장되어있는 클립보드 개수를 따로 관리
		N = sc.nextInt();
		visited = new boolean[2002][2002];
		ans = 0;
		bfs();
		System.out.println(ans);
	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void bfs() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(1, 0, 0));
		while (!q.isEmpty()) {
			//  3가지 각각 실행
			node n = q.poll();
			if (n.num == N) {
				ans = n.time;
				break;
			}
			if (n.num > 1000 || n.num < 1) {
				continue;
			}
			// 3가지 이제 실행

			// 저장
			if(!visited[n.num][n.num]) {
				q.add(new node(n.num, n.num, n.time + 1));
				visited[n.num][n.num] = true;
			}

			if (n.stack != 0 && !visited[n.num + n.stack][n.stack]) {
				q.add(new node(n.stack + n.num, n.stack, n.time + 1));
				visited[n.num+ n.stack][n.stack] = true;
			}
			if (!visited[n.num - 1][n.stack]) {
				q.add(new node(n.num - 1, n.stack, n.time + 1));
				visited[n.num-1][n.stack] = true;
			}

		}

	}

	static class node {
		int num;
		int stack;
		int time;

		node(int num, int stack, int time) {
			this.num = num;
			this.stack = stack;
			this.time = time;
		}

	}

}