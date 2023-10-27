import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int time;
	static int cnt;
	static Queue<Integer> qx;
	static int[] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 시작지점
		M = sc.nextInt(); // 도착지점
		qx = new LinkedList<>();
		flag = new int[100001];
		flag[N] = 0;
		qx.add(N);
		cnt =0 ; // 개수
		time =987654321; //시간
		solve();
		System.out.println(time);
		System.out.println(cnt);
	}
	public static void solve() {
		while(true) {
			int x = qx.poll();
			if(x==M) {
				time = flag[x];
				cnt +=1;
			}
			if(time<flag[x]) {
				break;
			}
			if(x-1>=0 && (flag[x-1] ==0 || flag[x-1] ==flag[x]+1)) {
				qx.add(x-1);
				flag[x-1]= flag[x]+1;
			}
			if(x+1<=100000 && (flag[x+1] ==0 || flag[x+1] ==flag[x]+1)) {
				qx.add(x+1);
				flag[x+1]= flag[x]+1;
			}
			if(x*2<=100000 && (flag[x*2] ==0 || flag[2*x] == flag[x]+1)) {
				qx.add(x*2);
				flag[x*2]= flag[x]+1;
			}
			if(qx.size()==0) {
				break;
			}
		}
		
	}
}