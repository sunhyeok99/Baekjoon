import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static boolean[] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// 입력받고 서로다른 2개를 바꾼상태에서
		// 열과 행이 가장 긴 개수만 count
		N = sc.nextInt();
		arr = new int[N][N];
		for(int i = 0; i < N; i++){
			String line = sc.next();
			for(int j = 0 ; j<N;j++){
				String tmp = line.substring(j,j+1);
				if(tmp.equals("C")){
					arr[i][j] = 1;
				}
				else if(tmp.equals("P")){
					arr[i][j] = 2;
				}
				else if(tmp.equals("Z")){
					arr[i][j] = 3;
				}
				else{
					arr[i][j] = 4; // Y
				}
			}
		}
		// 이제 스왑 진행해보자
		// 스왑은 오른쪽 or 밑이랑만 진행
		ans = 0;
		for(int i = 0 ; i < N;i++){
			for(int j = 0 ; j < N; j++){
				// 1. 오른쪽
				if(j != N -1 && arr[i][j] != arr[i][j+1]){
					swap(i,j, i, j+1);
					// 이제 계산
					solve();
					//다시 복구
					swap(i,j, i, j+1);
				}
				// 2. 아래
				if(i != N-1 && arr[i][j] != arr[i+1][j]){
					swap(i,j, i+1, j);
					// 이제 계산
					solve();
					// 다시 복구
					swap(i,j, i+1, j);
				}
			}
		}
		System.out.println(ans);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void swap(int a, int b, int c, int d){
		int tmp = arr[a][b];
		arr[a][b] = arr[c][d];
		arr[c][d] = tmp;
	}

	public static void solve(){
		int count = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0 ; j < N; j++){
				// 현재점을 기준으로 밑과 오른쪽 탐색
				int plus = 1;
				// 우측먼저
				while(true){
					if(j+plus >= N || arr[i][j] != arr[i][j+plus]){
						count = Math.max(count, plus);
						break;
					}
					plus++;
				}
				// 다했으면 plus 초기화
				plus = 1;
				while(true){
					if(i+ plus >= N || arr[i][j] != arr[i+plus][j]){
						count = Math.max(count, plus);
						break;
					}
					plus++;
				}
			}
		}
		ans = Math.max(ans, count);

	}

}