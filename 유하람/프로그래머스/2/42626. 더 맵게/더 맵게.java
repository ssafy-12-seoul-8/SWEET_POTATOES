import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i : scoville) {
			pq.add(i);
		}
		
		int cnt = 0;
		boolean flag = false;
		
		while(pq.size()>1) {
			int food1 = pq.poll();
			int food2 = pq.poll();
			int result = food1 + 2*food2;
            
            if(food1 >= K){
                flag = true;
                break;
            }
            
			pq.add(result);
			cnt++;
			int check = pq.peek();
			if(check>=K) {
				flag = true;
				break;
			}
		}
		
		answer = cnt;
		
		if(!flag) {
			answer = -1;
		}
		
		System.out.println(answer);
        
        
        
        
        
        
        return answer;
    }
}