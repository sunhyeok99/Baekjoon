import java.io.IOException;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {		
		Scanner sc=  new Scanner(System.in);
		int A = sc.nextInt();
		int[] arr = new int[A];
		for(int i=0;i<A;i++) {
			arr[i] = sc.nextInt();
		}
		int max= -10000000;
		int min = 100000000;
		for(int i=0;i<A;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		System.out.print(min+" "+max);
	}
}