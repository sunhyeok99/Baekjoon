import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 1; i<=N; i++){
            if(i/100 == 0)
                count++;

            else if(i/1000 == 0){
                int hund = i/100;
                int ten = (i%100)/10;
                int one = i%10;

                if(hund-ten == ten - one)
                    count++;
            }
        }

        System.out.println(count);
    }
}