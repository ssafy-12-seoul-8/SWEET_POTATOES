import java.io.*;
import java.util.*;

public class Solution {
	
	static final Map<Integer, List<Integer>> graph = new HashMap<>();
	static final Deque<Integer> stack = new ArrayDeque<>();
	static final int cases = 10;
	
	static int v, e;
	static int[] degree;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= cases; t++) {
			graph.clear();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			degree = new int[v];
			visited = new boolean[v];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < e; i++) {
				int parent = Integer.parseInt(st.nextToken()) - 1;
				int child = Integer.parseInt(st.nextToken()) - 1;
				
				graph.putIfAbsent(parent, new ArrayList<>());
				graph.get(parent)
					.add(child);
				degree[child]++;
			}
			
			for (int i = 0; i < v; i++) {
				if (degree[i] == 0) {
					dfs(i);
				}
			}
			
			StringBuilder sb = new StringBuilder("#")
					.append(t)
					.append(" ");
			
			while (!stack.isEmpty()) {
				sb.append((stack.pop() + 1) + " ");
			}
			
			System.out.println(sb);
		}
	}
	
	static void dfs(int parent) {
		visited[parent] = true;
		
		if (graph.containsKey(parent)) {
			for (int child : graph.get(parent)) {
				if (visited[child]) {
					continue;
				}
				
				dfs(child);
			}
		}
		
		stack.push(parent);
	}
	
}
