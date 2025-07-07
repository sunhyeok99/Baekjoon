import java.util.*;

public class Main {
	static int N, M ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 주식 하나를 산다.
		// 2. 원하는 만큼 주식을 판다.
		// 3. 그냥 가만히있는다.
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			// 이거는 뒤에서 부터 최대값 갱신을 해가고
			// 현재 최대값에서 앞에 몇개가 있는지 count하고
			// 그 개수만큼 사고 파는거 진행
			int max = arr[N-1];
			long ans = 0;
			// 모두 max 값에 판다고 생각하면 편하다.
			for(int i = N-2;i>=0;i--){
				// arr이 더 큰경우 max값 교체  - 그값에 판다고 생각
				if(arr[i] > max){
					max = arr[i];
				}
				// max값이 더 크다면 arr값에 구매하여 max값에 판매
				else{
					ans += max - arr[i];
				}
			}

			System.out.println(ans);


		}



	}

}