import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		int n = sc.nextInt();
		int a[] = new int[n]; 
		int b[] = new int[n]; 
		int arr[] = new int[n];
		
		for(i = 0;i < n;i++) {
			a[i] = sc.nextInt();
			b[i] =sc.nextInt();
			arr[i] = a[i]+b[i];
		}
		
		for(i = 0;i < n;i++) {
			System.out.print("Case #");
			System.out.print((i+1)+": ");
			System.out.println(a[i]+" + "+b[i]+" = "+arr[i]);
		}
		
	}

}