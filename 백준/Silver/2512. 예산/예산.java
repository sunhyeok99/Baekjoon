import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		// String st = br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum=0;
		int max=0;
		for(int i=0;i<N;i++) {
		//  arr[i] = Integer.parseInt(st.split(" ")[i]);
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]>max) max = arr[i];
		}
		int tBud = Integer.parseInt(br.readLine());
		int lo = 0;
		int hi = max;
		int mid =0; int ans=0;
		while(lo<=hi) {
			mid = (lo + hi)/2;
			sum=0;
			for(int i=0;i<N;i++) {
				if(arr[i]<mid) {
					sum += arr[i];
				}else {
					sum += mid;
				}
			}

			if(sum>tBud) hi = mid-1;
			if(sum<=tBud) {
				ans = mid; lo = mid+1;
			}
		}
		System.out.println(ans);
	}//main
}