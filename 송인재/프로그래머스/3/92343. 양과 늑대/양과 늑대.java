import java.util.*;

class Solution {
    
    int[] info;
    Map<Integer, List<Integer>> graph;
    Map<String, Boolean> bits;
    int max;
    int totalLambs;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        graph = new HashMap<>();
        bits = new HashMap<>();
        max = 0;
        totalLambs = 0;
        
        for (int inf : info) {
            if (inf == 0) {
                totalLambs++;
            }
        }
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from)
                .add(to);
        }
        
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        
        combination(0, new boolean[info.length], 1, 0, visited);
        
        return max;
    }
    
    void combination(int current, boolean[] possibles, int lambs, int wolves, boolean[] visited) {
        if (max == totalLambs) {
            return;
        }
        
        max = Math.max(max, lambs);    
        
        if (graph.containsKey(current)) {
            for (int child : graph.get(current)) {
                possibles[child] = true;
            }
        }
        
        for (int i = 0; i < possibles.length; i++) {
            if (!possibles[i]) {
                continue;
            }
            
            visited[i] = true;
            String bitKey = Arrays.toString(visited);
            
            bits.putIfAbsent(bitKey, false);
            
            if (bits.get(bitKey)) {
                visited[i] = false;
                
                continue;
            }
            
            bits.put(bitKey, true);
            
            int nextLambs = lambs;
            int nextWolves = wolves;
            
            if (info[i] == 0) {
                nextLambs++;
            } else {
                nextWolves++;
            }
            
            if (nextLambs <= nextWolves) {
                visited[i] = false;
                
                continue;
            }
            
            boolean[] nextPossibles = Arrays.copyOf(possibles, possibles.length);
            nextPossibles[i] = false;
            
            combination(i, nextPossibles, nextLambs, nextWolves, visited);
            
            visited[i] = false;
        }
    }
}