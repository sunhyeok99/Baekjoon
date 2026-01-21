import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int ans;
	static int[] arr;
	static int[][] map;
	static boolean[] visited;
	static boolean[][] flag;
	static int[] dp;
	static int[] selected;
	static ArrayList<Integer> ar[];
	static int ansX, ansY;
	static Queue<Integer> q;
	static int tmp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// <를 찾으면 > 까진 그대로
		// 일반 문자열은 공백을 기준으로 뒤집기

		// 어차피 입력은 공백으로 받아진다.
		String s = sc.nextLine();
		// <> 안에는 큨
		// 단어는 스택으로

		Queue<String> q = new LinkedList<>();
		Stack<String> st = new Stack<>();
		for(int i = 0 ; i < s.length(); i++){
			String tmp = s.substring(i,i+1);
			if(tmp.equals("<")){
				// <가 나오면 st에 있는거 먼저 비우고 > 가 나올때까지 입력
				while(!st.isEmpty()){
					System.out.print(st.pop());
				}
				// > 가 나올때까지 q에 저장
				System.out.print("<");
				while(true){
					i++;
					tmp = s.substring(i,i+1);
					if(tmp.equals(">")){
						while(!q.isEmpty()){
							System.out.print(q.poll());
						}
						System.out.print(">");
						break;
					}
					q.add(tmp);
				}
			}
			else if(tmp.equals(" ")){
				// 공백일 경우
				while(!st.isEmpty()){
					System.out.print(st.pop());
				}
				System.out.print(" ");
			}
			else{
				st.push(tmp);
			}


		}
		while(!st.isEmpty()){
			System.out.print(st.pop());
		}

		System.out.println();

	}

	public static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
	public static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};



}