import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[] opsChar = { '+', '-', '*', '/' };
	static int n, max, min;
	static int[] nums;
	static char[] ops;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		ops = new char[n - 1];
		visited = new boolean[n - 1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int index = 0;

		for (int i = 0; i < 4; i++) {
			int limit = Integer.parseInt(st.nextToken());

			for (int j = 0; j < limit; j++) {
				ops[index++] = opsChar[i];
			}
		}

		permutation(0, new char[n - 1]);

		System.out.println(max);
		System.out.println(min);
	}

	static void permutation(int current, char[] selected) {
		if (current == n - 1) {
			calculate(selected);

			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			selected[current] = ops[i];

			permutation(current + 1, selected);

			visited[i] = false;
		}
	}

	static void calculate(char[] selected) {
		int sum = nums[0];

		for (int i = 0; i < selected.length; i++) {
			switch (selected[i]) {
			case '+':
				sum += nums[i + 1];
				break;
			case '-':
				sum -= nums[i + 1];
				break;
			case '*':
				sum *= nums[i + 1];
				break;
			case '/':
				sum /= nums[i + 1];
				break;
			default:
				break;
			}
		}
		
		max = Math.max(max, sum);
		min = Math.min(min, sum);
	}

}
