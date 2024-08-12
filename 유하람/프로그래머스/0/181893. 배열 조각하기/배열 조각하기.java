

class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        int len = arr.length;
		
		int start = 0;
		int end = len -1;
		
		for(int i=0 ; i<query.length ; i++) {
			if(i%2==0) {
				end = start + query[i];
			}else {
				start += query[i];
			}
		}
		
		int tmp = end - start +1;			
        
        int[] answer = new int[tmp];
        
        int idx = 0;
        
        for(int i=start ; i<=end ; i++) {
        	answer[idx++]=arr[i];
        }

        return answer;
    }
}