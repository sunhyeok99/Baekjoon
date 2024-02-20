import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];

		for(int i =0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		// 숫자는 그대로 입력받는데로 -해버린다
		for(int i=0;i<N;i++) {
			arr[i] = arr[i] - sc.nextInt();
		}
		// 입력끝
		int ans = 0;
		for(int i =0;i<N;i++) {
			boolean flag = false;
			if(arr[i]>0) flag = true;
			int tmp = Math.abs(arr[i]);
			for(int j = i;j<N;j++) {
				// 두개가 같은 방향이면
				// j는 계속 늘어남
				if((flag && arr[j]>0) || (!flag && arr[j]<0)) {
					tmp = Math.min(tmp, Math.abs(arr[j]));
					if(j != N-1) {
						continue;
					}
					j++;
				}
				// 최소 올라갈 만큼
				// i ~ j 까지 쭉 더함 
//				System.out.println(ans+" "+tmp);
//				for(int a=0;a<N;a++) {
//					System.out.print(arr[a]+" ");
//				}
//				System.out.println();
				ans += tmp;
				if(flag) tmp*=-1;
				for(int idx=i;idx<j;idx++) {
					arr[idx] +=tmp;
				}
				if(arr[i]!=0) i--;
				break;
			}
		}
		System.out.println(ans);

	}
}