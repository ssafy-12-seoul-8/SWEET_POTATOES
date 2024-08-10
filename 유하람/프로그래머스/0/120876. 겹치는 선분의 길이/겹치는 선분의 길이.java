import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[][] lines) {
	 	int answer = 0;
                                        
	 	int cnt = 0;
	 	        

        Map<Integer, Integer> overLap = new HashMap<>();
        

        for (int[] line : lines) {
            for (int i = line[0]; i < line[1]; i++) {
                overLap.put(i, overLap.getOrDefault(i, 0) + 1);
            }
        }
        

        for (int count : overLap.values()) {
            if (count > 1) {
                cnt++;
            }
        }


	 	answer = cnt;
        
        return answer;
    }
}