import java.util.*;

public class Main {
	static int N, M ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] arr = new int[N][3]; // 0은 숫자 , 1은 스트, 2는 볼
		for(int i = 0 ; i < N ; i++){
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}
		int ans = 0;
		// 같은 숫자 안겹치고, 1~9까지의 숫자로 모두 실행
		for(int num = 123; num <= 987; num++){
			String tmp = Integer.toString(num);
			String a = tmp.substring(0,1);
			String b = tmp.substring(1,2);
			String c = tmp.substring(2,3);
			if(a.equals("0") || b.equals("0") || c.equals("0") || a.equals(b) || b.equals(c) || c.equals(a)){
				continue;
			}
			int count = 0;
			for(int i = 0 ; i < arr.length ; i++){
				String tmp2 = Integer.toString(arr[i][0]);
				int Strike = arr[i][1];
				int ball = arr[i][2];
				String a2 = tmp2.substring(0,1);
				String b2 = tmp2.substring(1,2);
				String c2 = tmp2.substring(2,3);

				int nowStrike = 0;
				int nowBall = 0;
				if(a.equals(a2)){
					nowStrike++;
				}
				if(b.equals(b2)){
					nowStrike++;
				}
				if(c.equals(c2)){
					nowStrike++;
				}
				if(a.equals(b2) || a.equals(c2)){
					nowBall++;
				}
				if(b.equals(a2) || b.equals(c2)){
					nowBall++;
				}
				if(c.equals(a2) || c.equals(b2)){
					nowBall++;
				}

				if(nowStrike == Strike && nowBall == ball){
					count++;
				}
			}
			if(count == arr.length){
				ans++;
			}
		}

		System.out.println(ans);

	}



}