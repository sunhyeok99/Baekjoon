import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int maxheight = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>maxheight) maxheight = arr[i][j];
			}
		}
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};

		int max =0;
		int cnt=0;
		int water = maxheight-1;
		int[][] tmp = new int[N][N];	
		while(true) {
			for(int i = 0 ; i<N;i++) {
				for(int j = 0 ; j<N; j++) {
					tmp[i][j] = arr[i][j];
				}
			}//깊은복사		
			
			cnt=0;

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {					
					if(tmp[i][j] > water) {
						cnt++;
						qx.add(i);
						qy.add(j);
						tmp[i][j] = 0;
						while(true) {
							int x = qx.poll();
							int y = qy.poll();
							
							for(int in=0;in<4;in++) {																	
								if((x+dx[in])>=0 && (x+dx[in]) <N && (y+dy[in])>=0 && (y+dy[in])<N && tmp[x+dx[in]][y+dy[in]]>water) {
									qx.add(x+dx[in]);
									qy.add(y+dy[in]);	
									tmp[x+dx[in]][y+dy[in]] = 0;
								}								
							}
							// 들어온게 없으면 break
							if(qx.size()==0) {
								break;
							}
							
						} // while 문
					
					} // if 문
				} // j for 문
			} // i for문
			if(cnt>max) {
				max= cnt;
			}
			water --;
			if(water<=0) {
				break;
			}

		}

		System.out.println(max);

	}	


}
