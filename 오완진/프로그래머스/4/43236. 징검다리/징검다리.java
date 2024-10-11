import java.util.Arrays;

class Solution {
	
	static int[] between;
	
    public int solution(int D, int[] rocks, int N) {
    	
    	Arrays.sort(rocks);
    	
    	between = new int[rocks.length+1];
    	
    	int tmp = 0;
    	for (int i = 0; i < rocks.length; i++) {
    		int rock = rocks[i];
    		between[i] = rock - tmp;
    		tmp = rock;
    	}
    	between[rocks.length] = D - tmp;
    	
    	int L = 1;
    	int R = D;
    	int answer = -1;
    	while (L <= R) {
    		int M = (L + R) / 2;
    		
    		if (cntRemoved(M) <= N)	{	// 가능
    			answer = M;
    			L = M + 1;
    		}
    		else						// 불가능
    			R = M - 1;
    	}
    	
    	return answer;
    }
    
    static int cntRemoved(int minDistance) {
    	int cnt = 0;
    	int sumDistance = 0;
    	
    	for (int distance : between) {
    		sumDistance += distance;
    		
    		if (sumDistance >= minDistance)
    			sumDistance = 0;
    		else
    			cnt++;
    	}
    	
    	return cnt;
    }
}