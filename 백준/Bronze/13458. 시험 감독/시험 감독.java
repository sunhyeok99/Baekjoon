import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int [] arr = new int[N];
		for(int i = 0 ; i< N; i++) {
			arr[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		
		long cnt = 0;
		for(int i = 0;i< arr.length;i++) {
			int tmp = arr[i];
			// 우선 tmp에서 B만큼 빼고
			// 나머지 C를 빼는작업
			tmp -= B;
			cnt ++;
			if(tmp <= 0) {
				continue;
			}
			// 이제 부감독관
			cnt += tmp/C;
			if(tmp%C!=0) {
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
		
	}
	
	
}
