import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        int[] s = {A,B,C};
        Arrays.sort(s);

        if(s[0] + s[1] > s[2]){
            System.out.println(A+B+C);
        }else {
            System.out.println((s[0]+s[1]) * 2 - 1);
        }

    }
}