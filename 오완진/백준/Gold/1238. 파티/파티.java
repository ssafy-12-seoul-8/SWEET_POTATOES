import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, X, S, E, T;
	static List<int[]>[] adjList, adjListRvs;
	static int[] dist, distRvs;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N + 1];
		adjListRvs = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
			adjListRvs[i] = new ArrayList<>();
		}

		dist = new int[N + 1];
		distRvs = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
			distRvs[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			
			adjList[S].add(new int[] {E, T});
			adjListRvs[E].add(new int[] {S, T});
		}
		
		dijkstra(adjList, dist);
		dijkstra(adjListRvs, distRvs);
		
		int max = 0;
		for (int i = 1; i <= N; i++)
			max = Math.max(max, dist[i] + distRvs[i]);
		
		System.out.println(max);
	}
	
	static void dijkstra(List<int[]>[] arr, int[] dist) {
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		boolean[] visited = new boolean[N + 1];
		
		dist[X] = 0;
		
		pq.add(new int[] {X, 0});
		
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currNode = curr[0];
			int currDist = curr[1];
			
			if (visited[currNode]) continue;
			visited[currNode] = true;
			
			for (int[] next : arr[currNode]) {
				int nextNode = next[0];
				int nextDist = next[1];
				
				if (dist[nextNode] > currDist + nextDist) {
					dist[nextNode] = currDist + nextDist;
					pq.add(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
	}
}