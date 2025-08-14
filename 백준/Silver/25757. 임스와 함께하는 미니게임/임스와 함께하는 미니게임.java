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
		// 중복이 안되니깐
		// 리스트 다 hashSet에 넣고
		// Y는 2, F는 3 , O는 4로 나눠지는 몫을 출력하면될듯
		int N = sc.nextInt();
		String word = sc.next();
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i < N; i++) {
			hs.add(sc.next());
		}
		int num = 0;
		if(word.equals("Y")){
			num = 2;
		}
		else if(word.equals("F")){
			num = 3;
		}
		else{
			num = 4;
		}
		System.out.println(hs.size()/(num-1));

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};



}