import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
	// dp 같긴한데
		// 2 -> 2/2
		// 3 -> 3/4
		// 4 ->	4/6
		double a = N;
		double b = 2*N -2;
		System.out.println(a/b);
		
	}
}