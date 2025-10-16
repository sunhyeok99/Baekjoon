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

		// 이거 빨리끝나는 순으로 정렬 + 시작하나를 정하고 그 빨리끝나는 숫자보다 이상인 회의를 시작하면된다.
		// 모두 node를 만들어서 pq사용
		PriorityQueue<node> pq = new PriorityQueue<>();
		N = sc.nextInt();
		for(int i = 0 ; i < N; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			pq.add(new node(a,b));
		}
		ans = 0;
		int end = 0;
		// 시작
		while(!pq.isEmpty()){
			// 하나를 꺼내서 end보다 현재 y값이 크다면 +1해주고 교체
			// 아니면 continue
			// end값만 갱신
			node n = pq.poll();
			if(end <= n.x){
				end = n.y;
				ans++;
			}
		}
		System.out.println(ans);
	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	static class node implements Comparable<node>{
		int x, y;
		node(int x , int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(node o){
			if(o.y == this.y){
				return this.x - o.x;
			}
			return this.y - o.y;
		}

	}

}