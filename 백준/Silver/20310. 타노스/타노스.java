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

		String s = sc.next();
		int a = 0;
		int b = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0'){
				a++;
			}
			else{
				b++;
			}
		}
		a /=2;
		b /=2;
		String answer = "";
		for(int i = 0 ;i< a;i++){
			answer += "0";
		}
		for(int i = 0 ; i < b;i++){
			answer += "1";
		}
		System.out.println(answer);

		// 우선 0과 1의 개수를 count 하고
		// 0의 개수 + 1의 개수 하면 될듯?






	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};



}