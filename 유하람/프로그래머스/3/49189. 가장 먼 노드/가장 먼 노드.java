import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<Integer>[] adjList = new ArrayList[n+1];
        for(int i=1 ; i<=n ; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] e : edge){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        int[] degree = new int[n+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            for(int c : adjList[curr]){
                if(visited[c]) continue;
                queue.add(c);
                visited[c] = true;
                degree[c] = degree[curr]+1;
            }
        }
        
        int max = 0;
        int cnt = 0;
        
        System.out.println(Arrays.toString(degree));
        
        for(int i : degree){
            if(i>max){
                max = i;
                cnt = 1;
                continue;
            }else if(i==max){
                cnt++;
            }
        }
        
        return cnt;
    }
}