import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 입력
        final int towerHeight = Integer.parseInt(br.readLine());
        // 2의 제곱
        System.out.print(BigInteger.valueOf(1).shiftLeft(towerHeight));
    }
}