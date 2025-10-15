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
		// 각 리스트 다 등록해놓고
		// 각 지점에서 가장 거리가 먼점을 저장해놓는다.
		// 그 다음 전체점에서 거리가 가장 짧은 점을 구하고,
		// 그 점과 같은 값인 애들을 배열에 저장
		// -> 출력

		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 같은 지점값은 0으로
				if (i == j) {
					continue;
				}
				arr[i][j] = 100000;
			}
		}
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == -1) {
				break;
			}
			// 각 점에 등록
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		// 이제 각 지점마다 거리의 최소값으로 갱신
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					// if (arr[i][j] + arr[j][k] < arr[i][k]) {
					// 	arr[i][k] = arr[i][j] + arr[j][k];
					// }
					if(arr[j][k] > arr[j][i] + arr[i][k]){
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}
			}
		}
		// 이제 다 값 갱신했으니 각 정메서의 최대값을 저장해놓자.
		ans = 100000;
		int[] answer = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int tmp = 0;
			for (int j = 1; j <= N; j++) {
				tmp = Math.max(tmp, arr[i][j]);
			}
			// 각 점에서 최대값으로 갱신 + ans값 최소로 갱신
			answer[i] = tmp;
			ans = Math.min(ans, answer[i]);
		}
		// 이제 ans인 값들의 개수와 값들 구함
		System.out.print(ans+" ");
		int count = 0;
		for(int i = 1 ; i <= N ; i++){
			if(ans == answer[i]){
				count++;
			}
		}
		System.out.println(count);
		for(int i = 1 ; i <= N ; i++){
			if(ans == answer[i]){
				System.out.print(i+" ");
			}
		}
	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};


}