import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dp;

	static int Q; // 2
	static int K; // 3
	static int P; // 4
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// Q는 대각선 이동 - 중간에 장애물있으면 불가능
		// K는 말
		// P는 장애물역할
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N+1][M+1];
		Q = sc.nextInt();
		for(int i = 0 ; i < Q ; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 2;
		}
		K = sc.nextInt();
		for(int i = 0 ; i < K ; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 3;
		}
		Q = sc.nextInt();
		for(int i = 0 ; i < Q ; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 4;
		}

		// 해당 좌표들의 움직임이 가능한 곳을 1로 바꾸자
		// 0의 개수만 count하면될듯
		for(int i = 1 ; i <= N ; i++){
			for(int j = 1 ; j <= M ; j++){
				if(arr[i][j] > 1){
					move(i, j , arr[i][j]);
				}
			}
		}

		int count = 0;
		for(int i = 1 ; i <= N ; i++){
			for(int j = 1 ; j <= M ; j++){
				if(arr[i][j] == 0){
					count++;
				}
			}
		}
		System.out.println(count);


	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static int[] dnx = {-2, -1, -2, -1, 1, 2, 2 ,1};
	public static int[] dny = {-1, -2, 1, 2, 2, 1, -1, -2};

	public static void move(int x, int y, int type){
		// type이 2일 경우 대각선 4방향
		// 3일 경우 말이동
		if(type == 2){
			// 대각선으로 4방향 각각 이동
			// while문으로 0이나 1일때만

			// 1. 왼쪽위
			int nx = x -1;
			int ny = y -1;
			while(true){
				if(nx> 0 && ny >0 && arr[nx][ny] < 2){
					arr[nx][ny] = 1;
				}
				else{
					break;
				}
				nx -= 1;
				ny -= 1;
			}
			// 2. 왼쪽 아래
			nx = x +1;
			ny = y -1;
			while(true){
				if(nx <= N && ny > 0 && arr[nx][ny] < 2){
					arr[nx][ny] = 1;
				}
				else{
					break;
				}
				nx += 1;
				ny -= 1;
			}
			// 3. 오른쪽 위
			nx = x -1;
			ny = y +1;
			while(true){
				if(nx >0 && ny <= M && arr[nx][ny] < 2){
					arr[nx][ny] = 1;
				}
				else{
					break;
				}
				nx -= 1;
				ny += 1;
			}
			// 4. 오른쪽 아래
			nx = x +1;
			ny = y +1;
			while(true){
				if(nx <= N && ny <= M && arr[nx][ny] < 2){
					arr[nx][ny] = 1;
				}
				else{
					break;
				}
				nx += 1;
				ny += 1;
			}
			// 위
			nx = x -1;
			while(true){
				if(nx >0 && arr[nx][y]< 2){
					arr[nx][y] = 1;
				}
				else{
					break;
				}
				nx -= 1;
			}
			nx = x +1;
			while(true){
				if(nx <= N && arr[nx][y] < 2){
					arr[nx][y] = 1;
				}
				else{
					break;
				}
				nx += 1;
			}
			ny = y -1;
			while(true){
				if(ny > 0 && arr[x][ny] < 2){
					arr[x][ny] = 1;
				}
				else{
					break;
				}
				ny -= 1;
			}
			ny = y + 1;
			while(true){
				if(ny <=M && arr[x][ny] < 2){
					arr[x][ny] = 1;
				}
				else{
					break;
				}
				ny += 1;
			}
		}
		else if(type == 3){
			// 8가지 방향 각각 이동
			// 이거 미리 dnx dny 만들어놓자
			for(int i = 0 ; i< 8;i++){
				int nx = x + dnx[i];
				int ny = y + dny[i];
				if(nx > 0 && ny > 0 && nx <= N && ny<=M && arr[nx][ny] < 2){
					arr[nx][ny] = 1;
				}
			}

		}


	}

}