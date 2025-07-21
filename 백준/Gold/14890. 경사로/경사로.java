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
		M = sc.nextInt();
		// 경사로의 크기는 1차이어야 하며
		// 높이가 1차이일때 l개가 반복되어야한다.
		// -> 한줄 진행할때마다 true처리
		visited = new boolean[100];
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		ans = 0;
		for(int i =0 ;i < N;i++){
			// 시작지점에서 가로 세로 진행
			if(solve(i,0,true)){
				ans ++;
			}
			if(solve(0,i,false)){
				ans ++;
			}

		}
		System.out.println(ans);

	}

	public static boolean solve(int i ,int j, boolean isRow) {
		// 숫자를 배열하나에 쉽게 옮겨놓기 진행하자
		int[] line = new int[N];
		boolean[] visited = new boolean[N];
		for(int idx = 0 ; idx < N;idx++){
			if(isRow){
				line[idx] = arr[i][idx+j];
			}
			else{
				line[idx] = arr[idx+i][j];
			}
		}

		for(int idx =0 ;idx < N-1;idx++){
			// 진행하면서 4가지 경우
			// 차이가 2이면 그대로 종료
			// 0 이면 continue
			// 1이면 내리막
			// -1이면 오르막
			int dif = line[idx] - line[idx+1];
			if(Math.abs(dif) >= 2){
				return false;
			}
			if(dif == 0){
				continue;
			}
			if(dif == 1){
				// 내리막
				// 해당위치에서 l만큼 앞까지 계산
				for(int x = idx + 1  ; x <= idx + M ; x++){
					if((x < 0 || x >= N) || line[idx+1] != line[x] || visited[x]){
						return false;
					}
					visited[x] = true;
				}
			}
			// 오르막의 경우에는 앞에부터 앞쪽으로 만족하는지 확인
			else if(dif == -1){
				for(int x = idx ; x> idx - M; x --){
					if((x < 0 || x >= N) || line[x] != line[idx] || visited[x]){
						return false;
					}
					visited[x] = true;
				}

			}

		}
		return true;
	}



}