
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int L, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		K = sc.nextInt();
		int[][] star = new int[K][2];
		// 별두개를 골라서 두개의 x와 y좌표의 최소점을 시작점이라 두고
		// 총 몇개의 별이 해당하는지 count해보자
		for(int i = 0 ; i < K;i++){
			star[i][0] = sc.nextInt();
			star[i][1] = sc.nextInt();
		}
		int ans = 0;
		// 별 두개를 잡고 두점의 교차로 진행해보자
		for(int i = 0 ; i < K ; i++){
			for(int j = 0 ; j < K ; j++){
				int x = star[i][0];
				int y = star[j][1];
				// 두개 교차 선택
				int cnt = 0;
				for(int k = 0;k<K;k++){
					// x와 y에 해당하는 점의 개수 count
					int a = star[k][0];
					int b = star[k][1];
					if(a >= x && b >= y && a <= x + L && b <= y + L){
						cnt ++;
					}
				}
				// 다끝나면 최대점 갱신
				ans = Math.max(ans, cnt);

			}
		}
		System.out.println(K - ans);


	}




}