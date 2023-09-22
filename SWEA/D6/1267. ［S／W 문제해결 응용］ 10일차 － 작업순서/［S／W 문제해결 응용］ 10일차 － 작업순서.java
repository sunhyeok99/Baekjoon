import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Solution {
	static int N;
	static int M;
	static int[][] arr;
	static int[] flag; // 깊이
	static boolean[] visited;
	static Stack<Integer> ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N+1][N+1];
			flag = new int[N+1];
			visited = new boolean[N+1];
			for(int i=0;i<M;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[a][b] = 1;
				flag[b]++;
			}
			// 모두다 설정 완료

			ans = new Stack<>();
			for(int i=1;i<=N;i++) {
				if(flag[i]==0) { // 일단 깊이가 0인거부터 시작
					solve(i);
				}
			}
			System.out.print("#"+tc+" ");
			while(ans.size()!=0) {
				System.out.print(ans.pop()+" ");
			}
			System.out.println();


		}
	}
	// cnt는 깊이를 나타내는 말
	public static void solve(int idx) {
		visited[idx] = true; // 먼저 방문처리해줌
		
		for(int i =1;i<=N;i++) {
//			System.out.println(idx+" "+i);
//			System.out.println(arr[idx][i]);
			// 현재 간선이 연결되어있고 , 방문안한 지점 확인
			if(arr[idx][i] == 1 && !visited[i]) {
				solve(i); // 연결된 다음 노드로 dfs 시작
			}
		}
		// 끝에서 부터 stack에 담아준다
		ans.add(idx);
	}

}