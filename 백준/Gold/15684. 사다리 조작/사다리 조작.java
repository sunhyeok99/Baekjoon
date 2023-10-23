import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int H;
	static boolean[][] flag;
	static boolean ans;
	static int ansi;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 M = sc.nextInt();
		 H = sc.nextInt();
		flag = new boolean[H+1][N+1];
		for(int i = 0 ;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			flag[a][b] = true;
		}		
		ans = false;
		ansi = -1;
		for(int i =3;i>=0;i--) {
			solve(i,1,1);			
			if(ans) {
				ansi = 3-i;
				break;
			}
		}
		System.out.println(ansi);
		
		
		
	}//main
	
	public static void solve(int cnt, int x , int y) {
		if(cnt==3) {
			// 사다리 판단 가자
			if(solve2()) {
				ans = true;
			}
			return;
		}
		//여기서 부터는 사다리 선정 할거임
		for(int i= x;i<=H;i++) {
			for(int j = 1; j<N;j++) {
				if(i==x && j<y) {
					continue;
				}
				if(!flag[i][j] && !flag[i][j-1] && !flag[i][j+1]) {
					flag[i][j] = true;
					solve(cnt+1, i,j);
					flag[i][j] = false;
				}
			}
		}
		
	}
	public static boolean solve2() {		
		for(int i = 1;i<=N;i++) {
			int tmp = i;
			// 세로줄로 하나씩 판단 ㄱㄱ
			for(int j = 1;j<=H;j++) {
//				if(flag[j][tmp]) {
//					// 일단 사다리를 만나면
//					// 왼쪽 오른쪽 중에 사다리 판단해서
//					// i를 옮기기
//					if(flag[j][tmp-1]) {
//						tmp --;
//					}
//					else {
//						// 오른쪽에 사다리 있는경우
//						tmp++;
//					}
//				} // if
				if(flag[j][tmp]) {
					tmp ++;
				}
				else if(flag[j][tmp-1]) {
					tmp --;
				}
			}
			// 밑까지 내려갔을때 i랑 일치하는지 확인
			if(tmp!=i) {
				return false;
			}
		}
		return true;
		
	}
	
}