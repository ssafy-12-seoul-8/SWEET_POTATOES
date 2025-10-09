import java.util.*;

class Solution {
    
    class Node {
        
        int to;
        int weight;
        
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        public String toString() {
            return "to: " + to + " / weight: " + weight;
        }
        
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        int[] intensity = new int[n + 1];
        Set<Integer> summitSet = new HashSet<>();
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node[1]));
        
        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int weight = path[2];
            Node toNode = new Node(to, weight);
            Node fromNode = new Node(from, weight);
            
            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(from)
                .add(toNode);
            graph.get(to)
                .add(fromNode);
        }
        
        for (int summit : summits) {
            summitSet.add(summit);
        }
        
        Arrays.fill(intensity, 10_000_000);
        
        for (int i = 0; i < gates.length; i++) {
            int gate = gates[i];
            intensity[gate] = 0;
            
            pq.add(new int[] { gate, 0 });
        }
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int from = current[0];
            int currentIntensity = current[1];
            
            if (currentIntensity > intensity[from] || !graph.containsKey(from)) {
                continue;
            }
            
            for (Node child: graph.get(from)) {
                int childIntensity = Math.max(child.weight, currentIntensity);
                
                if (childIntensity >= intensity[child.to]) {
                    continue;
                }
                
                intensity[child.to] = childIntensity;
                
                if (summitSet.contains(child.to)) {
                    continue;
                }
                
                pq.add(new int[] { child.to, childIntensity });
            }
        }
        
        int[] result = new int[2];
        result[1] = 10_000_001;
        
        for (int summit : summitSet) {
            int summitIntensity = intensity[summit];
            
            if (summitIntensity > result[1]) {
                continue;
            }
            
            result[0] = summitIntensity == result[1] ? Math.min(result[0], summit) : summit;
            result[1] = summitIntensity;
        }
        
        return result;
    }
}