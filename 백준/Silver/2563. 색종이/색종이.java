import java.util.Scanner;

public class Main {
	
	
public static void main(String[] args) {	
	Scanner sc = new Scanner(System.in);
	
	int N = sc.nextInt();
	int[][] arr = new int[101][101];
	int cnt =0;
	
	for(int T = 1;T<=N;T++) { // N번반복
		int tmpx = sc.nextInt(); // x좌표 입력
		int tmpy = sc.nextInt(); // y좌표 입력
		for(int i =tmpx;i<=tmpx+9;i++) {
			for(int j =tmpy;j<=tmpy+9;j++) {
				if(i<=100 && j<=100 && arr[i][j] ==0) {
					arr[i][j] = 1;
					cnt++;
				}
			} // J
		} //  I
		
	} // T
	
	System.out.println(cnt);
	
}


}
