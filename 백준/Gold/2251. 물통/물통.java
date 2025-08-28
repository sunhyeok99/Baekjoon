import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int ans;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dp;

	static int A;
	static int B;
	static int C;
	static HashSet<Integer> answer;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		answer = new HashSet<>();
		// 모든 경우의수 진행
		int[] tmp = new int[3];
		tmp[2] = C;

		visited = new boolean[201][201][201];
		solve(tmp[0], tmp[1], tmp[2]);
		List<Integer> result = new ArrayList<>(answer);
		Collections.sort(result);
		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void solve(int a, int b, int c){
		// 총 6가지
		// a-> b , a-> c , b-> a, b-> c , c->a,c->b
		//하고 방문처리
		// 다하면 solve진행
		if(visited[a][b][c]){
			return;
		}
		visited[a][b][c] = true;
		// a가 비어있을때만 경우 count
		if(a == 0){
			answer.add(c);
		}
		// 6가지 각각 실행(넘칠경우 가능할경우 2가지로 나뉨)
		// b-> a
		if(a + b > A){
			solve(A , a + b - A, c);
		}
		else{
			solve(a + b, 0 , c);
		}
		// c -> a
		if(a + c > A){
			solve(A , b, a+c -A);
		}
		else{
			solve( a+ c , b , 0);
		}
		// a -> b
		if(a + b > B){
			solve(a+b - B, B, c);
		}
		else{
			solve(0, a+b, c);
		}
		// c-> b
		if(b + c > B){
			solve(a, B, b+c - B);
		}
		else{
			solve(a , b+c , 0);
		}
		// a-> c
		if(a+ c > C){
			solve(a+c - C, b, C);
		}
		else{
			solve(0, b, a+c);
		}
		// b -> c
		if(b+c > C){
			solve(a, b+c - C, C);
		}
		else{
			solve(a, 0, b+c);
		}

	}

}