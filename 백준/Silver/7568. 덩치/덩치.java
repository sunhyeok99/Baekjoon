import java.util.*;
import java.io.*;

public class Main {
	static int N, M ;
	static int ans;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		// 등수 정하려면 각각 노가다..?
		int[] answer = new int[N];
		for(int i = 0; i < N; i++) {
			int num = 0;
			for(int j = 0; j < N; j++) {
				if(i == j){
					continue;
				}
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					num++;
				}
			}
			answer[i] = num+1;
		}

		for(int i = 0; i < N; i++) {
			System.out.print(answer[i] + " ");
		}



	}




}