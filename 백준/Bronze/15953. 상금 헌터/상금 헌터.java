import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            System.out.println(one(first)+two(second));
        }
    }

    public static int one(int first) {
        if(first==1)
            return 5000000;
        else if(2<=first && first<=3)
            return 3000000;
        else if(4<=first && first<=6)
            return 2000000;
        else if(7<=first && first<=10)
            return 500000;
        else if(11<=first && first<=15)
            return 300000;
        else if(16<=first && first<=21)
            return 100000;
        else
            return 0;
    }
    public static int two(int second) {
        if(second==1)
            return 5120000;
        else if(2<=second && second<=3)
            return 2560000;
        else if(4<=second && second<=7)
            return 1280000;
        else if(8<=second && second<=15)
            return 640000;
        else if(16<=second && second<=31)
            return 320000;
        else
            return 0;
    }
}
