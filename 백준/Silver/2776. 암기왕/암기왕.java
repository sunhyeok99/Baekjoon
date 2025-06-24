import java.io.*;
import java.util.*;

public class Main {
	static int N, M ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] arr1 = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}

			M = Integer.parseInt(br.readLine());
			int[] arr2 = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr1);

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				int num = arr2[i];
				boolean found = binarySearch(arr1, num);
				sb.append(found ? "1" : "0").append("\n");
			}
			System.out.print(sb);
		}
	}

	private static boolean binarySearch(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target) return true;
			else if (arr[mid] < target) left = mid + 1;
			else right = mid - 1;
		}
		return false;
	}

}