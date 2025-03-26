
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int max = 100000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 가는 위치에 초를 저장하자
		N = sc.nextInt();
		M = sc.nextInt();

		visited = new boolean[max + 1];
		bfs();
		System.out.println(min);
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0));

		while(!q.isEmpty()) {
			Node node = q.poll();
			visited[node.x] = true;
			if(node.x == M) min = Math.min(min, node.time);

			if(node.x * 2 <= max && !visited[node.x * 2]) q.offer(new Node(node.x * 2, node.time));
			if(node.x + 1 <= max && !visited[node.x + 1]) q.offer(new Node(node.x + 1, node.time + 1));
			if(node.x - 1 >= 0 && !visited[node.x - 1]) q.offer(new Node(node.x - 1, node.time + 1));
		}
	}

	public static class Node {
		int x;
		int time;

		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}


}