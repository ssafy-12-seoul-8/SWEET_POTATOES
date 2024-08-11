class Solution {
    public int[] solution(int[] prices) {
    	
    	int N = prices.length;
    	int[] times = new int[N];
    	
    	for (int i = 0; i < N; i++) {
    		int cnt = 0;
    		for (int j = i+1; j < N; j++) {
    			cnt++;
    			if (prices[i] > prices[j]) break;
    		}
    		times[i] = cnt;
    	}
    	return times;
    }
}