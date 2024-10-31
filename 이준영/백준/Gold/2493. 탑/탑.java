import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] h = new int[N + 1];

		for (int i = 1; i <= N; i++) {

			int a = Integer.parseInt(st.nextToken());
			h[i] = a;

			while (!stack.isEmpty() && h[stack.peek()] < a) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.push(i);
			} else {
				sb.append(stack.peek()).append(" ");
				stack.push(i);
			}
		}

		System.out.println(sb);
	}
}
