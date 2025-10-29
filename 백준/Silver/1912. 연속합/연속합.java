import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[] arr;
	static boolean[][] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		// 수 배열이 주어질때 연속된 수의 합이 가장 큰 값 구하기
		// 투포인터 안될듯... dp?
		arr = new int[N];
		for(int i = 0 ; i < N ; i ++){
			arr[i] = sc.nextInt();
		}
		dp = new int[N];
		dp[0] = arr[0];
		ans = dp[0];
		for(int i = 1 ; i < N ; i ++){
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]); // 해당 전값 + 지금값 or 지금값 -> 두개 중 큰 값으로 비교(두번쨰는 현재항부터 시작)
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};



}