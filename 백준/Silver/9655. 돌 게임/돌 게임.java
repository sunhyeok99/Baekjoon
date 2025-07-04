import java.util.*;

public class Main {
	static int N, M ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 상근 , 창영이가 번갈아가면서
		// 1개또는 3개를 가져감 -> 돌의 개수가 홀수개일경우 SK, 짝수개일 경우 CY
		if(N%2 == 1){
			System.out.println("SK");
		}
		else{
			System.out.println("CY");
		}



	}

}