import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line = reader.readLine().trim();
		String[] tokens = line.split(" ");

		int N = Integer.parseInt(tokens[0]);
		int H = Integer.parseInt(tokens[1]);

		int[] btm = new int[H + 1];
		int[] top = new int[H + 1];

		for (int n = 0; n < N; n++) {
			int height = Integer.parseInt(reader.readLine().trim());
			if (n % 2 == 0)
				btm[height]++;
			else
				top[H - height + 1]++;
		}

		for (int i = H - 1; i >= 1; i--)
			btm[i] += btm[i + 1];
		for (int i = 2; i <= H; i++)
			top[i] += top[i - 1];
		
		int min = Integer.MAX_VALUE;
		int cnt = 1;

		for (int i = 1; i <= H; i++) {
			int total = btm[i] + top[i];
			if (total < min) {
				min = total;
				cnt = 1;
			} else if (total == min)
				cnt++;
		}
		
		System.out.println(min + " " + cnt);

	}
}