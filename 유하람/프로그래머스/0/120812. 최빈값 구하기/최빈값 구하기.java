import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int len = array.length;
        
        int max = 0;
        
        for(int i=0 ; i<len ; i++){
            if(max<array[i]){
                max = array[i];
            }
        }
        
        int[] count = new int[max+1];
        Arrays.fill(count,-1);
        
        for(int i=0; i<len ; i++){
            count[array[i]]++;
        }
        
        int max_idx = 0;
        
        for(int i=0 ; i<max+1 ; i++){
            if(count[i]>count[max_idx]){
                max_idx = i;
                answer = max_idx;
            }
        }
        
        int cnt = 0;
        
        for(int i=0 ; i<max+1 ; i++) {
        	if(count[i]==count[max_idx]) {
        		cnt++;
        	}
        }
        
        if(cnt>=2) {
        	answer = -1;
        }

        
        return answer;
    }
}