import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] degree = new int[n];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] takenAt = new int[n];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken()) - 1;
			int course = Integer.parseInt(st.nextToken()) - 1;
			
			graph.putIfAbsent(pre, new ArrayList<>());
			graph.get(pre)
				.add(course);
			degree[course]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			takenAt[i]++;
			
			if (degree[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			if (!graph.containsKey(curr)) {
				continue;
			}
			
			for (int child : graph.get(curr)) {
				degree[child]--;
				takenAt[child] = takenAt[curr] + 1;
				
				if (degree[child] == 0) {
					queue.add(child);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			sb.append(takenAt[i] + " ");
		}
		
		System.out.println(sb);
	}

}
