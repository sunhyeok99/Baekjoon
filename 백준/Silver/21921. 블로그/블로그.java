import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// N일중에 M일 지남
		// 모두 입력받고 M일동안의 합이 가장 큰 경우 -> 개수도 파악
		int cnt= 0;
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		// 초기값 세팅
		for(int i = 0; i < M; i++) {
			sum += arr[i];
		}
		cnt =1 ;
		int max = sum;
		// 이제 시작
		for(int i = M; i < N; i++) {
			sum += arr[i];
			sum -= arr[i-M];
			// 크면 교체 , 같으면 cnt+1, 적으면패스
			if(sum >= max){
				if(sum > max){
					max = sum;
					cnt = 0;
				}
				cnt++;
			}
		}

		if(max == 0 ){
			System.out.println("SAD");
		}
		else{
			System.out.println(max);
			System.out.println(cnt);
		}

	}


}