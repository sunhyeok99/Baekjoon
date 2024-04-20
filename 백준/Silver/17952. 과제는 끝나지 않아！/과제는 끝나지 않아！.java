import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Task {
		int score, time;

		public Task(int score, int time) {
			this.score = score;
			this.time = time;
		}

		public void sendTime() {
			this.time--;
		}
	}

	static HashMap<String, Integer> book_map = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int answer = 0;
		Stack<Task> task_stack = new Stack<>();
		StringTokenizer stringTokenizer;
		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(reader.readLine());
			if (Integer.parseInt(stringTokenizer.nextToken()) == 1)
				task_stack.add(new Task(Integer.parseInt(stringTokenizer.nextToken()),
						Integer.parseInt(stringTokenizer.nextToken())));

			if (!task_stack.empty()) {
				task_stack.peek().sendTime();

				if (task_stack.peek().time == 0)
					answer += task_stack.pop().score;
			}

		}

		System.out.println(answer);
	}
}