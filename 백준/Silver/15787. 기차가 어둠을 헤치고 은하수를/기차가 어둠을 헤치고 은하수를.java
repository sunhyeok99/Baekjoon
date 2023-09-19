import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc;
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String[] args) {
		 sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][20+1];
		Set<String> set = new HashSet<>();
		
		solve();
    	for(int i = 1; i < N + 1; i++) {
//    		System.out.println(Arrays.toString(arr[i]));
    		set.add(Arrays.toString(arr[i]));		
    	}

    	System.out.println(set.size());
		
	}
	public static void solve() {
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			if (a==1) {
				int b = sc.nextInt();
				int c = sc.nextInt();
				arr[b][c] = 1;
			}
			else if(a==2) {
				int b= sc.nextInt();
				int c = sc.nextInt();
				arr[b][c] = 0;				
			}
			else if(a==3) {
				int b =sc.nextInt();
				for(int in=20;in>=1;in--) {
					arr[b][in] = arr[b][in-1]; 
				}				
			}
			else {
				int b= sc.nextInt();
				for(int in=1;in<20;in++) {
					arr[b][in]=arr[b][in+1];
				}
				arr[b][20] = 0;
			}	
			
		}
		
		
	}

}