import java.util.*;

public class Main {
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();	// 출력할 결과물 저장

		Stack<Integer> stack = new Stack<>();

		int N = sc.nextInt();

		int start = 0;

		// N 번 반복
		while(N -- > 0) {

			int value = sc.nextInt();

			if(value > start) {
				// start + 1부터 입력받은 value 까지 push를 한다.
				for(int i = start + 1; i <= value; i++) {
					stack.push(i);
					sb.append('+').append('\n');	// + 를 저장한다.
				}
				start = value; 	// 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
			}

			// top에 있는 원소가 입력받은 값과 같이 않은 경우
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;		// 또는 System.exit(0); 으로 대체해도 됨.
			}

			stack.pop();
			sb.append('-').append('\n');

		}

		System.out.println(sb);
	}


}