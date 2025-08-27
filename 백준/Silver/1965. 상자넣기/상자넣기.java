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
		// 이거 뒤에서부터 시작해서
		// 큰수가 나오면 시작점위치 변경
		// dp?
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.fill(dp, 1);
		int max = 0;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);


	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};





}