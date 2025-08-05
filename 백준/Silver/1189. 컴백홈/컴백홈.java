import java.util.*;
import java.io.*;

public class Main {
	static int N, M, L ;
	static int ans;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// 최단거리가 아닌 정해진 거리만큼이동이라 dp가 불가능
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		// N-1,0 에서 시작 -> 0, M-1로 도착

		ans = 0;
		boolean[][] flag = new boolean[N][M];
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				String tmp = line.substring(j, j+1);
				if(tmp.equals("T")){
					arr[i][j] = 1;
				}
			}
		}
		flag[N-1][0] = true;
		solve(N-1, 0 , 0 , flag);
		System.out.println(ans);

	}
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0,0,-1,1};

	public static void solve(int i, int j , int cnt, boolean[][] flag){
		if(cnt == L-1){
			if(i == 0 && j == M-1){
				ans ++;
			}
			return;
		}

		for(int k = 0; k < 4; k++){
			int x = i + dx[k];
			int y = j + dy[k];
			if(x >= 0 && x < N && y >= 0 && y < M && !flag[x][y] && arr[x][y] == 0){
				flag[x][y] = true;
				solve(x,y,cnt+1,flag);
				flag[x][y] = false;
			}

		}


	}


}