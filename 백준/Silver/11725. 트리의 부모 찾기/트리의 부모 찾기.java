import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
		for (int i = 0; i < n; i++)
			ar.add(new ArrayList<>());

		// 그래프 입력
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			ar.get(a).add(b);
			ar.get(b).add(a);
		}

		boolean[] visited = new boolean[n]; // 방문 여부 확인용 배열
		int[] parentNode = new int[n]; // 부모 노드 저장 배열

		// BFS
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0] = true;
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int node : ar.get(v))
				if (!visited[node]) {
					visited[node] = true;
					queue.add(node);
					parentNode[node] = v; // 부모 노드 찾은 후 저장
				}
		}

		// 루트 노드를 제외한 나머지 노드의 부모 노드 출력
		for (int i = 1; i < n; i++)
			System.out.println(parentNode[i] + 1);
	}

}