import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			// String 으로 ()() 다 받아온 다음에 cut 할때마다 stack size 를 더하면 문제 풀릴듯
			
			String line = sc.next();
			
			char[] arr = new char[line.length()];
			
			for (int i=0; i<line.length(); i++) {
				arr[i] = line.charAt(i);
			}
			
			Stack<Integer> stack = new Stack<Integer>();
			
			int sum = 0;
			stack.push(1);
			for (int i=1; i<line.length(); i++) {
				if (arr[i] == '(') stack.push(1);
				if (arr[i] == ')')  {
					
					stack.pop();
					
					if (arr[i-1] == '(') {
//						System.out.println("레이저빔! : " + stack.size());
						sum += stack.size();
					} else {
						sum += 1;
					}
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}