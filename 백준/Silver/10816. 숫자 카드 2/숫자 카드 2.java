import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(!hm.containsKey(a)) {
				hm.put(a, 1);
			}
			else {
				hm.put(a, hm.get(a)+1 );
			}
		}
		// 있으면 +! , 없으면 추가해서 쭉 넣음
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i = 0;i<M;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(hm.get(tmp) == null) {
				 sb.append(0).append(" ");
			}
			else {
				sb.append(hm.get(tmp)+" ");
			}
		}
		System.out.println(sb);

		
		
		
		
	}

}