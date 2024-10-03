class Solution {
    public long solution(int n, int[] times) {
    	
    	long L = 0;
    	long R = Long.MAX_VALUE;
    	
    	while (L <= R) {
    		long M = (L + R) / 2;
    		long cnt = 0;
    		
    		for (int time : times) {
    			cnt += M / time;
    			if (cnt >= n) break;
    		}
    		
    		if (cnt >= n)
    			R = M - 1;
    		else
    			L = M + 1;
    	}
    	
    	return L;
    }
}