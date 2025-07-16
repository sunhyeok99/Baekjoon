import java.util.*;
import java.io.*;

public class Main {
	static int N, M ;
	static int[] arr;
	static int[][] snake;
	static int[][] huddle;
	static boolean visited[] = new boolean[101];
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[101];
		for(int i = 0 ; i < N+ M;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a] =b;
		}
		// 1~6위치 만큼 이동하면서 a를 만나면 b로 이동하고
		// 최소값일 경우 q에 추가
		solve();
	}

	public static void solve() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{1,0});
		visited[1] = true;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			if(cur[0] == 100){
				System.out.println(cur[1]);
				return;
			}

			for(int i = 1;i<=6;i++){
				int num = cur[0] + i;
				if(num > 100){
					continue;
				}
				if(arr[num] != 0){
					num = arr[num];
				}
				if(visited[num]){
					continue;
				}
				visited[num] = true;
				q.add(new int[]{num,cur[1]+1});
			}



		}



	}

}