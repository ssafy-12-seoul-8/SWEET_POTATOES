import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> expiryMonths = new HashMap<>();
        String[] current = today.split("\\.");
        int year = Integer.parseInt(current[0]);
        int month = Integer.parseInt(current[1]);
        int day = Integer.parseInt(current[2]);
        List<Integer> expired = new ArrayList<>();
        
        for (String term : terms) {
            String[] condition = term.split(" ");
            String type = condition[0];
            int period = Integer.parseInt(condition[1]);
            
            expiryMonths.put(type, period);
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] startDate = privacy[0].split("\\.");
            String type = privacy[1];
            int endYear = Integer.parseInt(startDate[0]);
            int endMonth = Integer.parseInt(startDate[1]) + expiryMonths.get(type);
            int endDay = Integer.parseInt(startDate[2]) - 1;
            
            if (endDay < 1) {
                endDay = 28;
                endMonth--;
            }
            
            if (endMonth > 12) {
                endYear += endMonth % 12 == 0 ? endMonth / 12 - 1 : endMonth / 12;
                endMonth = endMonth % 12 == 0 ? 12 : endMonth % 12;
            }
            
            if (endYear > year) {
                continue;
            }
            
            if (endYear < year) {
                expired.add(i + 1);
                
                continue;
            }
            
            if (endMonth > month) {
                continue;
            }
            
            if (endMonth < month) {
                expired.add(i + 1);
                
                continue;
            }
            
            if (endDay > day) {
                continue;
            }
            
            if (endDay < day) {
                expired.add(i + 1);
            }
        }
        
        int[] answer = new int[expired.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = expired.get(i);
        }
        
        return answer;
    }
}