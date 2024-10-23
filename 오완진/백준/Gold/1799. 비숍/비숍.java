import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, maxCntB, maxCntW;
	static int[][] map;
	static boolean[] sumCheck, chaCheck;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		maxCntB = 0;
		maxCntW = 0;
        sumCheck = new boolean[2 * N];
        chaCheck = new boolean[2 * N];
		
		btk(0, 0, 0, true);		// 합 짝수(Black)
		btk(0, 1, 0, false);	// 합 홀수(White)
		
		System.out.println(maxCntB + maxCntW);
	}
	
	static void btk(int rNow, int cNow, int cnt, boolean isBlack) {
		
		if (cNow >= N) {
			rNow++;
			cNow = ((cNow - N) + ((N % 2 == 0) ? 1 : 0)) % 2;
		}
		
//		System.out.println(rNow + " | " + cNow + " | " + cnt);
			
		if (rNow >= N) {
			if (isBlack)
				maxCntB = Math.max(maxCntB, cnt);
			else
				maxCntW = Math.max(maxCntW, cnt);
			return;
		}
		
//		if (map[rNow][cNow] == 1) {
//			
//			int sum = rNow + cNow;
//			int cha = rNow - cNow + N;
//			
//			if (!sumCheck[sum] && !chaCheck[cha]) {
//				
//				sumCheck[sum] = true;
//				chaCheck[cha] = true;
//				// 비숍 놓기 가능 -> 좌표변경 & 놓기/빼기
//				btk(rNow, cNow + 2, cnt + 1, isBlack);
//				sumCheck[sum] = false;
//				chaCheck[cha] = false;
//			} else {
//				// 비숍 놓기 불가능 -> 좌표만변경
//				btk(rNow, cNow + 2, cnt, isBlack);
//			}
//		} else {
//			// 비숍 놓기 불가능 -> 좌표만변경
//			btk(rNow, cNow + 2, cnt, isBlack);
//		}
		
		if (map[rNow][cNow] == 1) {
			
			int sum = rNow + cNow;
			int cha = rNow - cNow + N;
			
			if (!sumCheck[sum] && !chaCheck[cha]) {
				
				sumCheck[sum] = true;
				chaCheck[cha] = true;
				btk(rNow, cNow + 2, cnt + 1, isBlack);
				sumCheck[sum] = false;
				chaCheck[cha] = false;
			}
		}
		
		btk(rNow, cNow + 2, cnt, isBlack);
	}
}