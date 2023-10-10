import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class pos{
		int x;
		int y;
		int dis;
		boolean wall;
		public pos(int x, int y, int dis,boolean wall) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.wall = wall;
		}

	}
	static int N;
	static int M;
	static int[][] arr;
	static boolean[] flag;
	static Queue<pos> q;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			String tmp = sc.next();
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(tmp.substring(j,j+1));
			}
		}
		q = new LinkedList<>();
		min = 987654231;
		bfs();
		if(min==987654231) min = -1;
		System.out.println(min);

	}



	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void bfs() {
		q.add(new pos(0,0,1,false));
		// 일단 0,0을 넣고 시작
		// boolean타입도 설정
		boolean[][][] flag = new boolean[2][N][M]; // 방문했는지 

		while(true) {
			pos p = q.poll();
			int x =p.x;
			int y =p.y;
			if(x==N-1 && y==M-1) {
				min = Math.min(min, p.dis);
				return;
			}
			if(p.dis>=min) {
				return;
			}
			for(int in=0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
//					System.out.println(p.x+" "+p.y+" "+p.wall);
					if(arr[nx][ny]==0) {
						// 일단 0인경우 벽을 뚫었는지 안뚫었는지 판단해야함
						if (!p.wall) { 
							if (flag[0][nx][ny]) continue; // 방문한 곳이면 패스
							flag[0][nx][ny] = true; // 벽 안부순 방문처리
							q.add(new pos(nx, ny, p.dis+1, false));
						} else { 
							if (flag[1][nx][ny]) continue; // 방문한 곳이면 패스
							flag[1][nx][ny] = true; // 벽 부순 방문처리
							q.add(new pos(nx, ny, p.dis+1, true));
						}
					}					
					else if(arr[nx][ny] ==1 && !p.wall) {
						q.add(new pos(nx,ny,p.dis+1,true));
						flag[1][nx][ny]= true;
					}
				}
			}

			if(q.size()==0) {
				return; // size가 0이면 break
			}
		}



	}
}