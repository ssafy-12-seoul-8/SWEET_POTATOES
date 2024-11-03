import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		long[] liquids = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			liquids[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(liquids);
		
		long minSum = Long.MAX_VALUE;
		int pickedL = -1;
		int pickedM = -1;
		int pickedR = -1;

		for (int L = 0; L < N - 1; L++) {

			int M = L + 1;
			int R = N - 1;

			while (M < R) {

				long sum = liquids[L] + liquids[M] + liquids[R];
				if (Math.abs(sum) < Math.abs(minSum)) {
					minSum = sum;
					pickedL = L;
					pickedM = M;
					pickedR = R;
				}

				if (sum < 0)
					M++;
				else
					R--;
			}
		}

		sb.append(liquids[pickedL]).append(" ");
		sb.append(liquids[pickedM]).append(" ");
		sb.append(liquids[pickedR]);
		System.out.println(sb);
	}
}