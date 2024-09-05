import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        
        for (int value : scoville) pq.offer(value);
        
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first + second * 2);
            count++;
        }
        
        if (pq.peek() >= K) return count;
        
        return -1;
    }
}