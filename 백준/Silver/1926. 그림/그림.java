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

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i = 0 ; i < N ; i++){
			for(int j= 0 ; j< M ; j++ ){
				arr[i][j] = sc.nextInt();
			}
		}
		// 1을 찾아서 큐에다 넣고 bfs를 돌려서
		// 최대 넓이 갱신
		int count = 0;
		ans = 0;
		visited = new boolean[N][M];

		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j< M ; j++ ){
				if(arr[i][j] == 1 && !visited[i][j]){
					count++;
					solve(i,j);
				}
			}
		}
		System.out.println(count);
		System.out.println(ans);


	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void solve(int i, int j ){
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(i);
		qy.add(j);
		visited[i][j] = true;
		int width = 1;
		while(!qx.isEmpty()){
			int x = qx.poll();
			int y = qy.poll();
			for(int in = 0 ; in < 4 ;in++){
				int nx = x + dx[in];
				int ny = y + dy[in];
				if(nx < 0 || ny < 0 || nx>=N || ny >= M || arr[nx][ny] == 0 || visited[nx][ny]){
					continue;
				}
				visited[nx][ny] = true;
				qx.add(nx);
				qy.add(ny);
				width++;
			}
		}
		ans = Math.max(ans, width);
	}

}