import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][] low;
	static int min;
	static Queue<node> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		// 0,0에서 N-1, M-1까지 이동
		// 이동하는 중에 최소 몇개 부셔야하는지
		// class 하나 만들어서 몇개부셨는지 확인
		// 큐에다가 클래스 저장해서 쭉 다니면서 해당 좌표에 몇개부셨는지 저장하고 갱신
		arr = new int[N][M];
		low = new int[N][M];
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line.substring(j, j+1));
				low[i][j] = Integer.MAX_VALUE;
			}
		}
		low[0][0] = 0;
		q.add(new node(0,0,0));
		move();
		System.out.println(min);
	}

	public static void move(){
		while(!q.isEmpty()){
			node n = q.poll();
			// 4방향으로 움직이는 곳의 low값이 최저일때만 큐에 추가하고 아니면 없앰
			for(int in=0;in<4;in++){
				int nx = n.x + dx[in];
				int ny = n.y + dy[in];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				// 2가지 존재
				// 1. 만약 길이라면 low값만 비교해서 이동
				// 2. 벽이라면 현재 cnt+1값과 low값 비교해서 이동
				if(arr[nx][ny] ==0){
					if(n.cnt < low[nx][ny]){
						low[nx][ny] = n.cnt;
						q.add(new node(nx,ny,n.cnt));
					}
				}
				else{
					if(n.cnt +1 < low[nx][ny]){
						low[nx][ny] = n.cnt+1;
						q.add(new node(nx,ny,n.cnt+1));
					}
				}
			}

		}
		min = low[N-1][M-1];
	}


	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static class node{
		int x;
		int y;
		int cnt;
		public node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}