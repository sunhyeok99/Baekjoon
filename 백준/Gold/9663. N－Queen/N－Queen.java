import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {	

	static int N;
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		cnt = 0;
		say(0);
		System.out.println(cnt);
	}
	public static void say(int row) {				
		if(row==N) {
			cnt++;
			return;
		}
		for(int j=0;j<N;j++) {
			arr[row] = j;		
			if(flag(row)) {
				say(row+1);
			}
		}
		//		for(int i=0;i<N-col;i++) {				
		//			arr[row][col+i] = 0; // 세로로 일자				
		//			
		//			if(row+i<N && col+i<N) {
		//				arr[row+i][col+i] = 0; // 현재 좌표를 중심으로 대각선 오른쪽밑
		//			}
		//			if(row+i<N && col-i>=0) {
		//				arr[row+i][col-i] = 0; //현재 좌표를 중심으로 대각선 왼쪽밑
		//			}
		//		}

	}

	private static boolean flag(int col) {
		for (int i=0;i<col;i++) {
			// 세로
			if (arr[col] == arr[i])
				return false;
			// 대각선
			if (col-i == Math.abs(arr[col]-arr[i]))
				return false;
		}
		return true;
	}
}