import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int L;
	static int R;
	static int[][] arr;
	static boolean[][] flag;
	static int cnt; // 땅의 개수
	static int day;
	static int sum;
	static boolean tmp;
	static Queue<Integer> qx = new LinkedList<>();
	static Queue<Integer> qy = new LinkedList<>();
	static ArrayList<Integer> arx = new ArrayList<>();
	static ArrayList<Integer> ary = new ArrayList<>();
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][N];
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		flag = new boolean[N][N];
		cnt =0;
		day = 0;
		while(true) {
			tmp = false;
			flag = new boolean[N][N];
			for(int i =0;i<N;i++) {
				for(int j =0;j<N;j++) {
					if(!flag[i][j]) {
						qx.add(i);
						qy.add(j);
						flag[i][j] = true;
						bfs();
						arx = new ArrayList<>(); // 얘네는 초기화
						ary = new ArrayList<>();
					}
				}
			}
			day++;
			if(!tmp) {
				break;
			}		
		}
		System.out.println(day-1);
//		for(int i =0;i<N;i++) {
//			for(int j =0;j<N;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}	

	public static void bfs() {
		cnt =0;
		sum=0;
		while(qx.size()!=0) {
//			System.out.println(qx.size());
			int x = qx.poll();
			int y = qy.poll();
			sum+= arr[x][y];
			cnt++;
			arx.add(x);
			ary.add(y);
			// 일단 돌려서 범위 내 숫자 초기화
			for(int in =0;in<4;in++) {
				int ax = x+dx[in];
				int ay = y+dy[in];
				if(ax<0 || ax>=N|| ay<0 || ay>=N) {
					continue;
				}
				if(Math.abs(arr[x][y]-arr[ax][ay])>=L &&Math.abs(arr[x][y]-arr[ax][ay])<=R && !flag[ax][ay]) {
//					System.out.println(qx+" "+qy+" "+x+" "+ y);
					qx.add(ax);
					qy.add(ay);
					tmp = true;
					flag[ax][ay] = true;
				}

			}

		}
		// 한번의 루트 끝나면 계산
		if(tmp) {
		solve();
		}
	}
	public static void solve() {
//		System.out.println(sum);
//		System.out.println(cnt);
		for(int i =0;i<arx.size();i++) {
			arr[arx.get(i)][ary.get(i)] = sum/cnt;
		}	
	}

}