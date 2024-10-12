import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[][] dp = new int[H + 1][2]; // 0번 인덱스는 왼쪽으로 끝날 때, 1번 인덱스는 오른쪽으로 끝날때
		int[][] rooms = new int[H + 1][2];
		int max_floor = 0;

		for (int i = 1; i < H + 1; i++) {
			rooms[i][0] = 101;
		}
		rooms[0][0] = 1;
		rooms[0][1] = 1;
		dp[0][0] = -100;
		dp[0][1] = -100;
		int left = 1;
		int right = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			max_floor = Math.max(max_floor, a);
			rooms[a][0] = Math.min(rooms[a][0], b);
			rooms[a][1] = Math.max(rooms[a][1], b);
		}

		for (int i = 1; i < max_floor + 1; i++) {
			if (rooms[i][0] == 101) {
				dp[i][0] = dp[i - 1][0] + 100;
				dp[i][1] = dp[i - 1][1] + 100;
			} else {
				dp[i][0] = Math.min(dp[i - 1][0] + Math.abs(rooms[i][1] - left),
						dp[i - 1][1] + Math.abs(rooms[i][1] - right)) + (rooms[i][1] - rooms[i][0]) + 100;
				dp[i][1] = Math.min(dp[i - 1][0] + Math.abs(rooms[i][0] - left),
						dp[i - 1][1] + Math.abs(rooms[i][0] - right)) + (rooms[i][1] - rooms[i][0]) + 100;
				left = rooms[i][0];
				right = rooms[i][1];
			}
		}
//		for (int i = 0; i < H + 1; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.print(rooms[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i < H + 1; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(Math.min(dp[max_floor][0], dp[max_floor][1]));
	}
}
