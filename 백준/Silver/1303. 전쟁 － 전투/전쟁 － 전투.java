import java.util.*;

public class Main {
	static int N, M ;
	static boolean[][] visited;
	static int[] count;
	static int[][] arr;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				String tmp = line.substring(j, j+1);
				if(tmp.equals("W")){
					arr[i][j] = 1;
				}
				else{
					arr[i][j] = 2;
				}
			}
		}
		int ans1 = 0;
		int ans2 = 0;
		visited = new boolean[N][M];
		// bfs로 개수 count
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) {
					continue;
				}
				int tmp = bfs(i,j,arr[i][j]);
				if(arr[i][j] == 1) {
					ans1 += tmp *tmp;
				}
				else{
					ans2+=tmp*tmp;
				}
			}
		}

		System.out.println(ans1 +" "+ ans2);


	}
	public static int bfs(int i , int j, int price){
		// i, j부터 시작
		int cnt = 1;
		visited[i][j] = true;
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(i);
		qy.add(j);
		while(!qx.isEmpty()){
			int x = qx.poll();
			int y = qy.poll();
			for(int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx <0 || ny <0 || nx >= N || ny >= M || visited[nx][ny] || arr[nx][ny] !=price) continue;
				qx.add(nx);
				qy.add(ny);
				visited[nx][ny] = true;
				cnt ++;
			}
		}
		return cnt;
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};



}