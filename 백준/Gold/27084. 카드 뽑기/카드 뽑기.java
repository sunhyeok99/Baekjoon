import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> table = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (!table.containsKey(arr[i])) {
                table.put(arr[i], 1);
            } else {
                table.put(arr[i], table.get(arr[i]) + 1);
            }
        }

        long answer = 1;
        for (int value : table.values()) {
            answer *= (value + 1);
            answer %= (long) (Math.pow(10, 9) + 7);
        }

        answer = (answer - 1) % (long) (Math.pow(10, 9) + 7);
        System.out.println(answer);
    }
}