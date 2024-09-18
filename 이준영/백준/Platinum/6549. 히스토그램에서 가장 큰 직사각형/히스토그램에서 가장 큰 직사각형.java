import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}

			int[] arr = new int[N + 1];
			arr[0] = -1;

			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			long max_area = 0;
			Stack<Integer> stack = new Stack<>();
			stack.push(0);
			for (int i = 1; i <= N; i++) {
				while (arr[stack.peek()] > arr[i]) {

					int a = stack.pop();
					long tmp_area = (long) arr[a] * (i - stack.peek() - 1);
					max_area = Math.max(max_area, tmp_area);

				}

				stack.push(i);
//				for(int j:stack) {
//					System.out.print(j+" ");
//				}
//				System.out.println();
			}
			while (stack.size() >= 2) {

				int a = stack.pop();
				long tmp_area = (long) arr[a] * (N - stack.peek());
				max_area = Math.max(max_area, tmp_area);

			}
			sb.append(max_area).append("\n");
		}

		System.out.println(sb);
	}
}
