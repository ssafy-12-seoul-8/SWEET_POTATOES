import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		int cnt = 0;

		for (int n = 1; n <= N; n++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int height = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek() > height)
				stack.pop();

			if (!stack.isEmpty() && stack.peek() == height)
				continue;

			if (height > 0) {
				cnt++;
				stack.add(height);
			}
		}

		System.out.println(cnt);
	}
}