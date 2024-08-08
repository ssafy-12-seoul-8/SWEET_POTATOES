import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine()); // 1
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {

			int N;	
			N = Integer.parseInt(br.readLine());	// 5
			int[][] arr = new int[N][N];
			String line;
			for (int i = 0; i < N; i++) {
				line = br.readLine();		// 14054 * 5
				for (int j = 0; j < N; j++) {
					arr[i][j] = line.charAt(j) - '0';
				}
			}

			// 입력 다 받았고, 합계 구해야함
			// 함수로 구하면 쉬울것같음

			int L = N / 2;
			int sum = 0;
			// (0,0) ~ (6,6)
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {

					if (y <= x + L && y >= x - L && y <= -x + L + N - 1 && y >= -x + L) {
						sum += arr[x][y];
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}