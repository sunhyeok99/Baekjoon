import java.util.*;
import java.io.*;

public class Main {
	static int N, M ;
	static int[] arr;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// n은 굴다리 , m은 가로등
		arr = new int[N];
		for(int i = 0; i < M; i++){
			arr[i] = sc.nextInt();
		}
		// 이분탐색으로 숫자 정한다음 그만큼 밝히고 0~99999까지 true인지 확인
		int left = 0;
		int right = N;
		int result = 0;
		while(left <= right){
			int mid = (left + right)/2;
			if(check(mid)){
				// 허용하는거로 길이 줄임
				right = mid - 1;
				result = mid;
			}
			else{
				left = mid + 1;
			}

		}
		System.out.println(result);

	}

	// 해당 높이로 모두 이어지는지 확인
	public static boolean check(int mid){
		int per = 0;
		for(int i = 0 ; i < M;i++){
			// per부터 이어지는지 확인
			if(arr[i] - mid <= per){
				per = arr[i] + mid;
			}
			else{
				return false;
			}
		}
		// 마지막까지 갔는지 확인
		if(per < N){
			return false;
		}
		return true;

	}


}