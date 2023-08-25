import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {		
//		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));	
		Scanner sc=  new Scanner(System.in);
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M =Integer.parseInt(st.nextToken());
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] arr = new long[N];
//		st = new StringTokenizer(br.readLine());		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		long middle =0;
		long maxi = arr[N-1];
		long mini = 0;
		long len = 0;
		while(true) {
			len=0;
			middle = (maxi+mini)/2;
			for(int i=0;i<N;i++) {
				long tmp = arr[i] - middle;
				if(tmp>0) {
					len+=tmp;
				}
			}
			if(len == M) {
				break;
			}			
			if(len>M) {
				mini=middle+1;
			}
			else if(len<M) {
				maxi=middle-1;
			}
			
			if(mini>maxi) {
				middle = maxi;
				break;
			}
			
		}
		System.out.println(middle);

	}
}
