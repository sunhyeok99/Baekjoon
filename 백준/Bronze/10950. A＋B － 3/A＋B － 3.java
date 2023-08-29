import java.io.IOException;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {		
		Scanner sc=  new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			System.out.println(sc.nextInt()+sc.nextInt());
		}
		
	}
}