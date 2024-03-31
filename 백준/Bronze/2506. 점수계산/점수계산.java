import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//총 합에 더해줄 값을 저장할 변수 선언
		int val = 0;
		//총 합을 저장할 변수 선언
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(st.nextToken());
			
			//입력값이 0이면 val을 0으로 초기화, 0이 아닐 경우 1을 더해준다.
			if(M == 0) {
				val = 0;
			}else {
				val += 1;
			}
			sum += val;
		}
		System.out.println(sum);
	}

}