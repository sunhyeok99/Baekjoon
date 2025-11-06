import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static boolean[] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<node>[] ar;
	static int ansX, ansY;
	static PriorityQueue<node> q;
	static int ansTime;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt(); // 시작번호

			ar = new ArrayList[N + 1];
			for(int i = 1; i <= N; i++) {
				ar[i] = new ArrayList<>();
			}
			for(int i = 0; i < M; i++) {
				int a= sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				ar[b].add(new node(a,c)); // b가 감염되고 c초후에 a가 감염
			}
			// 총 감염 개수 , 걸리는 시간
			ans = 0;
			ansTime = 0;
			q = new PriorityQueue<>();
			q.add(new node(K, 0));
			visited = new boolean[N+1];
			solve();
			System.out.println(ans +" "+ansTime);

		}

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static class node implements  Comparable<node>{
		int en;
		int cnt;
		node(int en, int cnt){
			this.en = en;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(node o){
			return this.cnt - o.cnt;
		}

	}
	public static void solve(){
		while(!q.isEmpty()){
			node n = q.poll();
			if(visited[n.en]){
				continue;
			}
			ans ++;
			visited[n.en] = true;
			ansTime = Math.max(ansTime, n.cnt);

			for(int i = 0; i < ar[n.en].size(); i++){
				int num = ar[n.en].get(i).en;
				int time = ar[n.en].get(i).cnt;
				if(!visited[num]){
					q.add(new node(num, n.cnt + time));
				}


			}




		}



	}

}