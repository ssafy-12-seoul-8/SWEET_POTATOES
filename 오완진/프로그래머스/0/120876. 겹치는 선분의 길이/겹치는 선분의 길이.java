class Solution {
    public int solution(int[][] lines) {
    	
    	int min = lines[0][0];
    	int max = lines[0][0];
    	
    	for (int i = 0; i < 3; i++) {
    		min = Math.min(min, lines[i][0]);
    		max = Math.max(max, lines[i][1]);
    	}
    		
    	int[] cnt = new int[max-min+1];
    	
    	// 카운트 배열
        for (int i = 0; i < 3; i++)
            for (int j = lines[i][0]; j < lines[i][1]; j++)
                cnt[j - min]++;
        
        int result = 0;
        for (int i = 0; i < cnt.length; i++)
        	if (cnt[i] > 1) result++;			// 2이상 = 겹치는부분
    			
        return result;
    }
}