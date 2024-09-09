import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		
		for(int tc=1 ; tc<=T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			String ve = br.readLine();
			StringTokenizer st1 = new StringTokenizer(ve);
			int V = Integer.parseInt(st1.nextToken());
			int E = Integer.parseInt(st1.nextToken());
			
			List<Integer>[] adjList = new LinkedList[V+1];
			int[] degree = new int[V+1];
			
			for(int i=1 ; i<V+1 ; i++) {
				adjList[i] = new LinkedList();
			}
			
			String edges = br.readLine();
			StringTokenizer st = new StringTokenizer(edges);
			
			for(int i=0 ; i<E ; i++) {
				int currV = Integer.parseInt(st.nextToken());
				int nextV = Integer.parseInt(st.nextToken());
				adjList[currV].add(nextV);
				degree[nextV]++;
			}
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=1 ; i<V+1 ; i++) {
				if(degree[i]==0) {
					queue.add(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				sb.append(curr).append(" ");
				
				for(int i : adjList[curr]) {
					degree[i]--;
					
					if(degree[i]==0) {
						queue.add(i);
					}
				}
			}
			sb.append("\n");
			
			
		} // tc
		String ans = sb.toString();
		System.out.println(ans);
		br.close();
		
	} // main

}
