import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static long[] dist;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		graph = new ArrayList[N];
		dist = new long[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Long.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		long result = dijkstra();
		System.out.println(result);
	}

	static class Node implements Comparable<Node> {
		int v;
		long cost;

		Node(int v, long cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	static long dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		dist[0] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			// 이미 더 짧은 경로가 있으면 스킵
			if (cur.cost > dist[cur.v]) continue;

			// 넥서스 도착 → 최단거리 확정
			if (cur.v == N - 1) return cur.cost;

			for (Node next : graph[cur.v]) {
				// 넥서스 제외 시야 체크
				if (next.v != N - 1 && arr[next.v] == 1) continue;

				long newCost = cur.cost + next.cost;

				if (newCost < dist[next.v]) {
					dist[next.v] = newCost;
					pq.add(new Node(next.v, newCost));
				}
			}
		}

		return -1;
	}
}
