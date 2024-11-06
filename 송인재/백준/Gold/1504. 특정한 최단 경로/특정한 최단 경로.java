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
	
	static Map<Integer, List<Edge>> graph = new HashMap<>();
	static Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
	static boolean[] visited;
	static int[] distances;
	static int INF = 800_000 * 2 + 1_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		distances = new int[n + 1];
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.putIfAbsent(from, new ArrayList<>());
			graph.putIfAbsent(to, new ArrayList<>());
			graph.get(from)
				.add(new Edge(to, weight));
			graph.get(to)
				.add(new Edge(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		dijkstra(1);
		
		int startToV1 = distances[v1];
		int startToV2 = distances[v2];
		
		dijkstra(v1);
		
		int v1ToV2 = distances[v2];
		int v1ToEnd = distances[n];
		
		dijkstra(v2);
		
		int v2ToEnd = distances[n];
		
		int min = Math.min(startToV1 + v1ToV2 + v2ToEnd, startToV2 + v1ToV2 + v1ToEnd);
		
		if (min >= INF) {
			min = -1;
		}
		
		System.out.println(min);
	}
	
	static void dijkstra(int from) {
		Arrays.fill(distances, INF);
		Arrays.fill(visited, false);
		pq.add(new Edge(from, 0));
		
		distances[from] = 0;
		
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if (!graph.containsKey(curr.to)) {
				continue;
			}
			
			for (Edge child : graph.get(curr.to)) {
				int nextWeight = curr.weight + child.weight;
				
				if (distances[child.to] > nextWeight) {
					distances[child.to] = nextWeight;
					
					pq.add(new Edge(child.to, nextWeight));
				}
			}
		}
	}
	
}
