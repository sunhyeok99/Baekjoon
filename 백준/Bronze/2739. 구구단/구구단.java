import java.io.IOException;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {		
		Scanner sc=  new Scanner(System.in);
		int A = sc.nextInt();
		for(int i=1;i<=9;i++) {
			System.out.println(A+" * "+i+" = "+A*i);
		}
		
	}
}