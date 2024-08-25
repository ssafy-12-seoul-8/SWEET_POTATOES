import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, max;
	static int[] t;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		t = new int[n];
		p = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			searchMax(i, p[i]);
		}

		System.out.println(max);
	}

	static void searchMax(int current, int sum) {
		int next = current + t[current];

		if (next >= n) {
			max = Math.max(max, next == n ? sum : sum - p[current]);
			
			return;
		}

		for (int i = next; i < n; i++) {
			searchMax(i, sum + p[i]);
		}
	}

}
