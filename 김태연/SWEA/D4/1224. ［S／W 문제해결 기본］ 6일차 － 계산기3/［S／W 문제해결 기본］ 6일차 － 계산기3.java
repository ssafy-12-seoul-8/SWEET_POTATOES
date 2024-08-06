import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
class Solution
{
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('*', 2);
	}
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			
			int N;
			N = sc.nextInt();
			String line = sc.next();
			
			Stack<Character> stack = new Stack<>();
			String postFix = "";
			for (int i=0; i<N; i++) {
				char x = line.charAt(i);
				
				// 숫자값은 그냥 출력
				if ('9' >= x && x >= '0') {
					postFix += x;
				} else if (x == '(') {	// 여는 괄호가 나온다면
					// 무조건 push
					stack.push('(');
				} else if (x == ')') {	// 닫힌 괄호가 나온다면
					// 여는 괄호가 나올때까지 팝
					char popItem = stack.pop();
					while (popItem != '(') {
						postFix += popItem;
						popItem = stack.pop();
					}
					// 연산자들 나올차례
					// +, * 두 종류 있음
					// 우선순위가 더 낮은 연산자가 나올때까지 pop
					// 즉 * 이면 +가 나올때까지 팝
					// + 이면 ㄱㅊ
				} else   {
					while(!stack.isEmpty() && 
							stack.peek() != '(' && 
							map.get(stack.peek()) >= map.get(x)) {
						char popItem = stack.pop();
						postFix += popItem;
					}
					stack.push(x);
				}
			}
			
			while (!stack.isEmpty()) {
				postFix += stack.pop();
			}

			
//			System.out.println(postFix);
			
			Stack<Integer> stack2 = new Stack<>();
			int result = 0;
			
			for (int i=0; i<postFix.length(); i++) {
				// 이제 정리된 postFix 를 evaluate 하면 됨.
				char x = postFix.charAt(i);
				
				if ('0' <= x && x <= '9') {
					stack2.push(x - '0');
				} else {
					int num1 = stack2.pop();
					int num2 = stack2.pop();
					if (x == '*') {
						result = num1 * num2;
					} else {
						result = num1 + num2;
					}
					stack2.push(result);
				}
			}
			result = stack2.pop();
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}