
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer>[] adjList;
	static int answer;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();
		visited = new boolean[V + 1];

		adjList = new LinkedList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new LinkedList();
		}

		for (int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		answer = 0;
		visited[1] = true;
		dfs(1);

		System.out.println(answer);

	}

	private static void dfs(int i) {
		for (int c : adjList[i]) {
			if (!visited[c]) {
				visited[c] = true;
				answer++;
				dfs(c);
			}
		}

	}

}
