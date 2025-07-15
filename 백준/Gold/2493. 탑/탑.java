import java.util.*;
import java.io.*;

public class Main {
	static int N, M ;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		// N = sc.nextInt();
		// M = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		// 일자로 쭉 늘어선거에서
		// 6 9 5 7 4
		// 0 0 2 2 4 -> 시작점에서 바로 높은 탑의 위치 값을 넣음

		// 시작하면서 0으로 시작하고
		// 전값보다 큰값이 나오면 전값을 pop해서 비교하고
		// 만약 크기가 0이면 그값도 0을 넣어준다.
		// 이거를 반복
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 비었다면 해당 수는 0 추가
			while(!stack.isEmpty()) {
				// 해당 높이가 전에거보다 크다면 pop, 아니면 peek의 높이 저장
				if(stack.peek()[1] >= num){
					System.out.print((stack.peek()[0])+" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(new int[] {i+1, num});
		}




	}



}