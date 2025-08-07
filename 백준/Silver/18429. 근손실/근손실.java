import java.util.*;
import java.io.*;

public class Main {
	static int N, M ;
	static int ans;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		// 500을 기준으로 매일 M씩 깎이게 되는데
		// 모든 경우를 dfs하면서 500보다 -되게되면 X
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt()- M;
		}
		// 그냥0으로하고 음수되면 걸러도 상관없음

		ans = 0;
		visited = new boolean[N];
		solve(-1, 0, 0);
		System.out.println(ans);

	}

	public static void solve(int num, int weight, int cnt){
		if(cnt == N){
			if(weight >= 0){
				ans ++;
			}
			return;
		}
		if(weight < 0){
			return;
		}

		for(int i = 0; i < N; i++){
			if(visited[i]){
				continue;
			}

			visited[i] = true;
			solve(i, weight + arr[i], cnt + 1);
			visited[i] = false;
		}


	}

}