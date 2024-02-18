import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.w3c.dom.Node;

public class Main {
	static class node{
		int x;
		int cost;
		public node(int x, int cost) {
			super();
			this.x = x;
			this.cost = cost;
		}

	}
	static int N;
	static ArrayList<node>[] ar;
	static int ans=0;
	static boolean flag[];
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ar = new ArrayList[N+1];
		for(int i = 0;i<N+1;i++) {
			ar[i] = new ArrayList<>();
		}
		// 초기화완료

		for(int i = 0;i<N;i++) {
			int st = sc.nextInt();
			while(true) {
				int tmp = sc.nextInt();
				if(tmp == -1) {
					break;
				}
				ar[st].add(new node(tmp , sc.nextInt()));
			}
			// -1이아니면 쭉 tmp번째에 add하고
			// -1이면 다음순서로

		}
		// 입력 끝
		solve(1);
		solve(max);
		// 1번에서 시작한번하고
		// 한번은 제일 마지막에 있는거부터 시작
		System.out.println(ans);



	}
	// 1에서 시작해서 가장 먼 거리에 존재하는
	// index를 먼저구함
	// 그다음 멀리있던거에서 한번 더돌려서
	// 지름구하기
	public static void solve(int index) {
		flag = new boolean[N+1];
		Queue<node> q = new LinkedList<>();
		q.add(new node(index, 0));
		flag[index] = true;
		int maxCost = 0;

		while (true) {
			if(q.size()==0) {
				break;
			}
			node now = q.poll();
			if(now.cost>maxCost){
				maxCost = now.cost;	// 가장 멀리 떨어진 노드의 거리
				max = now.x;	// 가장 멀리 떨어진 노드의 번호
			}

			for (node n : ar[now.x]) {
				if(!flag[n.x]){
					flag[n.x] = true;
					q.add(new node(n.x, now.cost + n.cost));

				}
			}

		}

		ans = Math.max(ans, maxCost);

	}

}