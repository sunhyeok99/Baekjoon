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
		// 우선 0과 1의 개수를 count 하고
		// 0의 개수 + 1의 개수 하면 될듯?

		// --> 시간 절약하려면 앞에서부터 1 제거, 뒤에서부터 0제거하면된다.
		for(int i = 0; i < s.length() && b > 0; i++) {
			if(s.charAt(i) == '1'){
				s = s.substring(0, i) + s.substring(i+1);
				b --;
				i --;
			}
		}
		for(int i = s.length()-1; i >= 0 && a > 0; i--) {
			if(s.charAt(i) == '0'){
				s = s.substring(0, i) + s.substring(i+1);
				a --;
			}
		}
		System.out.println(s);




	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};



}