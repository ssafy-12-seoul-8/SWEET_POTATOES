import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int N;
			N = sc.nextInt();

			String line = sc.next();

			Stack<Character> stack = new Stack<>();
			String output = "";

			// infix to postfix
			for (int i = 0; i < N; i++) {

				char x = line.charAt(i);
				// 숫자라면
				if (x > '0' && x <= '9') {
					output += x;
				} else {
					stack.push(x);
				}
			}

			while (!stack.isEmpty()) {
				output += stack.pop();
			}

//			System.out.println(output);
			// 현재 output = 12+;
			// postfix evaluate

			Stack<Integer> stack2 = new Stack<>();

//			System.out.println("output의 길이는 : " + output.length());
			for (int i = 0; i < output.length(); i++) {
				char x = output.charAt(i);

				if (x > '0' && x <= '9') {
//					System.out.println("stack 에 집어넣는중 : " +  x);
					stack2.add(x - '0');
				} else /* 나머지가 + 인 경우밖에 없음 */
				{
					int num1 = stack2.pop();
					int num2 = stack2.pop();
					int result = num1 + num2;
					stack2.push(result);
				}
			}
			int result = stack2.pop();
			System.out.println("#" + test_case + " " + result);
		}
	}
}