import java.util.*;

class Solution {
    
    int[] info;
    Map<Integer, List<Integer>> graph;
    boolean[] states;
    int max;
    int totalLambs;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        graph = new HashMap<>();
        states = new boolean[1 << info.length];
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
        
        combination(0, new boolean[info.length], 1, 0, 1);
        
        return max;
    }
    
    void combination(int current, boolean[] possibles, int lambs, int wolves, int state) {
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
            
            int newState = state | 1 << i;
            
            if (states[newState]) {
                continue;
            }
            
            states[newState] = true;
            int nextLambs = lambs;
            int nextWolves = wolves;
            
            if (info[i] == 0) {
                nextLambs++;
            } else {
                nextWolves++;
            }
            
            if (nextLambs <= nextWolves) {
                continue;
            }
            
            boolean[] nextPossibles = Arrays.copyOf(possibles, possibles.length);
            nextPossibles[i] = false;
            
            combination(i, nextPossibles, nextLambs, nextWolves, newState);
        }
    }
}