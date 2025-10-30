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
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		// 하나의 지점이 다른 값일 경우 그 지점을 시작으로 인접값들 새로운 값으로 교체
		// 두개 이상일 경우 no
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		ans = 0;
		int[][] tmp = new int[N][M];
		// 이제 다른값 찾기
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmp[i][j] = sc.nextInt();
				if(arr[i][j] != tmp[i][j] && !visited[i][j] && !flag) {
					solve(i,j, arr[i][j], tmp[i][j]);
					flag = true;
				}
			}
		}
		// 이게 반례중에 뒷부분만 바뀌고 앞부분이 그대로라면
		// 내 로직은 앞부분때문에 Yes가 나와버림(정답은 NO)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] != tmp[i][j]){
					ans ++;
				}
			}
		}
		if(ans > 0){
			System.out.println("NO");
		}
		else{
			System.out.println("YES");
		}


	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void solve(int i , int j, int now, int next){
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(i);
		qy.add(j);
		arr[i][j] = next;
		visited[i][j] = true;

		while(!qx.isEmpty()){
			int x = qx.poll();
			int y = qy.poll();
			for(int in = 0; in < 4; in++) {
				int nx = x + dx[in];
				int ny = y + dy[in];
				if(nx >= N || ny >= M || nx < 0 || ny < 0 || arr[nx][ny] != now || visited[nx][ny]) continue;
				// 다 next로 교체
				arr[nx][ny] = next;
				qx.add(nx);
				qy.add(ny);
				visited[nx][ny] = true;
			}

		}



	}


}