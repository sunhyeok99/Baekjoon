import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static int ansX, ansY;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		ansX = sc.nextInt();
		ansY = sc.nextInt();
		arr = new int[10][9];
		visited = new boolean[10][9];
		ans =0;
		move(N , M);
		System.out.println(ans);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static int[] moveX1 = {-1, -1, 0, 0, 1, 1, 0, 0};
	public static int[] moveX2= {-1, -1, -1, 1, 1, 1, 1, -1};
	public static int[] moveX3 = {-1, -1, -1, 1, 1, 1, 1, -1};
	public static int[] moveY1 = {0, 0, 1, 1, 0, 0, -1, -1};
	public static int[] moveY2 = {-1, 1, 1, 1, 1, -1, -1, -1};
	public static int[] moveY3 = {-1, 1, 1, 1, 1, -1, -1, -1};
	public static void move(int i, int j){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{i, j, 0});
		visited[i][j] = true;
		// 이제 움직임
		while(!q.isEmpty()){
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.poll()[2];
			if(x == ansX && y == ansY){
				ans = cnt;
				return;
			}
			for(int in = 0 ; in < 8 ; in++){
				int nx1 = x + moveX1[in];
				int ny1 = y + moveY1[in];
				if(nx1 >= 10 || ny1 >= 9 || nx1 < 0 || ny1 < 0 || (ansX == nx1 && ansY == ny1)){
					continue;
				}
				int nx2 = nx1 + moveX2[in];
				int ny2 = ny1 + moveY2[in];
				if(nx2 >= 10 || ny2 >= 9 || nx2 < 0 || ny2 < 0 || (ansX == nx2 && ansY == ny2)){
					continue;
				}
				int nx3 = nx2 + moveX3[in];
				int ny3 = ny2 + moveY3[in];
				if(nx3 >= 10 || ny3 >= 9 || nx3 < 0 || ny3 < 0 || visited[nx3][ny3]){
					continue;
				}
				q.add(new int[]{nx3, ny3, cnt+1});
				visited[nx3][ny3] = true;
			}


		}



	}


}