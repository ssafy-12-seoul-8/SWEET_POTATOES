import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String ex = br.readLine();

		int len = ex.length();

		StringBuilder sb = new StringBuilder();

		Stack<Character> oper = new Stack<>();

		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);

		for (int i = 0; i < len; i++) {
			char c = ex.charAt(i);

			if (65 <= c && c <= 90) {
				sb.append(c);
			} else if (oper.isEmpty()) {
				oper.add(c);
			} else if (c == '(') {
				oper.add(c);
			} else if (c == ')') {
				while (oper.peek() != '(') {
					sb.append(oper.pop());
				}
				oper.pop();
			} else if (priority.get(c) > priority.get(oper.peek())) {
				oper.push(c);
			} else {
				while (!oper.isEmpty() && priority.get(c) <= priority.get(oper.peek())) {
					sb.append(oper.pop());
				}
				oper.push(c);
			}

		}

		while (!oper.isEmpty()) {
			sb.append(oper.pop());
		}

		System.out.println(sb);

	} // main

} // Main
