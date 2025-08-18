import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int ans;
	static int[] arr;
	static boolean[][] visited;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);


		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a == 0&& b == 0 && c ==0){
				break;
			}
			if(a >= b + c || b >= a + c || c >= a + b){
				System.out.println("Invalid");
				continue;
			}

			if(a == b && b == c){
				System.out.println("Equilateral");
			}
			else if(a == b || b == c || c == a){
				System.out.println("Isosceles");
			}
			else{
				System.out.println("Scalene");
			}


		}





	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};



}