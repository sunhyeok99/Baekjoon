import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            int b1 = scanner.nextInt();
            int b2 = scanner.nextInt();

            // 어느 숫자가 더 큰지 비교
            int min = a2 > b2 ? b2 : a2; // 작은 수
            int max = a2 > b2 ? a2 : b2; // 큰 수

            int res = 0; // 최소 공배수
            int x = 0; // 최대 공배수를 구할 때 전 값을 담아줄 변수
            for (int i = 0; i < 9999; i++) {
                x = max % min;
                max = min;
                if (x == 0) {
                    res = (a2 * b2) / min;
                    break;
                }
                min = x;

            }

            // 분수합 계산 분자
        int y = a1 * (res/a2) + b1 * (res/b2);

        min = y > res ? res : y; // 작은 수
        max = y > res ? y : res; // 큰 수

        // 약분시키기
        for (int i = 0; i < 9999; i++) {
            x = max % min;
            max = min;
            if (x == 0) {
                bw.write(y/min + " " + res/min);
                break;
            }
            min = x;

        }




        bw.flush();
        bw.close();
    }
}