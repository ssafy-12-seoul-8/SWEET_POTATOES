import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph;
    int[] enters;
    int[] exits;
    int max;
    int[] result;
    boolean[] visited;
    
    public int[] solution(int[][] edges) {
        graph = new HashMap<>();
        enters = new int[1_000_001];
        exits = new int[1_000_001];
        max = 0;
        result = new int[4];
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from)
                .add(to);
            
            enters[to]++;
            exits[from]++;
            
            max = Math.max(max, Math.max(from, to));
        }
        
        result[0] = getCreator();
        visited = new boolean[max + 1];
        
        for(int to : graph.get(result[0])) {
            enters[to]--;
            
            int type = dfs(to);
            
            result[type]++;
        }
        
        return result;
    }
    
    int getCreator() {
        for (int i = 1; i <= max; i++) {
            if (enters[i] == 0 && exits[i] >= 2) {
                return i;
            }
        }
        
        return 0;
    }
    
    int dfs(int curr) {
        if (enters[curr] == 2 && exits[curr] == 2) {
            return 3;
        }
        
        if (exits[curr] == 0) {
            return 2;
        }
        
        visited[curr] = true;
        
        for (int to : graph.get(curr)) {
            if (visited[to]) {
                continue;
            }
            
            return dfs(to);
        }
        
        return 1;
    }
}