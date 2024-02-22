import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        
       	 	int num1 = input.nextInt();
        	int num2 = input.nextInt();
        	int num3 = input.nextInt();
        
        	int result = 0;
        
        	if (num1 == num2 && num2 == num3 && num1 == num3) {
        		result = 10000 + num1 * 1000;
        	}
        	else if (num1 == num2 || num1 == num3) {
        		result = 1000 + num1 * 100;
        	}
        	else if (num2 == num3) {			// 이 부분을 빼먹고 풀어서 계속 틀렸었다.
        		result = 1000 + num2 * 100;
        	}
        	else {
        		result = Math.max(num1,  Math.max(num2, num3)) * 100;
        	}
        
        	System.out.println(result);
       
        	input.close();
	}
}