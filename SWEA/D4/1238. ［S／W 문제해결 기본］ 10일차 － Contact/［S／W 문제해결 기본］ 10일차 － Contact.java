import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Solution {
	static int N;
	static int M;
	static int[][] arr;
	static int[] flag;
	static ArrayList<Integer>[] ans;
	static Queue<Integer> q;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[101][101];
			ans = new ArrayList[101];
			for(int i =0;i<101;i++) {
				ans[i] = new ArrayList<>();
			}
			q = new LinkedList<>();
			for(int i =0;i<N/2;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				ans[a].add(b);
			}

			flag = new int[101];
			flag[M] = 1;
			q.add(M);
			max = 0;
			int maxi=0;
			solve();
			for(int i =1;i<101;i++) {
//				System.out.println("flag"+flag[i]);
//				System.out.println(i);
				if(flag[i]>=max) {
					max = flag[i];
					maxi = Math.max(maxi, i);
				}
			}
			

			System.out.println("#"+tc+" "+maxi);
		}
	}
	public static void solve() {
		while(true) {
			int idx = q.poll();
			boolean tmp = false;
			for(int i =0;i<ans[idx].size();i++) {
				if(flag[ans[idx].get(i)]==0) {
//					System.out.println(idx);
//					System.out.println("ans"+ans[idx].get(i));
					flag[ans[idx].get(i)] = flag[idx]+1;
//					System.out.println(flag[idx]);
					q.add(ans[idx].get(i));
					tmp = true;
//					max = 0;
				}
			}
			
			if(q.size()==0) {				
				break;
			}
		}

	}

}