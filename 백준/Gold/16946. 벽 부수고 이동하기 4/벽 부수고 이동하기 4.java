import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char[][] arr;
	static int[][] flag;
	static int number;

	static ArrayList<Integer> zero;
	static boolean[] zeronum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int i = 0;i<N;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		// 입력 끝
		flag = new int[N][M];
		number = 1;
		zero = new ArrayList<Integer>();
		zero.add(0);
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(arr[i][j] == '1' || flag[i][j] != 0) {
					continue;
				}
				setNum(i, j, number++);
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(arr[i][j]== '1') {
					change(i, j);
				}
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		bw.close();
	}
	static int[] dx = {0,0,-1,+1};
	static int[] dy = {-1,+1,0,0};

	public static void setNum(int i, int j, int number) {
		int count = 1;
		Queue<Integer> inputx = new ArrayDeque<Integer>();
		Queue<Integer> inputy = new ArrayDeque<Integer>();
		inputx.add(i);
		inputy.add(j);
		flag[i][j] = number;
		while(true) {
			if(inputx.size()==0) {
				break;
			}
			int x = inputx.poll();
			int y= inputy.poll();
			for(int in = 0;in<4;in++) {
				int nx = x + dx[in];
				int ny = y + dy[in];
				if(nx<0 | ny <0 || nx>=N || ny>=M || arr[nx][ny] != '0' || flag[nx][ny] != 0) {
					continue;
				}
				inputx.add(nx);
				inputy.add(ny);
				flag[nx][ny] = number;
				count ++;
			}
		}
		zero.add(number, count);
	}

	public static void change(int x , int y) {
		int num = 1;
		zeronum = new boolean[number];
		for(int i = 0 ;i< 4 ; i ++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=N || ny >=M || nx<0 || ny<0 || flag[nx][ny] ==0 || zeronum[flag[nx][ny]]) {
				continue;
			}
			zeronum[flag[nx][ny]] = true;
			num += zero.get(flag[nx][ny]);
		}
		arr[x][y] = (char) (num%10 + '0');

	}

}