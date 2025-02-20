import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            // pow한다음에 마지막자리
            int a = sc.nextInt();
            int b = sc.nextInt();
            int data = 1;
            for(int j=0; j<b; j++) {
                data *= a;
                data %= 10;
            }
            if(data == 0){
                data = 10;
            }
            System.out.println(data);
        }







    }

}