
import java.util.*;

public class Main {
	static class node{
		int x;
		int y;
		int cnt;
		node(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int N;
	static int M;
	static ArrayList<node> ar = new ArrayList<Main.node>();
	static int[][] map;
	static boolean[] choice;
	static int min = 0;
	static boolean[][] flag;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 0은 빈 칸, 1은 벽, 2는 바이러스의 위치
		// 우선 바이러스의 위치를 리스트에 추가하고
		// 총 개수에서 m개를 선택해서 각자를 돌려보자
		M = sc.nextInt();
		map = new int[N][N];
		count = 0;
		for(int i = 0 ; i < N ;i++) {
			for(int j = 0; j< N ;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					ar.add(new node(i,j,0));
				}
				if(map[i][j] == 0) {
					count ++;
				}
			}
		}
		// ar의 사이즈에서 M개를 선택하자
		choice = new boolean[ar.size()];
		min = Integer.MAX_VALUE;
		if(count == 0) {
			System.out.println(0);
			System.exit(0);
		}
		solve(0,0);
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
		
	}
	public static void solve(int index, int cnt) {
		if(index == ar.size()) {
			if(cnt == M) {
				// M개가 선택이 되었다면
				// 이제 해당 인덱스를  가지고 bfs 실시
				bfs();
			}			
			return;
		}
		
		
		// 현재를 선택 or 미선택
		choice[index] = true;
		solve(index+1, cnt+1);
		choice[index] = false;
		solve(index+1, cnt);
		
	}
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void bfs() {
		// 우선 선택된 것들을 모두 큐에 넣는다
		Queue<node> q = new LinkedList<Main.node>();
		for(int i = 0 ; i < ar.size();i++) {
			if(choice[i]) {
				node n = ar.get(i);
				q.add(new node(n.x,n.y,n.cnt));
			}
		}
		int[][] arr = new int[N][N];
		for(int i = 0 ; i< N;i++) {
			for(int j = 0 ; j< N;j++) {
				arr[i][j] = map[i][j];
			}
		}
			
		// 이제 큐에서 하나씩 꺼내서 넓혀가자
		int max = 0; // 현재 상태에서의 최대값을 보기위해
		int tmp = 0;
		flag = new boolean[N][N];
		a: while(true) {
			if(q.size()==0) {
				break;
			}
			node n = q.poll();
			for(int idx = 0 ; idx < dx.length; idx++) {
				int nx = n.x+ dx[idx];
				int ny = n.y + dy[idx];
//				System.out.println(nx+" "+ny+" "+(n.cnt+1));
				if(nx <0 || nx >= N || ny< 0 || ny >= N || arr[nx][ny] == 1 || flag[nx][ny]) {
					continue;
				}
				if(arr[nx][ny] == 0) {
					tmp ++;
				}
				arr[nx][ny] = 2;
				q.add(new node(nx, ny, n.cnt+1));
//				System.out.println(nx+" "+ny+" "+(n.cnt+1));
				flag[nx][ny] = true;
				max = Math.max(max, n.cnt+1);
				if(tmp == count ) {
					break a;
				}
			}		
			
		}
//		for(int i = 0 ; i< N;i++) {
//			for(int j = 0 ; j<N;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		// 만약 전체 벽을 다 탐색했다면 max값 갱신
		for(int i = 0 ; i< N;i++) {
			for(int j = 0 ;j<N;j++) {
				if(arr[i][j] == 0) {
					return;
				}
			}
		}
		min = Math.min(max, min);
	}
	
	
	
}
