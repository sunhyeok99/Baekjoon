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
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		ar = new ArrayList[N+1];
		for(int i = 1 ; i <= N;i++){
			ar[i] = new ArrayList<>();
		}
		// 모두 초기화하고 친구관계 list 추가
		for(int i = 0 ; i < M ; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			ar[a].add(b);
			ar[b].add(a);
		}
		// 1부터 시작해서 1의 친구와, 그 친구의 친구까지만 연결
		// -> 1의 친구를 큐에다가 추가해놓고 그 친구들만 탐색
		ans = 0;
		visited = new boolean[N+1];
		visited[1] = true;
		for(int i = 0;i< ar[1].size();i++){
			int num = ar[1].get(i);
			q.add(num);
			visited[num] = true;
			ans ++;
		}
		// 이제 큐에 있는 애들만 count 해주면된다.
		while(!q.isEmpty()){
			int num = q.poll();
			for(int i = 0 ; i < ar[num].size();i++){
				int tmp = ar[num].get(i);
				if(visited[tmp]){
					continue;
				}
				visited[tmp] = true;
				ans++;
			}

		}
		System.out.println(ans);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};



}