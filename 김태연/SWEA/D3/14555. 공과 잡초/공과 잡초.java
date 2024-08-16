//package IM대비;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for (int test_case = 1; test_case <= T; test_case++) {
			Stack<Character> stack = new Stack<>();
			String line = sc.nextLine();
//			System.out.println("test_case + " + test_case + " 번 라인 출력 : " + line);
			
			int count = 0;
			for (int i = 0; i < line.length(); i++) {
				char x = line.charAt(i);
				if (x == ')') {
					if (stack.pop() == '|') count++;
				} else if ( x == '(') {
					stack.add(x);
					count++;
				} else {
					stack.add(x);
				}
				
			}
			System.out.println("#" + test_case + " " + count);
			
		}
	}
}
