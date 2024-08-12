class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        int[] count = new int[prices.length];	// return 할 배열

        int L = prices.length;
        
        // 0번부터 마지막 prices 에 대해서
        for (int i=0; i<L; i++) {
        	// 만약 price[0] 가 1번 price 보다 크면 count[0]++
        	// 만약 0번 price 가 1번 price 보다 크면 count[0]++
        	
        	for (int j=i+1; j<L; j++) {
        		if (prices[i] <= prices[j] ) {
        			// i = 0; j = 1, prices[1] = 2; 1<=2; cnt=1
        			// i = 0; j = 2, prices[2] = 3; 1<=3; cnt=2
                    // i = 0; j = 3, prices[3] = 2; 1<=2; cnt=3
                    // i = 0; j = 4, prices[4] = 3; 1<=3; cnt=4
                    
                    // i = 2; j = 3, prices[3] = 2; 3 !< 2; cnt = 1; break;
                    // i = 3; j = 4, prices[4] = 3; 2 <= 3; cnt = 1;
                    // i = 4
        			count[i]++;
        		} else {
                    count[i]++;
                    break;
                }
                    
        	}
        }
        answer = count;
        
        return answer;
    }
}