import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scores = new HashMap<>();
        char[] types = new char[] { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' };
        
        for (char type: types) {
            scores.put(type, 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] == 4) {
                continue;
            }
            
            if (choices[i] > 4) {
                char type = survey[i].charAt(1);
                int add = choices[i] - 4;
                
                scores.put(type, scores.get(type) + add);
            } else {
                char type = survey[i].charAt(0);
                int add = 4 - choices[i];
                
                scores.put(type, scores.get(type) + add);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < types.length; i += 2) {
            char first = types[i];
            char second = types[i + 1];
            int firstScore = scores.get(first);
            int secondScore = scores.get(second);
            
            sb.append(secondScore > firstScore ? second : first);
        }
        
        return sb.toString();
    }
}