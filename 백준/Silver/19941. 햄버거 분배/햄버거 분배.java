
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 햄버거가 기준이라 햄버거를 찾고
		// 햄버거 - K만큼범위부터 하나씩 확인
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		String line = sc.next();
		for(int i = 0; i < N; i++) {
			if(line.substring(i,i+1).equals("H")){
				arr[i] = 1;
			}
		}
		// 1을 찾으면서 +해주기
		int ans = 0;
		// 어차피 지나간 햄버거는 찾지않아서 사람이 먹었으면 -1해주기
		for(int i = 0; i < N; i++) {
			if(arr[i] == 1){
				// 사람찾기
				for(int j = i-M;j <= i+M;j++){
					if(j < 0 || j >= N){
						continue;
					}
					// 0찾기
					if(arr[j] == 0){
						arr[j] = -1;
						ans ++;
						break;
					}
				}
			}

		}
			System.out.println(ans);




	}

}