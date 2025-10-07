import java.util.*;

class Solution {
    int roots;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String bins = convert(numbers[i]);
            roots = 0;
            boolean top = validateNode(0, bins.length() - 1, bins);
            
            roots = top ? roots + 1 : 0;
            
            if (roots == 1) {
                answer[i]++;
            }
        }
        
        return answer;
    }
    
    String convert(long number) {
        StringBuilder sb = new StringBuilder();
        
        while (number > 0) {
            sb.append(number % 2);
            
            number /= 2;
        }
        
        String converted = sb.reverse()
            .toString();
        
        int n = 0;
        int length = converted.length();
        
        while (length > 0) {
            n++;
            length /= 2;
        }
        
        int totalLength = ((int) Math.pow(2, n)) - 1;
        
        return "0".repeat(totalLength - converted.length()) + converted;
    }
    
    boolean validateNode(int start, int end, String bins) {
        if (start == end) {
            return bins.charAt(start) == '1';
        }
        
        int current = (start + end) / 2;
        boolean left = validateNode(start, current - 1, bins);
        boolean right = validateNode(current + 1, end, bins);
        
        if (bins.charAt(current) == '1') {
            return true;
        }
        
        if (left) {
            roots++;
        }
        
        if (right) {
            roots++;
        }
        
        return false;
    }
    
}