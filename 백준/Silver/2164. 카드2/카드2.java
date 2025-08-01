import java.util.*;
import java.io.*;

public class Main {
	static int N, M ;
	static int ans;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 1~n 까지 다 숫자를 큐에 넣고
		// 하나는 버리고
		// 하나는 뒤에다 넣고 반복
		// 숫자가 하나 남을때까지 진행
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			q.add(i+1);
		}

		while(q.size()>1) {
			q.poll();
			q.add(q.peek());
			q.poll();
		}
		System.out.println(q.peek());




	}



}