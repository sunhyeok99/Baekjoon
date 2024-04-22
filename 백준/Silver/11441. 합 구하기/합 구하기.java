import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i = 1;i<=N;i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
		// 누적합 구함
		int M = sc.nextInt();
		for(int i = 0 ; i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(arr[b] - arr[a-1]);
		}
		
		
		
		
	}
}