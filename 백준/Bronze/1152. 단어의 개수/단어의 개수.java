import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {		
//		Scanner sc=  new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int count =0;
		StringTokenizer st = new StringTokenizer(N);
		
			String[] tmp = N.split(" ");
		count = tmp.length;
//		System.out.println(Arrays.toString(tmp));
		if(tmp.length!=0 && tmp[0].equals("")) {
			count--;
		}
		
		
		System.out.println(count);
		

	}
}