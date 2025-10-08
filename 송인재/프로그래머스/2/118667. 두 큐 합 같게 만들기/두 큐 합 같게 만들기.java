import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();
        long firstSum = 0;
        long secondSum = 0;
        long totalSum = 0;
        int maxCount = 0;
        int count = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            first.add(queue1[i]);
            second.add(queue2[i]);
            
            firstSum += queue1[i];
            secondSum += queue2[i];
        }
        
        totalSum = firstSum + secondSum;
        maxCount = 2 * (first.size() + second.size());
        
        if (totalSum % 2 == 1) {
            return -1;
        }
        
        while (count < maxCount && firstSum != secondSum) {
            count++;
            
            if (firstSum > secondSum) {
                int poll = first.poll();
                firstSum -= poll;
                secondSum += poll;
                
                second.add(poll);
            } else {
                int poll = second.poll();
                firstSum += poll;
                secondSum -= poll;
                
                first.add(poll);
            }
        }
        
        if (firstSum != secondSum) {
            return -1;
        }
        
        return count;
    }
}