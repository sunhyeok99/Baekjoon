import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력값 받아오기
        int N = Integer.parseInt(reader.readLine());
 
        int[] listQueuestack = new int[N];
        int[] currentList = new int[N];
 
        StringBuilder answer = new StringBuilder();
        // 1번 리스트 - 자료구조의 형태
        StringTokenizer input1 = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            listQueuestack[i] = Integer.parseInt(input1.nextToken());
        }
        // 2번 리스트 - 자료구조의 요소
        StringTokenizer input2 = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            currentList[i] = Integer.parseInt(input2.nextToken());
        }
 
        int M = Integer.parseInt(reader.readLine());
        int[] insertList = new int[M];
        // 3번 리스트 - 입력값 리스트
        StringTokenizer st3 = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; i++) {
            insertList[i] = Integer.parseInt(st3.nextToken());
        }
        // 큐 생성
        Deque<Integer> queue = new ArrayDeque<>();
        // 자료구조의 형태가 큐라면,
        for (int i = 0; i < N; i++) {
            if (listQueuestack[i] == 0) {
                queue.addFirst(currentList[i]); // 새로 만든 큐에 현재 요소를 담는다.
            }
        }
        for (int i = 0; i < M; i++) {
            queue.add(insertList[i]);
            answer.append((queue.pollFirst() + " "));
        }
 
        System.out.println(answer);
        reader.close();
    }
}