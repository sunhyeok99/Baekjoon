import java.util.Scanner;


public class Solution {

	static int N;
	static int M;
	static int cnt;
	static int[] check;
	static int[] rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			check = new int[N+1];
			rank = new int[N+1];
			for(int i =1;i<=N;i++) {
				check[i] = i;
				rank[i]=1;
			}

			System.out.print("#"+tc+" ");
			cnt =0;
			for(int i=0;i<M;i++) {		
				if(sc.nextInt()==0) {
					int a = sc.nextInt();
					//					System.out.println("a"+a);
					int b = sc.nextInt();
					if(a!=b) {
						union(a, b);
					}
				}
				else {
					int a = sc.nextInt();
					int b = sc.nextInt();
//					System.out.println("!"+find(a)+" "+find(b));
					if(find(a)==find(b)) {
						System.out.print(1);
					}
					else {
						System.out.print(0);
					}
				}
			}
	
			System.out.println();
		}
	}

	private static void union(int a, int b) {
		int tmpa = find(a);
		int tmpb = find(b);
		//		System.out.println("ab"+tmpa+" "+tmpb);
	
			if(tmpa == tmpb) {
				return;
			}
			if(rank[tmpb]>rank[tmpa]) {
				check[tmpa]=tmpb;
			}
			else if(rank[tmpa]>rank[tmpb]) {
				check[tmpb] = tmpa;
			}
			else {
				check[tmpb] = tmpa;
				rank[tmpa]++;
			}
//			check[tmpb] = tmpa;
	}

	public static int find(int a) {
		if(check[a] == a) {
			return a;
		}
		return check[a] = find(check[a]);
	}

}