import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<List<Integer>> pickList = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				map[n][m] = sc.nextInt();

		int maxSum = Integer.MIN_VALUE;
		combination(new ArrayList<>(), 0);			// 6 combination 2

		// 4 x 1
		for (int n = 0; n < N; n++) {
			for (int m = 0; m <= M - 4; m++) {
				int sum = 0;
				sum += map[n][m];
				sum += map[n][m+1];
				sum += map[n][m+2];
				sum += map[n][m+3];
				maxSum = Math.max(maxSum, sum);
			}
		}

		// 1 x 4
		for (int n = 0; n <= N - 4; n++) {
			for (int m = 0; m < M; m++) {
				int sum = 0;
				sum += map[n][m];
				sum += map[n+1][m];
				sum += map[n+2][m];
				sum += map[n+3][m];
				maxSum = Math.max(maxSum, sum);
			}
		}

		// 2 x 2
		for (int n = 0; n <= N -2; n++) {
			for (int m = 0; m <= M - 2; m++) {
				int sum = 0;
				sum += map[n][m];
				sum += map[n][m+1];
				sum += map[n+1][m];
				sum += map[n+1][m+1];
				maxSum = Math.max(maxSum, sum);
			}
		}

		// 3 x 2 -> 4개 pick
		for (int n = 0; n <= N - 2; n++) {
			for (int m = 0; m <= M - 3; m++) {
				int sum = 0;
				int[] tet = {map[n][m], map[n][m+1], map[n][m+2], map[n+1][m], map[n+1][m+1], map[n+1][m+2]};
				int minSum = Integer.MAX_VALUE;

				for (List<Integer> pick : pickList) {
                	if (pick.get(0) == 0 && pick.get(1) == 4) continue;
					if (pick.get(0) == 1 && pick.get(1) == 3) continue;
					if (pick.get(0) == 1 && pick.get(1) == 4) continue;
					if (pick.get(0) == 1 && pick.get(1) == 5) continue;
					if (pick.get(0) == 2 && pick.get(1) == 4) continue;

                    int tmp = tet[pick.get(0)] + tet[pick.get(1)];
					minSum = Math.min(minSum, tmp);			// 2개 최소값 -> 나머지 4개 최대값
				}

				for (int i = 0; i < 6; i++)
					sum += tet[i];

				sum -= minSum;
				maxSum = Math.max(maxSum, sum);
			}
		}

		// 2 x 3 -> 4개 pick
		for (int n = 0; n <= N - 3; n++) {
			for (int m = 0; m <= M - 2; m++) {
				int sum = 0;
				int[] tet = {map[n][m], map[n][m+1], map[n+1][m], map[n+1][m+1], map[n+2][m], map[n+2][m+1]};
				int minSum = Integer.MAX_VALUE;

                for (List<Integer> pick : pickList) {
					if (pick.get(0) == 0 && pick.get(1) == 3) continue;
					if (pick.get(0) == 1 && pick.get(1) == 2) continue;
					if (pick.get(0) == 2 && pick.get(1) == 3) continue;
					if (pick.get(0) == 2 && pick.get(1) == 5) continue;
					if (pick.get(0) == 3 && pick.get(1) == 4) continue;

                    int tmp = tet[pick.get(0)] + tet[pick.get(1)];
					minSum = Math.min(minSum, tmp);			// 2개 최소값 -> 나머지 4개 최대값
				}

				for (int i = 0; i < 6; i++)
					sum += tet[i];

				sum -= minSum;
				maxSum = Math.max(maxSum, sum);
			}
		}

		System.out.println(maxSum);
	}

	// 6 combination 2 = 15
	static void combination(List<Integer> pick, int start) {
		if (pick.size() == 2) {
			pickList.add(new ArrayList<>(pick));
			return;
		}

		for (int i = start; i < 6; i++) {
			pick.add(i);
			combination(pick, i + 1);
			pick.remove(pick.size() - 1);
		}
	}

}
