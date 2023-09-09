import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N;
	static ArrayList<Integer> arr; // 처음 숫자 담을 공간

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new ArrayList<>();
		for(int i =0;i<N;i++) {
			arr.add(sc.nextInt());
		}

		Stack<Integer> st = new Stack<>(); // 여기에 저장해서 나오는 숫자가 다르면 false
		boolean flag = false;
		int index = 1; // 비교해야할 수
		while(true) {
			int tmp;
			if(arr.size() !=0) {
				tmp = arr.get(0);
				arr.remove(0);
			}
			else {
				tmp = st.pop();
			}
			// tmp 설정 끝
			if(index == tmp) {
				index++;
				while(true) {
					
					if(st.size()!=0 && st.peek() == index) {
						st.pop();
						index++;
					}
					else {
						break;
					}
				}
			}
			else if(st.size()==0 || st.peek()>tmp) {
				st.push(tmp);
			}
			else {
				break;
			}		

			if(index==N+1) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("Nice");
		}
		else {
			System.out.println("Sad");
		}


	}


}
