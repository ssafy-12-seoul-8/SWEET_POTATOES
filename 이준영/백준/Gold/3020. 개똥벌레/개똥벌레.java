import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] down = new int[H + 1];
		int[] up = new int[H + 1];

		for (int i = 0; i < N / 2; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());

			down[a] += 1;
			up[b] += 1;

		}

		int mini = N/2;
		int count = 1;
		int tmp = N/2;

		for (int i = 2; i <= H; i++) {
			tmp = tmp - down[i-1] + up[H - i + 1];
			if (tmp > mini) {
				continue;
			} else if (tmp == mini) {
				count += 1;
			} else {
				count = 1;
				mini = tmp;
			}
		}
		System.out.println(mini+" "+count);

	}
}
