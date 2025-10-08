import java.util.*;

class Solution {
    List<Integer> leaves;
    Map<Integer, List<Integer>> graph;
    Map<Integer, int[]> nextChild;
    Map<Integer, List<Integer>> orders;
    int totalRequired;
    
    public int[] solution(int[][] edges, int[] target) {
        graph = new HashMap<>();
        leaves = new ArrayList<>();
        nextChild = new HashMap<>();
        orders = new HashMap<>();
        totalRequired = 0;
        
        for (int i = 0; i < target.length; i++) {
            if (target[i] != 0) {
                leaves.add(i);
            }
        }
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from)
                .add(to);
        }
                
        for (Integer node : graph.keySet()) {
            List<Integer> children = graph.get(node);
            
            Collections.sort(children);
            nextChild.put(node, new int[] { 0, children.get(0) });
        }
        
        for (int i = 1; i <= target.length; i++) {
            if (graph.containsKey(i)) {
                continue;
            }
            
            orders.put(i - 1, new ArrayList<>());
        }
        
        int order = 0;
        
        while (!allPossible(target) && totalRequired != -1) {
            dfs(1, order++);
        }
        
        if (totalRequired == -1) {
            return new int[] { -1 };
        }
        
        int[] result = new int[totalRequired];
        
        // System.out.println(orders);
        
        for (int key : orders.keySet()) {
            int value = target[key];
            List<Integer> curr = orders.get(key);
            int count = curr.size();
            int index = 0;
            
            // System.out.println("for: " + key + " / value: " + value + " / index: " + curr + " / count: " + count);

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
                
                // System.out.println("this index: " + curr.get(index - 1) + " / num: " + num);
                
                result[curr.get(index - 1)] = num;
                value -= num;
            }
        }
        
        return result;
    }
    
    boolean allPossible(int[] target) {
        int total = 0;
        
        for (int i = 0; i < leaves.size(); i++) {
            int current = orders.get(leaves.get(i)).size();
            int num = target[leaves.get(i)];
            
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
        
        int[] next = nextChild.get(parent);
        
        dfs(next[1], order);
        
        if (next[0] == graph.get(parent).size() - 1) {
            nextChild.put(parent, new int[] { 0, graph.get(parent).get(0) });
        } else {
            nextChild.put(parent, new int[] { next[0] + 1, graph.get(parent).get(next[0] + 1) });
        }
    }
}