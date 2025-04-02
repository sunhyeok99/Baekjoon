import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int a = sc.nextInt();
		if(N == 60 && M == 60 && a == 60) {
			System.out.println("Equilateral");
		} else if (N + M + a == 180) {
			if(N == M || N == a || M == a){
				System.out.println("Isosceles");
			}
			else {
				System.out.println("Scalene");
			}
		}
		else {
			System.out.println("Error");
		}

	}

}