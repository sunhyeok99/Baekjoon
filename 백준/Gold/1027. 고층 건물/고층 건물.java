import java.util.*;

public class Main {
	static int N, M ;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 하나의 수를 기준으로
		// 양옆으로 작은수 -> 큰수로 교체하는 수의 개수
		// 가운데 건물 높이랑 상관없이 계단식으로 되는것의 개수 count
		arr = new int[N];
		for(int i = 0 ; i < N ; i++){
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		for (int i=0; i<N; i++) {
			ans = Math.max(ans, Count(i));
		}

		System.out.println(ans);

	}
	public static int Count(int idx) {
		int cnt = 0;
		double tmp = 0;

		// 왼쪽
		for (int i=idx-1; i>=0; i--) {
			double slope = (double) (arr[idx] - arr[i]) / (idx - i);

			if (i == idx-1 || tmp > slope) {
				cnt++;
				tmp = slope;
			}
		}

		// 오른쪽
		for (int i=idx+1; i<N; i++) {
			double slope = (double) (arr[idx] - arr[i]) / (idx - i);

			if (i == idx+1 || tmp < slope) {
				cnt++;
				tmp = slope;
			}
		}

		return cnt;
	}
}