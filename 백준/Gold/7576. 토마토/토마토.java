import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> ax ;
	static ArrayList<Integer> ay ;
	public static void main(String[] args) throws IOException {		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int cnt =0;
		int suma =0;
		int sumb=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) {
					suma++;
				}
				if(arr[i][j] == 1) {
//					ax.add(i);
//					ay.add(j);
					qx.add(i);
					qy.add(j);
					sumb++;	
				}
			}
		}
	
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
//		System.out.println(qx.poll());
		
		while(true) {
			if(N*M == sumb-suma) {
				break;
			}
			int tmp = qx.size();
			for(int tc=0;tc<tmp;tc++) {
				int x = qx.poll();
				int y = qy.poll();
//				int x = ax.get(0);
//				int y = ay.get(0);
//				ax.remove(0);
//				ay.remove(0);
				for(int in=0;in<4;in++) {
					if(x+dx[in]>=0 && x+dx[in]<N && y+dy[in]>=0 && y+dy[in]<M && arr[x+dx[in]][y+dy[in]]==0) {
//						ax.add(x+dx[in]);
//						ay.add(y+dy[in]);
						qx.add(x+dx[in]);
						qy.add(y+dy[in]);
						arr[x+dx[in]][y+dy[in]] = 1;
						sumb++;
					}

				} // in for문			
				// 처음들어있던게 2개면 2번돌고 다시 tmp를 ax.size로
				// tmp 만큼 반복
			} // tc for문
			// ax사이즈가 0이면 다 끝난것이므로
			if(qx.size()==0) {
				break;
			}
			cnt++;
		}

		if(suma+sumb !=N*M) {
			cnt=-1;
		}
		System.out.println(cnt);


		
	}	
	

}
