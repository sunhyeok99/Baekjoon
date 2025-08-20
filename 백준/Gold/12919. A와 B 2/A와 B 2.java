import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int ans;
	static int[] arr;
	static boolean[][] visited;
	static int[][] dp;

	static String S;
	static String T;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// a를 추가 or b추가하고 뒤집기를 해서
		// s가 t가 될수 있는지 확인
		// -> 두가지 방향으로 dfs하면서 만약 되면 그대로 종료하면될듯!
		S = sc.next();
		T = sc.next();
		// S에서 시작
		solve(T);
		System.out.println(0);
	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	static void solve(String word){
		if(word.length() == S.length()){
			if(word.equals(S)){
				System.out.println(1);
				System.exit(0);
			}
			return;
		}
		if(word.substring(word.length()-1, word.length()).equals("A")){
			solve(word.substring(0, word.length()-1));
		}
		if(word.substring(0,1).equals("B")){
			StringBuffer sb = new StringBuffer(word.substring(1));
			solve(sb.reverse().toString());
		}
	}

}