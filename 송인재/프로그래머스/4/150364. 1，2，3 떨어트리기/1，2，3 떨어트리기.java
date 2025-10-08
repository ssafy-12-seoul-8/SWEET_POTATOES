import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph;
    Map<Integer, Integer> nextChild;
    Map<Integer, List<Integer>> orders;
    int totalRequired;
    
    public int[] solution(int[][] edges, int[] target) {
        graph = new HashMap<>();
        nextChild = new HashMap<>();
        orders = new HashMap<>();
        totalRequired = 0;
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
                nextChild.put(from, 0);
            }
            
            graph.get(from)
                .add(to);
        }
                
        for (Integer node : graph.keySet()) {
            Collections.sort(graph.get(node));
        }
        
        for (int i = 1; i <= target.length; i++) {
            if (graph.containsKey(i)) {
                continue;
            }
            
            orders.put(i - 1, new ArrayList<>());
        }
        
        int order = 0;
        
        while (!allPossible(target)) {
            if (totalRequired == -1) {
                return new int[] { -1 };
            }
            
            dfs(1, order++);
        }
        
        int[] result = new int[totalRequired];
        
        for (int key : orders.keySet()) {
            int value = target[key];
            List<Integer> curr = orders.get(key);
            int count = curr.size();
            int index = 0;

            while (index < count) {
                index++;
                
                int num = 0;
                
                if (value - 1 <= (count - index) * 3) {
                    num = 1;
                } else if (value - 2 <= (count - index) * 3) {
                    num = 2;
                } else {
                    num = 3;
                }
                
                result[curr.get(index - 1)] = num;
                value -= num;
            }
        }
        
        return result;
    }
    
    boolean allPossible(int[] target) {
        int total = 0;
        
        for (int node : orders.keySet()) {
            int current = orders.get(node).size();
            int num = target[node];
            
            if (current > num) {
                totalRequired = -1;
                
                return false;
            }
            
            if (current * 3 < num) {
                return false;
            }
            
            total += current;
        }
        
        totalRequired = total;
        
        return true;
    }
    
    void dfs(int parent, int order) {
        if (!graph.containsKey(parent)) {
            orders.get(parent - 1)
                .add(order);
            
            return;
        }
        
        int nextIndex = nextChild.get(parent);
        int next = graph.get(parent)
            .get(nextIndex);
        
        dfs(next, order);
        
        int nextSwitched = nextIndex == graph.get(parent).size() - 1 ? 0 : nextIndex + 1;
        
        nextChild.put(parent, nextSwitched);
    }
}