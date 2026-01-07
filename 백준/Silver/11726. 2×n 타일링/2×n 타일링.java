import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[] arr;
	static int[][] map;
	static boolean[] visited;
	static boolean[][] flag;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer> ar[];
	static int ansX, ansY;
	static Queue<Integer> q;
	static int tmp;

	static int A, B;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		// 1짜리, 2짜리 채우는 경우
		dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3 ; i< N+1;i++){
			dp[i] =( dp[i-1] + dp[i-2])% 10007;
		}

		System.out.println(dp[N]);

	}

	public static int[] dx = {1, -1, 0, 0,-1,-1,1,1};
	public static int[] dy = {0, 0, 1, -1,-1,1,-1,1};


}