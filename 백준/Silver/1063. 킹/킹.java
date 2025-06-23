import java.util.*;

public class Main {
	static int N, M ;
	static int stoneX, stoneY;
	static int[][] price;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		int cnt = sc.nextInt();
		// 좌표는 8에서 값을 뺴고, 알파벳은 순서대로 0~8
		M = a.substring(0,1).charAt(0)-65;
		N = 8 - Integer.parseInt(a.substring(1,2));
		stoneY = b.substring(0,1).charAt(0)-65;
		stoneX = 8 - Integer.parseInt(b.substring(1,2));
		for(int i = 0 ; i < cnt ;i++){
			String tmp = sc.next();
			move(tmp);
		}
		char ans1 = (char)(M + 'A');
		int ans2 = 8 - N;
		char ans3 = (char)(stoneY + 'A');
		int ans4 = 8 - stoneX;
		System.out.println(ans1+""+ans2);
		System.out.println(ans3+""+ans4);

	}
	public static void move(String word){
		if(word.equals("R")){
			if(M >6){
				return;
			}
			M++;
			// 돌이랑 같은지 확인
			if(check()){
				stoneY ++;
				if(stoneY == 8){
					stoneY--;
					M--;
				}
			}
		}
		else if(word.equals("L")){
			if(M < 1){
				return;
			}
			M --;
			if(check()){
				stoneY--;
				if(stoneY == -1){
					stoneY++;
					M++;
				}
			}
		}
		else if(word.equals("B")){
			if(N > 6){
				return;
			}
			N++;
			if(check()){
				stoneX ++;
				if(stoneX == 8){
					stoneX--;
					N--;
				}
			}
		}
		else if(word.equals("T")){
			if(N < 1){
				return;
			}
			N--;
			if(check()){
				stoneX --;
				if(stoneX == -1){
					stoneX++;
					N++;
				}
			}
		}
		else if(word.equals("RT")){
			if(M> 6 || N<1){
				return;
			}
			M++;
			N--;
			if(check()){
				stoneY ++;
				stoneX --;
				if(stoneX == -1 || stoneY == 8){
					stoneY--;
					stoneX++;
					M--;
					N++;
				}
			}
		}
		else if(word.equals("LT")){
			if(M <1 || N<1){
				return;
			}
			M--;
			N--;
			if(check()){
				stoneY --;
				stoneX --;
				if(stoneX == -1 || stoneY == -1){
					stoneY++;
					stoneX++;
					M++;
					N++;
				}
			}
		}
		else if(word.equals("RB")){
			if(M > 6 || N > 6){
				return;
			}
			M ++;
			N ++;
			if(check()){
				stoneY ++;
				stoneX ++;
				if(stoneX == 8 || stoneY == 8){
					stoneY--;
					stoneX--;
					M --;
					N --;
				}
			}
		}
		else {
			if(M < 1 || N > 6){
				return;
			}
			M--;
			N++;
			if(check()){
				stoneY --;
				stoneX ++;
				if(stoneX == 8 || stoneY == -1){
					stoneY++;
					stoneX--;
					N--;
					M++;
				}
			}
		}

	}
	public static boolean check(){
		if(N == stoneX && M == stoneY){
			return true;
		}
		return false;
	}

}