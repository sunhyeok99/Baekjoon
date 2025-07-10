import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M ;
	static HashSet<Integer> hs;
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// add 추가 , remove 제거, check x가 있으면 1 없으면 0
		// toggle 있으면 제거/ 없으면 추가, all 1~20으로 전환 , empty 모두 제거

		// hashset 쓰는게 좋을지도
		hs = new HashSet<>();
		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			calculate(s);
		}

		System.out.print(sb.toString());


	}

	public static void calculate(String s){
		if(s.equals("add")){
			int x = Integer.parseInt(st.nextToken());
				hs.add(x);
		}
		else if(s.equals("remove")){
			int x = Integer.parseInt(st.nextToken());
				hs.remove(x);
		}
		else if(s.equals("check")){
			int x = Integer.parseInt(st.nextToken());
			if(hs.contains(x)){
				sb.append(1);
			}
			else{
				sb.append(0);
			}
			sb.append("\n");
		}
		else if(s.equals("toggle")){
			int x = Integer.parseInt(st.nextToken());
			if(hs.contains(x)){
				hs.remove(x);
			}
			else{
				hs.add(x);
			}
		}
		else if(s.equals("all")){
			hs = new HashSet<>();
			for(int i = 1 ; i <= 20 ; i++){
				hs.add(i);
			}
		}
		else{
			hs.clear();
		}


	}

	private static StringBuffer getAppend() {
		return sb.append(1);
	}

}