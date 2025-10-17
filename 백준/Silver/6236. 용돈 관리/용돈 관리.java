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
		M = sc.nextInt();
		// M번 돈을 인출해서 n일을 버티면된다.
		// 돈을 인출하게 되면 금액을 K로 교체
		// 입력값중 가장큰값보다는 이상이어야함.
		arr = new int[N];
		int left = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			left = Math.max(left, arr[i]);
		}
		// 최대 10억
		int right = 1000000000;
		ans = 0;
		// mid값 잡고 메서드를 통해 m번보다 적을경우 mid값 늘리고, m이상일 경우에는 mid값 줄여서 찾음
		while(true){
			int mid = (left + right)/2;
			// mid값을 기준으로 count
			int cnt = count(mid);
			if(cnt <= M){
				right = mid -1;
				ans = mid;
			}
			else{
				left = mid +1;
			}
			// break포인트
			if(left > right){
				break;
			}
		}
		System.out.println(ans);


	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static int count(int k){
		int cnt = 1;
		int money = k;
		for(int i = 0 ; i < N ; i++){
			if(money - arr[i] < 0){
				cnt ++;
				money = k;
			}
			money -= arr[i];
		}
		return cnt;
	}

}