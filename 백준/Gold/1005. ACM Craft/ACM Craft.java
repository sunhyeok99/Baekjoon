import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int ans;
	static int[] arr;
	static boolean[][] visited;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {

			N = sc.nextInt();
			int K = sc.nextInt();
			arr = new int[N+1];
			int[] child = new int[N+1];
			for(int i = 1; i <= N; i++) {
				arr[i] = sc.nextInt();
			}
			ArrayList<Integer>[] list = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i = 0; i < K; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				child[b] ++;
				list[a].add(b);
			}

			M = sc.nextInt();// 목표 건물

			// 이거 방식은 1번 건물부터 진행하고
			// 1번건물이 진행된 후 1번에서 연결된 다른 건물들 진행하자.
			// 1번이 완성되면 1번에서 연결된 건물들의 child를 -1해주고
			// 해당건물의 child가 0일때만 건축 시작
			// 진행하면서 쌓이는 시간은 dp로 저장
			dp = new int[N+1];

			// 1번부터 시작
			Queue<Integer> q = new LinkedList<>();
			// child가 0인 애들은 먼저 다 큐에 더해서 진행
			// 해당 값에서 연결된 다리값들을 모두 for문을 돌려
			// 현재위치값 + arr 값이랑 현재 위치 값 중 최대값을 저장하고
			// 반복 진행
			for(int i = 1 ; i <= N; i++){
				if(child[i] == 0){
					// 시작애들은 값 넣어줘야한다.
					dp[i] = arr[i];
					q.add(i);
				}
			}

			while(!q.isEmpty()) {
				int now = q.poll();
				for(int i = 0 ; i< list[now].size(); i++){
					int next = list[now].get(i);
					dp[next] = Math.max(dp[next], dp[now] + arr[next]);
					child[next]--;
					if(child[next] == 0){
						q.add(next);
					}
				}
			}
			// 끝
			System.out.println(dp[M]);
		}

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

}