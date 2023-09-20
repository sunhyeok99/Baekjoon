import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {

	static int N;
	static int[][] arr;	
	static int M;
	static int cnt;
	static int[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N+1][N+1];
			check = new int[N+1];
			for(int i =1;i<=N;i++) {
				check[i] = i;
			}
	
			cnt =0;
			for(int i=0;i<M;i++) {				
				int a = sc.nextInt();
				int b = sc.nextInt();						
				union(a, b);
			}
			HashSet<Integer> h = new HashSet<>();
			// 0은 이미 혼자 있기때문에
			// i는 1부터 해야함
			// 0부터 할거면 결과에서 -1
			for(int i=1;i<check.length;i++) {
				h.add(find(i));
			}
			System.out.println("#"+tc+" "+h.size());

		}
	}

	private static boolean union(int a, int b) {
		int tmpa = find(a);
		int tmpb = find(b);
		if(tmpa == tmpb) {
			return false;
		}
		check[tmpb] = tmpa;
		return true;
	}

	public static int find(int a) {
		if(check[a] == a) {
			return a;
		}
		return check[a] = check[find(check[a])];
	}

}