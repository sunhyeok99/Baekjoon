import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		arr = new int[5][5];
		for(int i = 0 ; i < 5 ; i ++){
			for(int j = 0 ; j < 5 ; j ++){
				arr[i][j] = sc.nextInt();
			}
		}
		// 여기서 하나씩 입력할때마다 숫자를 지우고
		// 그 숫자를 기준으로 4방향으로 빙고가 되는지 탐색(대각선은 i j 가 같을떄만 확인)
		// 만약 된다면 count++
		ans = 0;
		visited = new boolean[5][5];
		for(int k = 0 ; k < 25 ; k ++){
			int num = sc.nextInt();
			// 이숫자를 먼저 지움
			delete(num);
			// 이거를 수행했을때 5개이상이면 끝
			if(ans >= 3){
				System.out.println(k+1);
				System.exit(0);
			}
		}


	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void delete(int num){
		for(int i = 0 ; i < 5 ; i ++){
			for(int j = 0 ; j < 5 ; j ++){
				if(arr[i][j] == num){
					visited[i][j] = true;
					// 지우고 이숫자를 기준으로 탐색
					find(i,j);
				}
			}
		}

	}
	public static void find(int x, int y){
		//가로 먼저 탐색
		if(visited[x][0] && visited[x][1] && visited[x][2] && visited[x][3] && visited[x][4]){
			ans++;
		}
		// 세로 탐색
		if(visited[0][y] && visited[1][y] && visited[2][y] && visited[3][y] && visited[4][y]){
			ans++;
		}
		// 대각선탐색
		if(x == y) {
			if (visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4]) {
				ans++;
			}
		}
		if(4-x == y){
			if(visited[4][0] && visited[3][1] && visited[2][2] && visited[1][3] && visited[0][4]){
				ans++;
			}
		}
	}

}