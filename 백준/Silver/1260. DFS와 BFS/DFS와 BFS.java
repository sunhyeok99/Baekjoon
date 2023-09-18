import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,V;
	static boolean[] check;
	static int[][] arr;	
	static Queue<Integer> q = new LinkedList<>();
	static ArrayList<Integer> ans1 = new ArrayList<>();
	static ArrayList<Integer> ans2 = new ArrayList<>();
	public static void main(String[] args) throws IOException {		
		Scanner sc = new Scanner(System.in);		
		 N = sc.nextInt();
		 M = sc.nextInt();
		 V = sc.nextInt();		
		arr = new int[N+1][N+1];		
		check = new boolean[N+1];		
		for(int i = 0 ; i < M ; i ++) {			
			int a = sc.nextInt();
			int b = sc.nextInt();			
			arr[a][b] = arr[b][a] =  1;	
			// a - b 양방향이므로 둘다 서로 1로 값을 바꿔주고
			// 만약 값이 true면 패스
		}
	
		dfs(V);
		check = new boolean[N+1]; // 다시초기화		
		bfs(V);		
		for(int i =0;i<ans1.size();i++) {
			System.out.print(ans1.get(i)+" ");
		}
		System.out.println();
		for(int i =0;i<ans2.size();i++) {
			System.out.print(ans2.get(i)+" ");
		}
	}
	public static void dfs(int v) {		
		check[v] = true;
		ans1.add(v);
		for(int i = 0 ; i <= N ; i++) {
			if(arr[v][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int v) {
		q.add(v);
		check[v] = true;
		ans2.add(v);
		while(!q.isEmpty()) {			
			v = q.poll();			
			for(int i = 1 ; i <= N ; i++) {
				if(arr[v][i] == 1 && !check[i]) {
					q.add(i);
					ans2.add(i);
					check[i] = true;
				}
			}
		}


	}

}