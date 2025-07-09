import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 투포인터로 진행
		// 투포인터로 하나늘려가면서 전체 개수에서 양 끝 고정시키고
		// n-2개 만큼 모든 경우의수 더하기?
		N = Integer.parseInt(st.nextToken());
		long ans = 0;
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] ct = new int[100001]; // 해당 숫자가 등장한 개수
		int l = 1;
		int r = 0;
		while (l <= N) {
			while (r + 1 <= N && ct[arr[r + 1]] == 0) {
				r++;
				ct[arr[r]]++;
			}

			ans += r - l + 1;
			ct[arr[l++]]--;
		}

		System.out.println(ans);


	}

}