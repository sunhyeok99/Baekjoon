import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] flag; // 방문했는지 확인
	static int day;
	static int[] dx = {-1,1,0,0};
	static int[] dy=  {0,0,1,-1};
	static int cnt;
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	static ArrayList<Integer> arx;
	static ArrayList<Integer> ary;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		N  =sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		arx = new ArrayList<Integer>();
		ary = new ArrayList<Integer>();
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] != 0) {
					arx.add(i);
					ary.add(j);
				}
			}
		}
		// 입력완료

		qx = new LinkedList<Integer>();
		qy = new LinkedList<Integer>();
		day = 0;
		for(int i =0;i<arx.size();i++) {
			flag = new boolean[N][M];
			if(arr[arx.get(i)][ary.get(i)] != 0 && !flag[arx.get(i)][ary.get(i)]) {
				solve(arx.get(i),ary.get(i));		
//				for(int a =0;a<N;a++) {
//					for(int b =0;b<M;b++) {
//						System.out.print(arr[a][b]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
				day++;
				if(!check()) {
					break;
				}
				i -= 1;
			}			
		}

		System.out.println(day);

	}
	public static void solve(int ax, int ay) {
		qx.add(ax);
		qy.add(ay);
		flag[ax][ay] = true;
		while(true) {
			int x = qx.poll();
			int y = qy.poll();
			int tmp = 0;
			for(int in= 0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(arr[nx][ny] !=0 && !flag[nx][ny]) {
						qx.add(nx);
						qy.add(ny);
						flag[nx][ny] = true;
					}
					else if(arr[nx][ny] == 0 && !flag[nx][ny]) {
						tmp++;	
					}					
				}

			}
			arr[x][y] -= tmp;
			if(arr[x][y]<0) {
				arr[x][y] = 0;
			}
			if(qx.size()==0) {
				break;
			}
		}

	}
	public static boolean check() {
		Queue<Integer> tmpqx = new LinkedList<Integer>();
		Queue<Integer> tmpqy = new LinkedList<Integer>();
		for(int i =0;i<arx.size();i++) {
			if(arr[arx.get(i)][ary.get(i)] != 0 ) {
				tmpqx.add(arx.get(i));
				tmpqy.add(ary.get(i));
				break;
			}
		}
		if(tmpqx.size()==0) {
			day = 0;
			return false;
		}
		boolean[][] tmp = new boolean[N][M];
		tmp[tmpqx.peek()][tmpqy.peek()] = true;
		while(true) {
			int x = tmpqx.poll();
			int y = tmpqy.poll();
			for(int in= 0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(arr[nx][ny] !=0 && !tmp[nx][ny]) {
						tmpqx.add(nx);
						tmpqy.add(ny);
						tmp[nx][ny] = true;
					}		
				}
			}
			if(tmpqx.size()==0) {
				break;
			}
		}

		for(int i =0;i<arx.size();i++) {
			if(arr[arx.get(i)][ary.get(i)] !=0 && !tmp[arx.get(i)][ary.get(i)]) {
				return false;
			}
		}
		return true;

	}

}
