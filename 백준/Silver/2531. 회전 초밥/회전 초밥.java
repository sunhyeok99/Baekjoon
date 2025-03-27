
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 중요한건 쿠폰을 쓴다해서 가짓수가 늘어나진 않는다..
		// 쿠폰을 hs에 넣어놓고 hs의 개수가 최대로 되게?
		int k = sc.nextInt();
		int num = sc.nextInt(); // 쿠폰번호
		arr = new int[N+k -1];
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt();
		}
		// k-1개만큼은 더 추가
		for(int i = N; i < N+k-1; i++){
			arr[i] = arr[i-N];
		}

		// 투포인터로 hs 조정
		// 오른쪽 증가할 때 오른쪽항 넣고 , 왼쪽항 제거
		int cnt[] = new int[M+1];
		int left = 0 ;
		int right = k-1;
		// 우선 두개안에 속하는 것들 모두 더함
		int nowCnt=0;
		for(int i = left ; i <= right; i++){
			if(cnt[arr[i]] == 0){
				nowCnt++;
			}
			cnt[arr[i]]++;
		}
		left ++;
		right ++;
		if(cnt[num] ==0){
			nowCnt++;
		}
		cnt[num]++;
		int ans = nowCnt;
		while(right < arr.length){
			// 현재위치의 숫자들 계산 -> 두개 숫자 이동
			if(cnt[arr[right]] == 0){
				nowCnt++;
			}
			cnt[arr[right]]++;
			// 빼는것도
			cnt[arr[left-1]]--;
			if(cnt[arr[left-1]] == 0){
				nowCnt--;
			}
			ans = Math.max(ans, nowCnt);
			right ++;
			left++;
		}

		System.out.println(ans);

	}




}