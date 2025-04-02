import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arr[] = new int[4];
        for(int i=0; i<arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        scan.close();

        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == x) {
                System.out.println(i+1);
                count ++;
            }
        }

        if(count == 0) System.out.println(0);
    }
}
