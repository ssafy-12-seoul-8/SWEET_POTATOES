import java.io.*;
import java.util.*;

public class Solution {
	
	static final int cases = 10;
	static Queue<int[]> queue = new LinkedList<>();
	
	static Map<Integer, List<Integer>> graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= cases; t++) {
			graph = new HashMap<>();
			visited = new boolean[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph.putIfAbsent(from, new ArrayList<>());
				graph.get(from)
					.add(to);
			}
			
			System.out.println("#" + t + " " + bfs(start));
		}
	}
	
	static int bfs(int start) {
		visited[start] = true;
		int last = 0;
		int max = 0;
		
		queue.add(new int[] { start, 0 });
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int index = current[0];
			int distance = current[1];
			
			if (!graph.containsKey(index)) {
				continue;
			}
			
			for (int child : graph.get(index)) {
				if (visited[child]) {
					continue;
				}
				
				visited[child] = true;
				
				if (last == distance + 1) {
					max = Math.max(max, child);
				}
				
				if (last < distance + 1) {
					last = distance + 1;
					max = child;
				}
				
				queue.add(new int[] { child, distance + 1 });
			}
		}
		
		return max;
	}

}
