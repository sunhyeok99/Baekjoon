import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			//정렬
			Arrays.sort(arr);
			//정렬 후 최솟값 2개는 0과 1인덱스에 저장된 값
			long N = arr[0] + arr[1];
			arr[0] = N;
			arr[1] = N;
		}
		
		long sum = 0;
		
		for(int i = 0; i < n; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

}