import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int ans;
	static ArrayList<Integer> ar = new ArrayList<Integer>();
	static boolean flag[];
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        String n = sc.next();
	        int b = sc.nextInt();

	        long result = 0;
	        int idx = 0;// 승 0, 1, 2, 3 ....
	        int num = 0;//계산하기 위해 각 자리 숫자를 10진수로 바꿔준다
	        for (int i = n.length()-1; i >= 0; i--) {
	            char c = n.charAt(i);
	            if (c>='0' && c<='9')
	                num = c - '0';//0~9 사이는 그대로 출력
	            else
	                num = c - 55;//A~Z는 숫자로 변경
	            result += num * Math.pow(b, idx++);
	        }
	        System.out.println(result);
		
	}


}