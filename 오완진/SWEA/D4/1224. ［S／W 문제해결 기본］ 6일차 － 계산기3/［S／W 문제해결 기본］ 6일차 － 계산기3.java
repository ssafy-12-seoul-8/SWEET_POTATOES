import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int N = sc.nextInt();
			sc.nextLine();
			String expression = sc.nextLine();
			int result = evaluate(expression);
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	static int evaluate(String expression) {
		String postfix = infixToPostfix(expression);
		return evalPostfix(postfix);
	}
	
	static Map<Character, Integer> map = new HashMap<>();

	static {
		map.put('+', 1);
		map.put('*', 2);
	}
	
	static String infixToPostfix(String infix) {
		
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			if ('0' <= c && c <= '9') {
				// 피연산자 -> 출력
				postfix += c;
			} else if (c == '(') {
				// 여는 괄호 -> push
				stack.push(c);
			} else if (c == ')') {
				// 닫는 괄호 -> 여는 괄호가 나올 때까지 pop
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else {
				// 연산자 : top 우선순위가 낮은 연산자가 올 때까지 pop
				while (!stack.isEmpty() &&
						stack.peek() != '(' &&
						map.get(stack.peek()) >= map.get(c)){
					
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}
		
		// 스택 비우기
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}

		return postfix;
	}
	
	static int evalPostfix(String postfix) {
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if ('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result;
				
				if (c == '+') {
					result = num1 + num2;
				} else {
					result = num1 * num2;
				}
				
				stack.push(result);
			}
		}
		
		return stack.pop();
	}
}