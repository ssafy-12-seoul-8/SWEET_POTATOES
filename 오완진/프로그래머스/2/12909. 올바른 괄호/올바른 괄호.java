import java.util.Stack;

class Solution {
    boolean solution(String s) {
    	
    	char[] charArr = s.toCharArray();
    	Stack<Character> gwalho = new Stack<>();

    	for (char ch : charArr) {
    		if (ch == '(') gwalho.push('(');
    		else {
    			if (!gwalho.isEmpty()) {
    				if (gwalho.peek() == '(') gwalho.pop();	// '()'
    				else return false;						// 이상한거
    			} else return false;						// '(' 없음
    		}
    	}
    	
    	if (!gwalho.isEmpty()) return false;				// 나머지 존재
    	else return true;
    	
    }
}