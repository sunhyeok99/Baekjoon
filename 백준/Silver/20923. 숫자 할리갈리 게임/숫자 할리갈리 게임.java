import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {	
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 카드수
		M = sc.nextInt(); // 게임 수
		
		Deque<Integer> d1 = new ArrayDeque<>();
		Deque<Integer> d2 = new ArrayDeque<>();
		// 각각 d1이 도도 d2가 수연
		for(int i = 0;i<N;i++) {
			d1.add(sc.nextInt());
			d2.add(sc.nextInt());
		}
		// 입력 끝
		
		// 각각 서로 게임을 할건데 g1은 도도앞에있는 카드 , g2는 수연앞에 있는 카드 
		Deque<Integer> g1 = new ArrayDeque<>();
		Deque<Integer> g2 = new ArrayDeque<>();
		// deque사용할거임
		int tmp = 0;
		boolean winner = false;
		while(true) {
    		
    		// 도도가 카드를 놓는다.
    		tmp = d1.pollLast();
    		g1.addLast(tmp);
    		
    		if(d1.isEmpty()) {
    			winner = true;		// 수연 승리
    			break;
    		}
    		
    		// 도도가 이겼을 경우
    		if(tmp == 5) {
    			while(!g2.isEmpty()) {
    				d1.addFirst(g2.pollFirst());
    			}
    			while(!g1.isEmpty()) {
    				d1.addFirst(g1.pollFirst());
    			}
    		}
    		
    		// 수연이 이겼을 경우
    		if(!g1.isEmpty() && !g2.isEmpty() && g1.peekLast() + g2.peekLast() == 5) {
    			while(!g1.isEmpty()) {
    				d2.addFirst(g1.pollFirst());
    			}
    			while(!g2.isEmpty()) {
    				d2.addFirst(g2.pollFirst());
    			}
    		}
			M--;
    		if(M == 0) break;
    		
    		// 수연이 카드를 놓는다.
    		tmp = d2.pollLast();
    		g2.addLast(tmp);
    		
    		if(d2.isEmpty()) {
    			winner = false;		// 도도 승리
    			break;
    		}
    		
    		// 도도가 이겼을 경우
    		if(tmp == 5) {
    			while(!g2.isEmpty()) {
    				d1.addFirst(g2.pollFirst());
    			}
    			while(!g1.isEmpty()) {
    				d1.addFirst(g1.pollFirst());
    			}
    		}
    		
    		// 수연이 이겼을 경우
    		if(!g1.isEmpty() && !g2.isEmpty() && g1.peekLast() + g2.peekLast() == 5) {
    			while(!g1.isEmpty()) {
    				d2.addFirst(g1.pollFirst());
    			}
    			while(!g2.isEmpty()) {
    				d2.addFirst(g2.pollFirst());
    			}
    		}
			M--;
    		if(M == 0) break;
    	}
    	
    	winner = d1.size() > d2.size() ? false : true;
    	
    	if(d1.size() == d2.size())
    		System.out.println("dosu");
    	else if(winner)
    		System.out.println("su");
    	else
    		System.out.println("do");
	}

		
	
}