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
	static int ansX, ansY;
	static PriorityQueue<Integer> q;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		// 무게 비교마다 parent 등록해놓고
		// -> 1 > 2 , 2 - > 3 ==> [2] = 1 ,[3] = 1
		// 플로이드 알고리즘의 핵심 개념은 i,j의 정점 사이를 거쳐가는 지점을 모두 조회하여 최단 경로를 찾기

		// 플로이드 워셜(3중포문)로 k i j 순으로 큰거 1 , 작은거 -1 로 놓고
		// i -> k == 1 && k -> j == 1 이면 i --> j ==1로 게산
		// 반대 -1도  똑같이
		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
				arr[i][i] = 1;
		}
		M = sc.nextInt();
		for(int i = 0 ; i < M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = -1;
		}

		for(int k = 1 ; k <= N ; k++) {
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
					if(arr[i][k] == -1 && arr[k][j] == -1) {
						arr[i][j] = -1;
					}
				}
			}
		}
		// 이제 0제외하고 -1or 1의 개수 count
		for(int i= 1 ; i <=N ; i++) {
			ans = 0;
			for (int j = 1; j <= N; j++) {
				if(arr[i][j] == 0) {
					ans++;
				}
			}
			System.out.println(ans);
		}

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};



}