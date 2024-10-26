import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int X = Integer.parseInt(st.nextToken());	// X센트
		int A = Integer.parseInt(st.nextToken());	// 1센트
		int B = Integer.parseInt(st.nextToken());	// 5센트
		int C = Integer.parseInt(st.nextToken());	// 10센트
		int D = Integer.parseInt(st.nextToken());	// 25센트
		
		int maxA = A;
		int maxB = A + B * 5;
		int maxC = A + B * 5 + C * 10;
		int maxD = A + B * 5 + C * 10 + D * 25;
		
		int[][] dp = new int[maxD + 1][4];
		for (int a = 1; a <= A; a++)
			dp[a][0] = a;
		for (int b = 1; b <= B; b++)
			if (dp[b * 5][0] == 0)
				dp[b * 5][1] = b;
		for (int c = 1; c <= C; c++)
			if (dp[c * 10][0] == 0 && dp[c * 10][1] == 0)
				dp[c * 10][2] = c;
		for (int d = 1; d <= D; d++)
			if (dp[d * 25][0] == 0 && dp[d * 25][1] == 0 && dp[d * 25][2] == 0)
				dp[d * 25][3] = d;
		
		int start0 = Math.max(maxA, 5);
		for (int b = 0; b < B; b++) {
			for (int a = 1; a <= 5; a++) {				
				int start = start0 + b * 5 + a;
				
				if (dp[start - 5][0] != 0) {
					dp[start][0] = dp[start - 5][0];
					dp[start][1] = dp[start - 5][1] + 1;
					dp[start][2] = 0;
					dp[start][3] = 0;
				}
			}
		}
		
		start0 = Math.max(maxB, 10);
		for (int c = 0; c < C; c++) {
			for (int b = 1; b <= 10; b++) {
				
				int start = start0 + c * 10 + b;
				
				if (dp[start - 10][0] != 0 || dp[start - 10][1] != 0) {
					dp[start][0] = dp[start - 10][0];
					dp[start][1] = dp[start - 10][1];
					dp[start][2] = dp[start - 10][2] + 1;
					dp[start][3] = 0;
				}
			}
		}
		
		start0 = Math.max(maxC, 25);
		
		if (start0 > 25) {
			// 25센트에서는 그리디 반례가 필요
			for (int x = 26; x <= start0; x++) {
				if (dp[x - 25][0] != 0 || dp[x - 25][1] != 0 || dp[x - 25][2] != 0) {
					
					int noD = dp[x][0] + dp[x][1] + dp[x][2] + dp[x][3];
					int yesD = dp[x - 25][0] + dp[x - 25][1] + dp[x - 25][2] + dp[x - 25][3] + 1;
					
					if (yesD >= noD) {
						dp[x][0] = dp[x - 25][0];
						dp[x][1] = dp[x - 25][1];
						dp[x][2] = dp[x - 25][2];
						dp[x][3] = dp[x - 25][3] + 1;
					}
				}
			}
		}
		
		for (int d = 0; d < D; d++) {
			for (int c = 1; c <= 25; c++) {
				
				int start = start0 + d * 25 + c;
				
				if (dp[start - 25][0] != 0 || dp[start - 25][1] != 0 || dp[start - 25][2] != 0) {
					
					int noD = dp[start][0] + dp[start][1] + dp[start][2] + dp[start][3];
					int yesD = dp[start - 25][0] + dp[start - 25][1] + dp[start - 25][2] + dp[start - 25][3] + 1;
					
					if (yesD >= noD) {
						dp[start][0] = dp[start - 25][0];
						dp[start][1] = dp[start - 25][1];
						dp[start][2] = dp[start - 25][2];
						dp[start][3] = dp[start - 25][3] + 1;
					}
				}
			}
		}
		
//		for (int x = 1; x <= maxD; x++)
//			System.out.printf(" %2d", x);
//		System.out.println();
//		System.out.println();
//		for (int x = 1; x <= maxD; x++)
//			System.out.printf(" %2d", dp[x][0]);
//		System.out.println();
//		for (int x = 1; x <= maxD; x++)
//			System.out.printf(" %2d", dp[x][1]);
//		System.out.println();
//		for (int x = 1; x <= maxD; x++)
//			System.out.printf(" %2d", dp[x][2]);
//		System.out.println();
//		for (int x = 1; x <= maxD; x++)
//			System.out.printf(" %2d", dp[x][3]);
//		System.out.println();
//		System.out.println();
		
		if (maxD >= X)
			sb.append(dp[X][0]).append(" ").append(dp[X][1]).append(" ").append(dp[X][2]).append(" ").append(dp[X][3]);
		else
			sb.append("0 0 0 0");
		
		System.out.println(sb);
	}
}