import java.util.*;
import java.io.*;

public class Main {

	static List<int[]>[] adjList;
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정점의 개수 V
		int V = Integer.parseInt(br.readLine());

		// 연결 정보
		adjList = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();

		}

		for (int i = 1; i <= V; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int curr = Integer.parseInt(st.nextToken());

			while (true) {
				int next = Integer.parseInt(st.nextToken());

				if (next == -1)
					break;

				int price = Integer.parseInt(st.nextToken());

				adjList[curr].add(new int[] { next, price });
			}
		}

		answer = 0;
		visited = new boolean[V + 1];
		visited[1] = true;

		checkTree(1);

		System.out.println(answer);

	} // main

	private static int checkTree(int curr) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

		visited[curr] = true;

		for (int[] next : adjList[curr]) {

			if (visited[next[0]])
				continue;

			pq.add(next[1] + checkTree(next[0]));
		}

		int max = pq.isEmpty() ? 0 : pq.poll();
		int tmp = pq.isEmpty() ? 0 : pq.poll();

		answer = Math.max(answer, max + tmp);

		return max;
	}

} // Main class
