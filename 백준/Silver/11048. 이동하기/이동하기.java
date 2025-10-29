import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		// 3가지 방향으로 이동가능
		// dp로 좌표에 값 저장
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int[][] sum = new int[N][M];
		sum[0][0] = arr[0][0];
		for(int i = 1; i < N; i++) {
			sum[i][0] = sum[i-1][0] + arr[i][0];
		}
		for(int i = 1 ; i < M; i++){
			sum[0][i] = sum[0][i-1] + arr[0][i];
		}
		// 1,1부터 전방향 3개중에 최대값 + 현재값으로 갱신
		for(int i = 1 ; i < N ; i++){
			for(int j = 1 ; j < M ; j ++){
				sum[i][j] = Math.max(sum[i-1][j], Math.max(sum[i-1][j-1], sum[i][j-1])) + arr[i][j];
			}
		}
		System.out.println(sum[N-1][M-1]);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};



}