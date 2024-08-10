import java.io.*;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		solved();
	}
	public static void solved() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		if (Long.parseLong(A) > 1000) {
			long a = Long.parseLong(A), b = Long.parseLong(B);

			int sum = 1;

			for (int j = 2; j <= (Math.min(a, b)); j++) {

				if (a % j == 0 && b % j == 0) {
					a /= j;
					b /= j;
					sum *= j;
					j = 1;
				}

			}
			System.out.println(sum * a * b);
		} else {
			int a = Integer.parseInt(A), b = Integer.parseInt(B);

			int sum = 1;
			for (int j = 2; j <= (Math.min(a, b)); j++) {

				if (a % j == 0 && b % j == 0) {
					a /= j;
					b /= j;
					sum *= j;
					j = 1;
				}

			}
			System.out.println(sum * a * b);
		}
	}
}