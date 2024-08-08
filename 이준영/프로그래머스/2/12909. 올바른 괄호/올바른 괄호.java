import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack= new Stack<>();
        int len=s.length();
        for (int i=0;i<len;i++) {
        	char ch=s.charAt(i);
        	if (ch=='(') {
        		stack.push(ch);
        	} else if(!stack.isEmpty()&&stack.peek()=='('){
        		stack.pop();
        	} else {
        		answer = false;
        		break;
        	}
        }
        if (!stack.isEmpty())
        	answer=false;
        return answer;
    }
}