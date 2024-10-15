import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (isPossible(mid, n, rocks, distance)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
    
    boolean isPossible(int diff, int n, int[] rocks, int distance) {
        int standard = 0;
        int count = 0;
        
        for (int rock : rocks) {
            if (diff <= rock - standard) {
                standard = rock;
            } else {
                count++;
            }
            
            if (count > n) {
                return false;
            }
        }
        
        if (diff > distance - standard) {
            count++;
        }
        
        return count <= n;
    }
}