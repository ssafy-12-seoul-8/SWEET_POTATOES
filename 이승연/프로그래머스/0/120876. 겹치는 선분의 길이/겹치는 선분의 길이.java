import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = lines[0][0]; i < lines[0][1]; i++) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        
        for (int i = lines[1][0]; i < lines[1][1]; i++) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        
        for (int i = lines[2][0]; i < lines[2][1]; i++) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        
        System.out.println(map);
        
        int answer = 0;
        
        for (int num : map.keySet()) {
            if (map.get(num) >= 2) {
                answer += 1;
            }
        }
        
        return answer;
    }
}