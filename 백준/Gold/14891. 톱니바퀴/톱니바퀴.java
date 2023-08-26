import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList[] q1;
	//14891
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		q1 = new ArrayList[4];
		for (int i = 0; i < 4; i++) {
		    q1[i] = new ArrayList<Integer>();
		}
		String tmp= sc.next();
		for(int j=0;j<8;j++) {
			q1[0].add(Integer.parseInt(tmp.substring(j,j+1)));
		}
		tmp = sc.next();
		for(int j=0;j<8;j++) {
			q1[1].add(Integer.parseInt(tmp.substring(j,j+1)));
		}
		tmp = sc.next();
		for(int j=0;j<8;j++) {
			q1[2].add(Integer.parseInt(tmp.substring(j,j+1)));
		}
		tmp = sc.next();
		for(int j=0;j<8;j++) {
			q1[3].add(Integer.parseInt(tmp.substring(j,j+1)));
		}

		int K = sc.nextInt();
		int[][] arr = new int[K][2];
		for(int i=0;i<K;i++) {
			for(int j=0;j<2;j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for(int i=0;i<K;i++) {			
				if(arr[i][0]==1) {
					right(0,arr[i][1]);
				}
				else if(arr[i][0]==2) {
					left(1,arr[i][1]);
					turn(1,arr[i][1]*(-1));
					right(1,arr[i][1]);
				}
				else if(arr[i][0]==3) {
					left(2,arr[i][1]);
					turn(2,arr[i][1]*(-1));
					right(2,arr[i][1]);
				}
				else {
					left(3,arr[i][1]);
				}
//				for(int k=0;k<4;k++) {
//					for(int j=0;j<8;j++) {
//						System.out.print(q1[k].get(j));
//					}
//					System.out.println();
//				}
		}
		int score = 0;
		if(q1[0].get(0).equals(1)) score+=1;
		if(q1[1].get(0).equals(1)) {
			score+=2;
		}
		if(q1[2].get(0).equals(1)) {
			score+=4;
		}
		if(q1[3].get(0).equals(1)) {
			score+=8;
		}
		
		
		System.out.println(score);



	}
	public static void right(int num,int rot) {		
		if(num<3) {
		if(q1[num].get(2)!=q1[num+1].get(6)){
			right(num+1,rot*-1);
			}
		}
		turn(num , rot);		
	}
	public static void left(int num,int rot) {
		if(num>0) {
		if(q1[num].get(6)!=q1[num-1].get(2)){
			left(num-1,rot*-1);
			}
		}
		turn(num,rot);
		
	}
	public static void turn(int num,int rot) {
		if(rot==1) {
			q1[num].add(0,q1[num].get(7));
			q1[num].remove(8);
		}
		else {
			q1[num].add(q1[num].get(0));
			q1[num].remove(0);
		}
	}
}
