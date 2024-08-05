import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			Stack<Character> stack1 = new Stack<Character>();
			Stack<Character> stack2 = new Stack<Character>();
			Stack<Character> stack3 = new Stack<Character>();
			Stack<Character> stack4 = new Stack<Character>();
			int N;
			N = sc.nextInt();
			String line = sc.next();
			char x;
			int result = 0;
			validate : for (int i = 0; i < N; i++) {
				x = line.charAt(i);

				switch (x) {
				case '(':
//					System.out.println("case(");
					stack1.push('(');
					break;
				case ')':
//					System.out.println("case)");
					if (stack1.isEmpty()) {
						break validate;
					}
					stack1.pop();
					break;
				case '{':
//					System.out.println("case{");
					stack2.push('{');
					break;
				case '}':
//					System.out.println("case}");
					if (stack2.isEmpty()) {
						break validate;
					}
					stack2.pop();
					break;
				case '[':
//					System.out.println("case[");
					stack3.push('[');
					break;
				case ']':
					if (stack3.isEmpty()) {
						break validate;
					}
					stack3.pop();
					break;
				case '<':
//					System.out.println("case<");
					stack4.push('<');
					break;
				case '>':
//					System.out.println("case>");
					if (stack4.isEmpty()) {
						break validate;
					}
					stack4.pop();
					break;
				}
				
				if (i==N-1) {
					if (stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty() && stack4.isEmpty()) {
//						System.out.println("아무 문제 없음!");
						result = 1;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + result);

		}
	}
}