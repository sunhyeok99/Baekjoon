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

		// 왼쪽 위에서 탐지했을 때
		// 가장 먼저 만나는 지점이 머리이다.
		// 바로 밑이 심장이고 왼쪽, 오른쪽 각각 팔길이 구하고
		// 허리 길이 구하고 대각선 밑에서 다리 길이 각각 구하자.
		int[] ans = new int[7];
		arr = new int[N][N];
		boolean flag = false;
		for(int i = 0 ; i < N ; i++){
				String line = sc.next();
			for(int j = 0 ; j < N ; j++){
				if(line.substring(j,j+1).equals("*")){
					if(!flag){ // 심장위치 바로 구함
						ans[0] = i+1;
						ans[1] = j;
						flag = true;
					}
					arr[i][j] = 1;
				}
			}
		}
		// 심장 기준으로 계산
		int x = ans[0];
		int y = ans[1]-1;
		int len = 0;
		while(arr[x][y] == 1){
			len ++;
			y --;
			if(y < 0){
				break;
			}
		}
		ans[2] = len;
		// 오른쪽 팔
		x = ans[0];
		y = ans[1]+1;
		len = 0;
		while(arr[x][y] == 1){
			len ++;
			y ++;
			if(y == N){
				break;
			}
		}
		ans[3] = len;
		// 허리
		x = ans[0]+1;
		y = ans[1];
		len = 0;
		while(arr[x][y] == 1){
			len ++;
			x ++;
		}
		ans[4] = len;
		// 왼쪽 다리
		x = ans[0]+ans[4]+1;
		y = ans[1] -1;
		len = 0;
		while(arr[x][y] == 1){
			len ++;
			x ++;
			if(x == N){
				break;
			}
		}
		ans[5] = len;
		// 오른쪽 다리
		x = ans[0]+ans[4]+1;
		y = ans[1]+1;
		len = 0;
		while(arr[x][y] == 1){
			len ++;
			x++;
			if(x == N){
				break;
			}
		}
		ans[6] = len;

		System.out.println((ans[0]+1)+" "+(ans[1]+1));
		System.out.println(ans[2]+" "+ans[3]+" "+ans[4]+" "+ans[5]+" "+ans[6]);


	}




}