import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int[] printArr;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		
		arr = new int[N]; // 입력받은 배열
		printArr = new int[N]; // 출력할 배열
		isVisited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(arr); // 오름차순으로 정렬했다.
		
		dfs(0, 0);
	}
	
	static void dfs(int startIdx, int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(printArr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true; // 자기 자신은 빼고 배열에 담아야 함으로 boolean 배열을 추가해줬다.
				printArr[depth] = arr[i];
				dfs(i + 1, depth + 1);
				isVisited[i] = false;
			}
		}
		
	}
}