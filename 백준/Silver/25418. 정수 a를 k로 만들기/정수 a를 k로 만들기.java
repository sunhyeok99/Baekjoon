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
	static Queue<node> q;
	static int tmp;

	static int A, B;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		// N에서 M까지 달성하기
		q = new LinkedList<>();
		q.add(new node(N, 0));

		ans = 0;
		visited = new boolean[1000001];
		visited[0] = true;
		while (!q.isEmpty()) {
			node n = q.poll();
			// 2가지로 방향
			if(n.x == M){
				ans = n.cnt;
				break;
			}
			int next = n.x + 1;
			if(next < 1000001 && !visited[next]) {
				visited[next] = true;
				q.add(new node(next, n.cnt +1));
			}
			next = n.x *2;
			if(next < 1000001 && !visited[next]) {
				visited[next] = true;
				q.add(new node(next, n.cnt +1));
			}

		}
		System.out.println(ans);
	}

	public static int[] dx = {1, -1, 0, 0,-1,-1,1,1};
	public static int[] dy = {0, 0, 1, -1,-1,1,-1,1};

	static class node{
		int x, cnt;
		node(int x, int cnt){
			this.x = x;
			this.cnt = cnt;
		}
	}


}