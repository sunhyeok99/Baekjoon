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
		map = new int[N][N];
		flag = new boolean[N][N];
		int x = sc.nextInt();
		int y = sc.nextInt();
		ansX = sc.nextInt();
		ansY = sc.nextInt();
		ans = -1;

		bfs(x, y);
		System.out.println(ans);
	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static int[] mx = {-2, -2, 0, 0, 2, 2};
	public static int[] my = {-1, 1, -2, 2, -1, 1};

	public static void bfs(int stx ,int sty){
		Queue<node> qx = new LinkedList<>();
		qx.add(new node(stx, sty, 0));
		flag[stx][sty] = true;

		while(!qx.isEmpty()){
			node n = qx.poll();
			if(n.x == ansX && n.y == ansY){
				ans = n.cnt;
				return;
			}
			for(int i = 0 ; i < mx.length ; i++){
				int nx = n.x + mx[i];
				int ny = n.y + my[i];
				if(nx >= N || ny >= N || nx < 0 || ny < 0 || flag[nx][ny]){
					continue;
				}
				qx.add(new node(nx, ny, n.cnt + 1));
				flag[nx][ny] = true;
			}

		}

	}
	public static class node{
		int x, y, cnt;
		node(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}