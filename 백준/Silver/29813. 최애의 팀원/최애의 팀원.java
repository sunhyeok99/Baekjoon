

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  =sc.nextInt();
		String[] arr = new String[N+1]; // 알파벳저장
		int[] num = new int[N+1]; // index 저장
		// 나는 index만 저장해서 쭉 돌거야

		for(int i =1;i<=N;i++) {
			arr[i] = sc.next();
			num[i] = sc.nextInt();
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i =1;i<=N;i++) {
			q.add(i);
		}
		// 입력 끝
		// index만 돌다가 중간에 찾으면 둘은 flag로 true처리 해줌
		int ans = -1;
		int index = 1;
		while(true) {
			index = q.poll(); // 지금 뺴는 사람은 현재 이제 파트너를 고를 사람 
			if(q.size()==0) {
				ans = index;
				break;
			}
			for(int i =0;i<num[index]-1;i++) {
				q.add(q.poll()); // index가 가리키는
				// 숫자만큼 큐에서 뺴고 큐에 넣음
			}
			// 다 돌았으면 현재 꼭대기에 있는게 1번쨰의 파트너
//			System.out.println(q.peek()+" "+q.size());
			index = q.peek();
			q.poll(); // 파트너를 빼주고 -- 이 다음사람의 파트너를 이제 구해야함
		}
		System.out.println(arr[ans]);

	}

}
