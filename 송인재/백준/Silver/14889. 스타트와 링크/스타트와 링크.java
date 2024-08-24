import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, total, min;
	static int[][] abils;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		abils = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				abils[i][j] = Integer.parseInt(st.nextToken());
				total += abils[i][j];
			}
		}

		combination(new boolean[n], 0, 0);
		System.out.println(min);
	}

	static void combination(boolean[] teams, int index, int current) {
		if (current == n / 2) {
			calculateDiff(teams);
			
			return;
		}

		for (int i = index; i < n; i++) {
			teams[i] = true;

			combination(teams, i + 1, current + 1);

			teams[i] = false;
		}
	}

	static void calculateDiff(boolean[] teams) {
		int startSum = 0;
		int linkSum = 0;

		for (int i = 0; i < teams.length - 1; i++) {
			for (int j = i + 1; j < teams.length; j++) {
				if (teams[i] && teams[j]) {
					startSum += abils[i][j] + abils[j][i];
				}

				if (!teams[i] && !teams[j]) {
					linkSum += abils[i][j] + abils[j][i];
				}
			}
		}

		min = Math.min(min, Math.abs(startSum - linkSum));
	}

}
