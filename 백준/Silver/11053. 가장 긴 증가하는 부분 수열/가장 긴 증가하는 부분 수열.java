import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i =0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		// 입력완료
	
		int[] dp1 = new int[N];	
		for(int i =0;i<N;i++) {
			dp1[i] = 1;			
		}
		int max = 0;
		
		//일단 왼쪽에서 가장큰수 기준으로
		// 해당 i의 위치가 가장큰 수 위치일때
		// 증가하는 길이의 max를 구한다.
		for(int i =0;i<N;i++) {
			for(int j =0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp1[i] = Math.max(dp1[j] +1, dp1[i]);
					// 모두다 1로 되어있어서 
					// 갱신 이후에는 
					// i까지의 
					// 최대의 길이가 저장
				}
			}
		}
		for (int i = 0; i < N; i++) {
            max = Math.max(max, dp1[i]);
        }
		//max인 지점의 숫자가 2번포함되었으므로 -1
		System.out.println(max);
	}
}