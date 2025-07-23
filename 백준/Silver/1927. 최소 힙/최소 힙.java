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

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			if(tmp == 0){
				if(pq.isEmpty()){
					System.out.println(0);
				}
				else{
					System.out.println(pq.poll());
				}
			}
			else{
				pq.add(tmp);
			}
		}



	}



}