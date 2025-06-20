import java.util.*;

public class Main {
	static int N, M ;
	static int[][] price;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		price = new int[10][2];
		price[0][0] = 0;
		price[1][0] = 1;
		price[2][0] = 2;
		price[3][0] = 3;
		price[4][0] = 4;
		price[5][0] = 5;
		price[6][0] = 6;
		price[7][0] = 7;
		price[8][0] = 8;
		price[9][0] = 9;

		price[0][1] = 1;
		price[1][1] = 10;
		price[2][1] = 100;
		price[3][1] = 1000;
		price[4][1] = 10000;
		price[5][1] = 100000;
		price[6][1] = 1000000;
		price[7][1] = 10000000;
		price[8][1] = 100000000;
		price[9][1] = 1000000000;

		String[] color = new String[10];
		color[0] = "black";
		color[1] = "brown";
		color[2] = "red";
		color[3] = "orange";
		color[4] = "yellow";
		color[5] = "green";
		color[6] = "blue";
		color[7] = "violet";
		color[8] = "grey";
		color[9] = "white";

		String first = sc.next();
		String second = sc.next();
		String third = sc.next();
		int a =  0;
		int b =  0;
		int c =  0;
		for(int i = 0 ; i < 10 ; i++){
			if(first.equals(color[i])){
				a = i;
			}
			if(second.equals(color[i])){
				b = i;
			}
			if(third.equals(color[i])){
				c = i;
			}
		}
		long ans = (long)(price[a][0] * 10L + price[b][0]) *(long)(price[c][1]);
		System.out.println(ans);
	}


}