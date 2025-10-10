import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static boolean[] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		// 입력받아 모두 연결한 후 1부터 체크안된거 확인
		ar = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			ar[i] = new ArrayList<>();
		}
		// 이제 입력받아 ar추가
		for(int i = 0 ; i <M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			ar[a].add(b);
			ar[b].add(a);
		}
		visited = new boolean[N+1];
		ans = 0;
		// 이제 1부터시작해서 하나로 연결된애들 boolean체크
		for(int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				solve(i);
				ans ++;
			}
		}
		System.out.println(ans);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void solve(int st){

		// st에서 시작해서 큐에서 넓어지면서 방문체크
		Queue<Integer> q = new LinkedList<>();
		q.add(st);
		while(!q.isEmpty()){
			int cur = q.poll();
			for(int i = 0 ; i < ar[cur].size();i++){
				int now = ar[cur].get(i);
				if(visited[now]){
					continue;
				}
				visited[now] = true;
				q.add(now);
			}


		}
	}




}