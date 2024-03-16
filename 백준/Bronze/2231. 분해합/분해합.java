import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();
        
        int M = 0; //결과 값을 저장하는 함수[생성자가 없으면 0을 출력하기 때문에 초기값 0]
        
        for(int i = 1; i <= N; i++) {
            int number = i; // i값
            int res = 0; //각 자리수를 더한 값을 저장하는 변수
            
            while(number > 0){ // 해당 값이 0보다 작아질때까지 반복
                res += number % 10; // 자리수를 10씩 분해해서 해당 자리수의 모든 값을 더하여(누적) res에 저장
                number /= 10; //현재 반복을 돌고 있는 number의 값을 10씩 분해하여 계속 반복함.
            }

            if(res + i == N){ //만약 현재 i(즉 i마다 반복문 시작했을 때의 초기 number)값이랑 해당 자리수를 누적더한 값과 같을때
                M = i; // 생성자라는 뜻이니 M에 i를 넣고
                break; //반복문을 마친다.(가장 작은 생성자를 출력하니까)
            }
        }
        bw.write(M + "\n");
        bw.flush();
        bw.close();
    }
}