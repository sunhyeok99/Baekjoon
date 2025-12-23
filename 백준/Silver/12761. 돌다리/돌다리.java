import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[] arr;
	static int[][] map;
	static int[] visited;
	static boolean[][] flag;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer> ar[];
	static int ansX, ansY;
	static PriorityQueue<Integer> q;
	static int tmp;

	static int A, B;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// 각 자리마다 횟수 써놓고 방문처리
		arr = new int[100001];
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();

		boolean visited[] = new boolean[100001];
		int answer[]=new int[100001];
		Queue<Integer>queue=new LinkedList<>();
		queue.add(N);
		visited[N]=true;

		while(!queue.isEmpty()) {
			int temp=queue.poll();
			int arr[]={temp-1,temp+1, temp-A,temp+ A, temp-B, temp+B, temp*A, temp*B};
			for(int i=0; i<8; i++) {
				if(arr[i]>=0 && arr[i]<=100000 && !visited[arr[i]]) {
					visited[arr[i]]=true;
					answer[arr[i]]=answer[temp]+1;
					queue.add(arr[i]);
				}
			}
			if(answer[M]>0)break;
		}
		System.out.println(answer[M]);
	}

	public static int[] dx = {1, -1, 0, 0,-1,-1,1,1};
	public static int[] dy = {0, 0, 1, -1,-1,1,-1,1};



}