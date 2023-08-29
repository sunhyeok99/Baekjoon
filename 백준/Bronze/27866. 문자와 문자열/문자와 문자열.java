import java.io.IOException;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {		
		Scanner sc=  new Scanner(System.in);

		String N = sc.next();
		int a = sc.nextInt();
		System.out.println(N.substring(a-1,a));

	}
}