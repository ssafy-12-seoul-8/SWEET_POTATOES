import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int N, int[][] edges) {
    	
    	List<Integer>[] adjList = new ArrayList[N + 1];
    	for (int i = 1; i <= N; i++)
    		adjList[i] = new ArrayList<>();
    	
    	for (int[] edge : edges) {
    		int a = edge[0];
    		int b = edge[1];
    		adjList[a].add(b);
    		adjList[b].add(a);
    	}
    	
    	int[] visited = new int[N + 1];
    	for (int i = 1; i <= N; i++)
    		visited[i] = -1;
    	visited[1] = 0;
    	
    	Queue<Integer> bfs = new LinkedList<>();
    	bfs.add(1);
    	
    	while (!bfs.isEmpty()) {
    		
    		int now = bfs.poll();
    		
    		for (int next : adjList[now]) {
    			
    			if (visited[next] == -1) {
    				
    				visited[next] = visited[now] + 1;
    				bfs.add(next);
    			}
    		}
    	}
    	
        int maxDistance = 0;
        for (int i = 1; i <= N; i++)
            maxDistance = Math.max(maxDistance, visited[i]);

        int cnt = 0;
        for (int i = 1; i <= N; i++)
            if (visited[i] == maxDistance)
                cnt++;
    	
    	return cnt;
    }
}