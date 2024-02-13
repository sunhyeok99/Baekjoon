import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int number = 0;
		while (true) {
            if(N<=0){
                break;
            }
			number++;
			String s = Integer.toString(number);

			if (s.contains("666")) {
				N--;
			}
		}
		System.out.println(number);
	}
}