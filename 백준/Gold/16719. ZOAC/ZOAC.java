import java.util.Scanner;

public class Main {


	static String N;
	static boolean[] flag;
	static char[] ans;
	static char[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		N = sc.next();
		flag = new boolean[N.length()];
		ans = new char[N.length()];
		arr = N.toCharArray();
//		for(int i =0;i<N.length();i++) {
			ans = N.toCharArray();
					
//		}
//			System.out.println(Arrays.toString(ans));
		say(0,N.length()-1);
		
	}
	public static void say(int left, int right) {
		if(left > right) {
			return;
		}
		int idx= left;
		for(int i =left;i<=right;i++) {
			if(ans[idx]>ans[i]) {
				idx = i;
			}
		}
//		ans[idx] = 'ㅓ';
		flag[idx] = true;
		for(int i =0;i<ans.length;i++) {
			if(flag[i]) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
		say(idx+1, right); // 해당지점을 기준으로 뒤로 쭉
		say(left, idx-1);
		
	}


}
