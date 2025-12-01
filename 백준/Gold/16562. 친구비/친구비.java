import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[] arr;
	static boolean[] visited;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer>[] ar;
	static int ansX, ansY;
	static PriorityQueue<Integer> q;
	static int tmp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N+1];

		ar = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i ++){
			arr[i] = sc.nextInt();
			ar[i] = new ArrayList<>();
		}
		for(int i =0 ; i< M;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			ar[a].add(b);
			ar[b].add(a);
		}

		// 입력받을 떄 여러개의 집합으로 나눌 수 있음
		// 1 , 3 ,4 가 하나라면 1 3 4의 값중 가장 적은 값 return
		// 1 ~ 방문처리하면서 최소값 가지고 있기
		visited = new boolean[N+1];
		int money = 0;
		for(int i = 1;  i<=N ; i++){
			if(visited[i]) continue;
			tmp = Integer.MAX_VALUE;
			find(i);
			money += tmp;
			if(money > K){
				System.out.println("Oh no");
				System.exit(0);
			}
		}
		System.out.println(money);

	}

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void find(int x){
		tmp =  Math.min(tmp, arr[x]);
		for(int i = 0 ; i < ar[x].size();i++){
			int num = ar[x].get(i);
			if(!visited[num]){
				visited[num] = true;
				find(num);
			}
		}
	}


}