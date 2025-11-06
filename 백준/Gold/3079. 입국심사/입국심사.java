import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static long[] arr;
	static boolean[] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static int ansX, ansY;
	static PriorityQueue<Integer> q;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 시간을 이분탐색으로
		// 해당 시간이 걸릴 때 각 심사대가 몇명씩 할 수 있는지 -> 총합 확인
		// 만약 총합이 더 많거나 같으면 시간 줄이고, 총합이 적으면 시간 늘림
		arr = new long[N];

		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt();
		}
		long ans = Long.MAX_VALUE;
		long left = 0;
		long right = Long.MAX_VALUE;
		while(true){
			long mid = (left + right)/2;
			long cnt = 0;
			// mid 시간일때 총 몇명 가능한지
			for(int i = 0 ; i < N ; i++){
				cnt += mid / arr[i];
				if(cnt >= M){
					break;
				}
			}
			// cnt랑 M 비교
			if(cnt >= M){
				right = mid -1;
				ans = Math.min(ans, mid);
			}
			else{
				left = mid+1;
			}

			if(left > right){
				break;
			}


		}
		System.out.println(ans);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};



}