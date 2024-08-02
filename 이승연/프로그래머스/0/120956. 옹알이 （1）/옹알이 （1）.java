import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            int strCount = 0;
            for (String word : words) {
                if (babbling[i].contains(word)) {
                    strCount += word.length();
                }
            }
            
            if (babbling[i].length() == strCount) {
                answer += 1;
            }
        }
        
        return answer;
    }
}