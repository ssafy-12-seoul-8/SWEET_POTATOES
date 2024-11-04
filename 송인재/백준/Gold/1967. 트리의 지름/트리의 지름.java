import java.util.*;
import java.io.*;

public class Main {
	
	static class Edge {
		int to;
		int weight;
		
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int n, max;
	static List<Edge>[] tree;
	static boolean[] hasChild;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		hasChild = new boolean[n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<Edge>();
		}
		
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			hasChild[from] = true;
			
			tree[from].add(new Edge(to, weight));
			tree[to].add(new Edge(from, weight));
		}
		
		for (int i = 1; i <= n; i++) {
			if (hasChild[i]) {
				continue;
			}

			visited = new boolean[n + 1];
			
			dfs(i, 0);
		}
		
		System.out.println(max);
	}
	
	static void dfs(int current, int sum) {
		visited[current] = true;
		max = Math.max(max, sum);
		
		for (Edge edge : tree[current]) {
			if (visited[edge.to]) {
				continue;
			}
			
			dfs(edge.to, sum + edge.weight);
		}
	}
	
}
