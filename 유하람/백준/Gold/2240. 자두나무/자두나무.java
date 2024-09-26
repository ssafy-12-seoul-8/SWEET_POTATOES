import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		// 열매가 떨어지는 시간
		// 1<=T<=1,000
		int T = sc.nextInt();
		// 자두가 움직일 수 있는 횟수
		// 1<=W<=30
		int W = sc.nextInt();

		// 열매가 떨어지는 나무 위치
		int[] tree = new int[T + 1];

		for (int i = 1; i <= T; i++) {
			// 열매가 떨어지는 나무 : 1 or 2
			tree[i] = sc.nextInt();
		}

		// DP 배열
		// {움직인 횟수}{위치}{시간}
		int[][][] DP = new int[W + 1][3][T + 1];

		for (int t = 1; t <= T; t++) { // t 초에
			for (int w = 0; w <= W; w++) { // w 번 움직이는 경우
				// 각 각의 나무에서
				// Math.max(움직이지 않고 받은 경우, 움직이고 받은 경우)
				// Math.max(움직이지 않고 못 받은 경우, 움직이고 못 받은 경우)

				if (tree[t] == 1) {
					// 1번 나무에서 받은 경우
					DP[w][1][t] = Math.max(DP[w][1][t - 1] + 1, w > 0 ? DP[w - 1][2][t - 1] + 1 : 0);
					// 2번 나무에서 못 받은 경우
					DP[w][2][t] = Math.max(DP[w][2][t - 1], w > 0 ? DP[w - 1][1][t - 1] : 0);
				} else {
					if (t == 1 && w == 0) {
						DP[0][2][1] = 0;
					} else {
						// 1번 나무에서 못 받은 경우
						DP[w][1][t] = Math.max(DP[w][1][t - 1], w > 0 ? DP[w - 1][2][t - 1] : 0);
						// 2번 나무에서 받은 경우
						DP[w][2][t] = Math.max(DP[w][2][t - 1] + 1, w > 0 ? DP[w - 1][1][t - 1] + 1 : 0);
					}
				}
			}

		}

		System.out.println(Math.max(DP[W][1][T], DP[W][2][T]));
		sc.close();
	}

}