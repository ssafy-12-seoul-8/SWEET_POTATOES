class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 1_000_000_000;
        
        for (int time : times) {
            right = Math.max(right, time);
        }
        
        right *= n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (isPossible(mid, times, n)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public boolean isPossible(long minute, int[] times, int n) {
        long sum = 0;
        
        for (int time : times) {
            sum += minute / time;
            
            if (sum >= n) {
                return true;
            }
        }
        
        return false;
    }
}