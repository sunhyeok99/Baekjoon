import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dp;

	static PriorityQueue<node> pq = new PriorityQueue<node>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// 이거 간단하게 우선순위큐써서 값이 낮은걸로 오름차순 정리하고
		// 바이러스를 모두 우선순위큐에넣고 확장 시작하면될듯
		N = sc.nextInt();
		M = sc.nextInt();
		M = N;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int S = sc.nextInt();
		int ansX = sc.nextInt();
		int ansY = sc.nextInt();
		// 바이러스들 모두 for문을통해 시작
		boolean flag = false;
		int time = 0;
		while (true) {
			if(flag || time == S){
				break;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j] >0){
						pq.add(new node(i, j, arr[i][j]));
					}
				}
			}
			// 큐에있는거 한번 진행
			solve();
			time++;
			// 진행했을때 좌표 값 검사
			if(arr[ansX -1][ansY-1] != 0){
				flag = true;
			}
		}
		System.out.println(arr[ansX-1][ansY-1]);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static class node implements Comparable<node>{
		int x,y,num;
		node(int x,int y,int num){
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public int compareTo(node n){
			return this.num - n.num;
		}
	}

	public static void solve(){
		while(!pq.isEmpty()){
			node n = pq.poll();
			for(int i=0;i<4;i++){
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if(nx >= N || ny >= M || nx <0 || ny <0 || arr[nx][ny] !=0){
					continue;
				}
				// 진행
				arr[nx][ny] = n.num;
			}

		}
	}

}