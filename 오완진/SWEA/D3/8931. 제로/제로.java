import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			
			int num = 0;
			int sum = 0;
			int K = sc.nextInt();
			for (int k = 0; k < K; k++) {
				num = sc.nextInt();
				if (num == 0)
					stack.pop();
				else
					stack.push(num);
			}
			
//			for (int s : stack)
//				System.out.print(s + " ");
//			System.out.println();
			
			int stackSize = stack.size();
			for (int k = 0; k < stackSize; k++) {
				num = stack.pop();
				sum += num;
			}
			
			System.out.println("#" + t + " " + sum);

		}
			
	}	
}