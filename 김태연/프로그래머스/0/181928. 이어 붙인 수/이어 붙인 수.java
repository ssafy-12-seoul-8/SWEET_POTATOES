class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String oddResult = "";
        String evenResult = "";
        for (int i=0; i<num_list.length; i++) {
        	// 짝수
        	if (num_list[i] % 2 == 0) {
        		evenResult += num_list[i];
        	} else {	// 홀수
        		oddResult += num_list[i];
        	}
        }
        answer = Integer.parseInt(oddResult) + Integer.parseInt(evenResult);
        
        return answer;
    }
}