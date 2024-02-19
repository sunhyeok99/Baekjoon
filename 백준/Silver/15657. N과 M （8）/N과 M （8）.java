import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static HashSet<String> hs = new HashSet<String>();
	static ArrayList<Integer> ar = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i = 0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		// 입력끝
		
		Arrays.sort(arr);
		// 정렬하고 index로 하나씩 고르자
		ArrayList<Integer> ar = new ArrayList<Integer>();
		solve(0,ar);
		
	}
	// ar에는 idx들을 string으로 저장하자
	public static void solve(int idx, ArrayList<Integer> ar) {
		// N이랑 idx같아지면 이제 
		// line에 저장된 idx따라서 저장
		if(idx == N) {
			// 두개의 크기가 같으면 
			// arr의 size를 저장해놓고 hs에 저장
			if(M == ar.size()) {
				String word = "";
				for(int i = 0;i<M;i++) {
					word += Integer.toString(arr[ar.get(i)])+" ";
				}
				int tmp = hs.size();
				hs.add(word);
				if(hs.size() != tmp) {
					System.out.println(word);
				}
			}
			return;
		}
		if(ar.size()>M) {
			return;
		}

		
		
		ar.add(idx);
		solve(idx, ar);
		ar.remove(ar.size()-1);
		solve(idx+1,ar);
		return;
	}

}