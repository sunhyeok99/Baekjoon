import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=100;i++) {
			int val = (int)Math.pow(i,2);
			if(val<=N && val>=M) list.add(val);
			if(val>N) break;
		}
		
		if(list.size()==0) 
			System.out.println(-1);
		else {
			int sum = 0;
			for(int i=0;i<list.size();i++)
				sum += list.get(i);
			System.out.println(sum);
			System.out.println(list.get(0));
		}
	}

}