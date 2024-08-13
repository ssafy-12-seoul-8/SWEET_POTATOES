import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
		
		int[] result = new int[prices.length];
		
		for(int i=0 ; i<prices.length ; i++) {
			while(!stack.isEmpty() && prices[stack.peek()]>prices[i]) {
				int idx = stack.pop();
				result[idx] = i - idx;
			}
			
			stack.push(i);
			
		}
		
		while(!stack.isEmpty()) {
			int idx = stack.pop();
			result[idx] = prices.length -1 -idx;
		}
        return result;
    }
}