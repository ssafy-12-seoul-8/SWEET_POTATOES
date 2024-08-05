import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int K;
			K = sc.nextInt(); // 1 <= K <= 100,000

			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < K; i++) {
				int X = sc.nextInt(); // 하나씩 K번 받음. 값을 어떻게 처리할지는 미지수

				if (X == 0) {
					// 만약 정수가 0일 경우에는 최근에 쓰고 지우지 않앗던 수를 지운다
					stack.pop();
					
					
				} else {
					stack.add(X);
				}
			}

			int sum = 0;
			int length = stack.size();
			for (int i=0; i<length; i++) {
				sum += stack.pop();
			}
			
			System.out.println("#" + test_case + " " + sum);
			
		}
	}
}