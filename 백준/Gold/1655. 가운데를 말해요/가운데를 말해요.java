import java.util.*;

public class Main {

    static int N;
    static PriorityQueue<Integer> high;
    static PriorityQueue<Integer> low;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        high = new PriorityQueue<>();
        low = new PriorityQueue<>(Comparator.reverseOrder());
      // 큐를 두개 써서 하나는 높은수를 오름차순, 하나는 낮은수를 내림차순으로 가지고 있는다.
        for(int i = 0; i < N; i++) {
            // 하나씩 넣으면서 만약 두개중 하나의 크기가 더 커진다면 옮기기 과정
            // 우선 low쪽이 같은 수라면 +1하고 low가 +1이라면 +1해준다음 하나 옮기기

            // 이 과정진행중 더 큰수가 만약 low에 있고 작은수가 high에 있다면 두개 바꿔줌
            int num = sc.nextInt();
            if(low.size() == high.size()){
                low.add(num);
            }
            // 어차피 high가 더 많을때는 없다.
            else{
                high.add(num);
            }

            // 두개 바꿀경우
            if(high.size()!= 0 && low.peek() > high.peek()){
                int tmp = low.poll();
                high.add(tmp);
                low.add(high.poll());
            }
            // 이 과정했을 떄 low에서 숫자하나 출력 == 가운데수
            sb.append(low.peek()+"\n");
        }

        System.out.println(sb.toString());

    }

}
