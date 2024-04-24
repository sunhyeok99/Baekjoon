import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1][N+1];
		
		
		for(int i = 1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }
		// arr에서 쭉 dfs 돌다가 1인지점 만나면 return 
		for(int i = 1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
