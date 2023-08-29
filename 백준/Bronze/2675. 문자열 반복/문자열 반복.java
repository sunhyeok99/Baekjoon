import java.io.IOException;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {		
		Scanner sc=  new Scanner(System.in);
		int A = sc.nextInt();
		for(int tc=1;tc<=A;tc++) {
			int cnt = sc.nextInt();
			String N = sc.next();
			for(int i=0;i<N.length();i++) {
				for(int j=0;j<cnt;j++) {
					System.out.print(N.substring(i,i+1));
				}
			}
			System.out.println();


		}
	}
}