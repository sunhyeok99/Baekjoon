import java.util.Scanner;
 
public class Main {
	
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		long[] dist = new long[N - 1];	// 거리
		long[] cost = new long[N];	// 비용 
		
		// 거리 입력 
		for(int i = 0; i < N - 1; i++) {
			dist[i] = in.nextLong();
		}
		
		// 리터당 기름값 입력
		for(int i = 0; i < N; i++) {
			cost[i] = in.nextLong();
		}
		
		long sum = 0;
		long minCost = cost[0];	// 이전 까지의 과정 중 주유 최소 비용 
 
		for(int i = 0; i < N - 1; i++) {
			
			/*
			 *  현재 주유소가 이전 주유소의 기름값보다 쌀 경우
			 *  minCost를 갱신해준다. 
			 */
			if(cost[i] < minCost) {
				minCost = cost[i];
			}
			
			sum += (minCost * dist[i]);	// 총 비용 누적 합
		}
		
		System.out.println(sum);
		
	}
}