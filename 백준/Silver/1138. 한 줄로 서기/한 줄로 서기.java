import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int ans;
	static int[] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];

		// 맨뒤에서 부터 하면 쉽다.
		// 맨뒤를 고정 시키고 N이 5라면 , 4부터 1이 늘어날 때마다 한칸씩 이동
		// 3도 개수만큼 이동
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int num = N;
		for (int i = N - 1; i >= 0; i--) {
			int tmp = arr[i];
			ar.add(tmp, num--);
		}

		for(int i = 0; i < N; i++) {
			System.out.print(ar.get(i)+" ");
		}

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

}