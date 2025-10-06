import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Deque<Integer> dels = new ArrayDeque<>();
        Deque<Integer> pics = new ArrayDeque<>();
        long total = 0;
        
        for (int i = 0; i < deliveries.length; i++) {
            if (deliveries[i] != 0) {
                dels.push(i);
            }
            
            if (pickups[i] != 0) {
                pics.push(i);
            }
        }

        while (!dels.isEmpty() || !pics.isEmpty()) {
            int distance = 0;
            
            if (!dels.isEmpty()) {
                distance = Math.max(distance, getDeliveryDistance(dels, deliveries, cap));
            }
            
            if (!pics.isEmpty()) {
                distance = Math.max(distance, getPickupDistance(pics, pickups, cap));
            }
            
            total += distance * 2;
        }
        
        return total;
    }
    
    int getDeliveryDistance(Deque<Integer> dels, int[] deliveries, int left) {
        int distance = dels.peek() + 1;
        
        while (!dels.isEmpty() && left > 0) {
            if (deliveries[dels.peek()] <= left) {
                left -= deliveries[dels.pop()];
            } else {
                deliveries[dels.peek()] -= left;
                left = 0;
            }
        }
        
        return distance;
    }
    
    int getPickupDistance(Deque<Integer> pics, int[] pickups, int left) {
        int distance = pics.peek() + 1;
        
        while (!pics.isEmpty() && left > 0) {
            if (pickups[pics.peek()] <= left) {
                left -= pickups[pics.pop()];
            } else {
                pickups[pics.peek()] -= left;
                left = 0;
            }
        }
        
        return distance;
    }
}