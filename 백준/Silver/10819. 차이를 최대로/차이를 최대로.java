import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[] arr;
	static boolean[] visited;
	static int[] dp;
	static int[] selected;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// 수를 N개 입력받았을 때
		// 인접한 두개의 수의 차의 절대값들을 더했을 때 최대가 되게 하려면
		// 두개를 정렬해 절반으로 나눠
		// -> 그냥 노가다 시작
		N = sc.nextInt();
		arr = new int[N];
		for(int i = 0 ; i< N ; i++){
			arr[i] = sc.nextInt();
		}
		visited = new boolean[N];
		selected = new int[N];

		ans = 0;
		dfs(0);
		System.out.println(ans);
	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void dfs(int count){
		if(count == N){
			// 계산
			ans = Math.max(ans, solve());
			return;
		}
		for(int i = 0;i<N;i++){
			if(!visited[i]){
				selected[count] = arr[i];
				visited[i] = true;
				dfs(count+1);
				visited[i] = false;
			}
		}

	}
	public static int solve(){
		int num = 0;
		for(int i = 1; i < N; i++){
			num += Math.abs(selected[i] - selected[i-1]);
		}
		return num;
	}

}