import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, List<Integer>> graph = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			graph.putIfAbsent(first, new ArrayList<>());
			graph.putIfAbsent(second, new ArrayList<>());
			graph.get(first)
				.add(second);
			graph.get(second)
				.add(first);
		}
		
		for (int key : graph.keySet()) {
			graph.get(key).sort(Integer::compare);
		}
		
		StringBuilder sb = new StringBuilder();
		
		dfs(sb, graph, new boolean[1001], v);
		sb.append(System.lineSeparator());
		bfs(sb, graph, new boolean[1001], v);
		System.out.println(sb);
	}
	
	static void bfs(StringBuilder sb, Map<Integer, List<Integer>> graph, boolean[] visited, int node) {
		Queue<Integer> queue = new LinkedList<>();
		visited[node] = true;
		
		queue.add(node);
		
		while (!queue.isEmpty()) {
			int next = queue.poll();
			
			sb.append(next)
				.append(" ");
			
			if (!graph.containsKey(next)) {
				continue;
			}
			
			for (int child : graph.get(next)) {
				if (visited[child]) {
					continue;
				}
				
				visited[child] = true;
				
				queue.add(child);
			}
		}
	}
	
	static void dfs(StringBuilder sb, Map<Integer, List<Integer>> graph, boolean[] visited, int node) {
		if (visited[node]) {
			return;
		}
		
		sb.append(node)
			.append(" ");
		
		visited[node] = true;
		
		if (!graph.containsKey(node)) {
			return;
		}
		
		for (int child : graph.get(node)) {
			dfs(sb, graph, visited, child);
		}
	}
	
}
