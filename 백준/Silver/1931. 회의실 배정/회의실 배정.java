import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class node implements Comparable<node>{
		int x;
		int y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Main.node o) {
			if(this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		PriorityQueue<node> pq = new PriorityQueue<Main.node>();
		for(int i = 0 ; i <N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pq.add(new node(a, b));
		}
		// b가 작은순서대로 쭉 나열
		int min = -1;
		long cnt = 0;
		while(true) {
			if(pq.size() ==0) {
				break;
			}
			node n = pq.poll();
			if(min <= n.x) {
				min = n.y;
				cnt ++;
			}
			
		}
		System.out.println(cnt);

	}

}