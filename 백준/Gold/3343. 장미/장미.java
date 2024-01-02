import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static long N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c=  sc.nextLong();
		long d = sc.nextLong();
		// N개의 개수를 구매할 때
		// 더 낮은 가격을 구매하게 하고
		// 가성비 개수보다 낮은 숫자일때만
		// 어떤게 더 이득인지 계산하면 됨
		// 정답

		// 가성비가 좋지않은 것을 앞에다 놓는것
		if (b * c < d * a) { // D/C > B/A ->  D / C * A > B -> D * A > B * C (가성비가 안 좋은 것을 선택)
			// 뒤에있는 것이 가성비가 더 좋지 않은 것으로
			// a와b랑 c와d의 자리 바꾸는 과정
			long tmp = b;
			b = d;
			d = tmp;
			tmp = a;
			a = c;
			c = tmp;
		}
		
		long ans = Long.MAX_VALUE;

		for (int i = 0; i < c; i++) { //가성비가 안 좋은 것을 돌림 두번째 것을 안 좋은 가성비로 판단
			long tmp = (long) Math.ceil((double)(N - i * a)/c);
			if (tmp < 0) {
				break;
			}
			ans = Math.min(ans, i * b + tmp * d);

		}
		System.out.println(ans);
	}
}