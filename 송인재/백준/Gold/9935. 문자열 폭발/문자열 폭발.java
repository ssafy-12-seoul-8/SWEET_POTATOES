import java.io.*;
import java.util.*;

public class Main {
	
	static char[] origin, bomb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		origin = br.readLine()
				.toCharArray();
		bomb = br.readLine()
				.toCharArray();
		Deque<Character> stack = new ArrayDeque<>();
		Deque<Character> tempStack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < origin.length; i++) {
			stack.push(origin[i]);
			
			if (stack.size() < bomb.length || stack.peek() != bomb[bomb.length - 1]) {
				continue;
			}
			
			for (int j = bomb.length - 1; j >= 0; j--) {
				if (stack.peek() != bomb[j]) {
					break;
				}
				
				tempStack.push(stack.pop());
				
				if (j == 0) {
					while (!tempStack.isEmpty()) {
						tempStack.pop();
					}
				}
			}
			
			while (!tempStack.isEmpty()) {
				stack.push(tempStack.pop());
			}
		}
		
		while (!stack.isEmpty()) {
			tempStack.push(stack.pop());
		}
		
		if (tempStack.isEmpty()) {
			sb.append("FRULA");
		} else {
			while (!tempStack.isEmpty()) {
				sb.append(tempStack.pop());
			}
		}
		
		System.out.println(sb);
	}
	
}
