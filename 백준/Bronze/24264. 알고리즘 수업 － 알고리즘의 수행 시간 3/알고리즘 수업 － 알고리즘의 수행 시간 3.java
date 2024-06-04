import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에 입력의 크기 n(1 ≤ n ≤ 500,000)이 주어지는데
        //이거의 n*n을 했을때 int로는 overflow가 발생할 수 있다.
        long n = Long.parseLong(br.readLine()); //입력 크기 입력받음 => 이것이 수행 홧수
        br.close();
        System.out.println(n*n);
        System.out.println(2);
    }
}
