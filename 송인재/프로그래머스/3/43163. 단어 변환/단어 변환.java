import java.util.*;

class Solution {
    int count = 0;
    Set<String> set;
    Set<String> visited = new HashSet<>();
    
    public int solution(String begin, String target, String[] words) {
        set = Set.of(words);
        
        if (!set.contains(target)) {
            return 0;
        }
        
        backtrack(begin, target, 0);
        
        return count;
    }
    
    void backtrack(String current, String target, int trackCount) {
        if (count != 0 && count >= trackCount) {
            return;
        }
        
        if (current.equals(target)) {
            count = trackCount;
            
            return;
        }
        
        if (visited.size() == set.size()) {
            return;
        }
        
        for (String str : set) {
            if (visited.contains(str)) {
                continue;
            }
            
            visited.add(str);
            
            if (isPossible(current, str)) {
                backtrack(str, target, trackCount + 1);
            }
            
            visited.remove(str);
        }
    }
    
    boolean isPossible(String str, String target) {
        int diffCount = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != target.charAt(i)) {
                diffCount++;
            }
            
            if (diffCount > 1) {
                return false;
            }
        }
        
        return true;
    }
}