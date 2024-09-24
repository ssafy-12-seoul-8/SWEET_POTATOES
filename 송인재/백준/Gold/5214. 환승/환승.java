import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			List<Integer> nodes = new ArrayList<>();
			int hyperTube = n + i;
			
			graph.put(hyperTube, nodes);
			
			for (int j = 0; j < k; j++) {
				int station = Integer.parseInt(st.nextToken());
				
				nodes.add(station);
				graph.putIfAbsent(station, new ArrayList<>());
				graph.get(station)
					.add(hyperTube);
			}
		}
		
		boolean[] visited = new boolean[n + m + 1];
		int[] shortest = new int[n + 1];
		
		Arrays.fill(shortest, Integer.MAX_VALUE);
		
		Queue<int[]> queue = new LinkedList<>();
		visited[1] = true;
		shortest[1] = 1;
		
		queue.add(new int[] { 1, 1 });
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int number = current[0];
			int distance = current[1];
			
			if (!graph.containsKey(number)) {
				continue;
			}
			
			for (int child : graph.get(number)) {
				if (visited[child]) {
					continue;
				}
				
				visited[child] = true;
				int nextDistance = distance;
				
				if (child <= n && shortest[child] > distance + 1) {
					shortest[child] = distance + 1;
					nextDistance = distance + 1;
				}
				
				queue.add(new int[] { child, nextDistance });
			}
		}
		
		if (shortest[n] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(shortest[n]);
		}
	}

}
