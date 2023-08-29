import java.io.IOException;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {		
		Scanner sc=  new Scanner(System.in);

		while(true) {
			if(!sc.hasNext()) {
				break;
			}
		System.out.println(sc.nextInt()+sc.nextInt());
		}
		
	}
}