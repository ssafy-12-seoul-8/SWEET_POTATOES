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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		Map<Integer, List<Edge>> graph = new HashMap<>();
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.putIfAbsent(from, new ArrayList<>());
			graph.get(from)
					.add(new Edge(to, weight));
		}
		
		int[] distances = new int[v + 1];
		
		Arrays.fill(distances, Integer.MAX_VALUE);
		
		distances[start] = 0;
		Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
		
		pq.add(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			
			if (!graph.containsKey(current.to)) {
				continue;
			}
			
			for (Edge edge : graph.get(current.to)) {
				int nextWeight = current.weight + edge.weight;
				
				if (distances[edge.to] > nextWeight) {
					distances[edge.to] = nextWeight;
					
					pq.add(new Edge(edge.to, nextWeight));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= v; i++) {
			sb.append(distances[i] == Integer.MAX_VALUE ? "INF" : distances[i])
					.append("\n");
		}
		
		System.out.println(sb);
	}
	
}
