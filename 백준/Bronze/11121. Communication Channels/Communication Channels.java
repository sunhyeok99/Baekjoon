import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String a = sc.next();
			String b = sc.next();
			if(a.length() != b.length()) {
				System.out.println("ERROR");
			}else {
				int j;
				for(j = 0; j < a.length(); j++) {
					if(a.charAt(j) != b.charAt(j)) {
						break;
					}
				}
				
				if(j == a.length()) {
					System.out.println("OK");
				}else {
					System.out.println("ERROR");
				}
			}
		}
		sc.close();
	}
}