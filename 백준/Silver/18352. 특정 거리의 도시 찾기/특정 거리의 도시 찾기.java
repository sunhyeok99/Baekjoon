import java.util.*;
	import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static int[] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// 연결되어있는 곳 모두 값이 0이 아니라면 +1씩해서 최단거리 계산
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		int X = sc.nextInt();
		visited = new int[N+1];
		ar = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			ar[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < M ; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			ar[a].add(b);
		}
		visited[X] = 1;
		solve(X);
		// 이제 최단거리가 K인 애들 찾기
		ArrayList<Integer> tmp = new ArrayList<>();
		for(int i = 1 ; i <= N ; i++){
			if(visited[i] == K+1){
				tmp.add(i);
			}
		}
		Collections.sort(tmp);
		for(int i = 0 ; i < tmp.size() ; i++){
			System.out.println(tmp.get(i));
		}
		if(tmp.size()==0){
			System.out.println(-1);
		}

	}
	public static void solve(int st){
		Queue<Integer> q = new LinkedList<>();
		q.add(st);
		while(!q.isEmpty()){
			int n = q.poll();
			// n의 숫자에서 하나씩 뻗어나가는 지점들 탐색
			// 만약 뻗어나간 점이 visited가 0이 아니라면 X
			for(int i = 0 ; i < ar[n].size();i++){
				int tmp = ar[n].get(i);
				if(visited[tmp] == 0){
					visited[tmp] = visited[n]+1;
					q.add(tmp);
				}
			}

		}

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};




}