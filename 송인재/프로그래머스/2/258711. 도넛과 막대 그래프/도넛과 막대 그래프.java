import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph;
    int[] enters;
    int[] exits;
    int max;
    int[] result;
    
    public int[] solution(int[][] edges) {
        graph = new HashMap<>();
        enters = new int[1_000_001];
        exits = new int[1_000_001];
        max = 0;
        result = new int[4];
        
        for (int i = 0; i < enters.length; i++) {
            enters[i] = -1;
        }
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from)
                .add(to);
            
            if (enters[to] < 0) {
                enters[to] = 0;
            }
            
            enters[to]++;
            exits[from]++;
            
            max = Math.max(max, Math.max(from, to));
        }

        result[0] = getCreator();
        int totalCount = exits[result[0]];
        
        for (int to : graph.get(result[0])) {
            enters[to]--;
        }
        
        for (int i = 1; i <= max; i++) {
            if (i == result[0]) {
                continue;
            }
            
            if (enters[i] == 2 && exits[i] == 2) {
                result[3]++;
            }
            
            if (exits[i] == 0 && enters[i] >= 0) {
                result[2]++;
            }
        }
        
        result[1] = totalCount - result[3] - result[2];
        
        return result;
    }
    
    int getCreator() {
        for (int i = 1; i <= max; i++) {
            if (enters[i] == -1 && exits[i] >= 2) {
                return i;
            }
        }
        
        return 0;
    }
}