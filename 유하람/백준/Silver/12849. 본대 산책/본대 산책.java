import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/*
	 *  0 : 정보과학관
	 *  1 : 전산관
	 *  2 : 미래관
	 *  3 : 신양관
	 *  4 : 한경직기념관
	 *  5 : 진리관
	 *  6 : 학생회관
	 *  7 : 형남공학관
	 */
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		// 산책하는 시간
		// 1 <= D <= 100,000
		int D = sc.nextInt();
		
		long mod = 1000000007;
		
		long[][] adjArr = {{0,1,1,0,0,0,0,0},
				{1,0,1,1,0,0,0,0},
				{1,1,0,1,1,0,0,0},
				{0,1,1,0,1,1,0,0},
				{0,0,1,1,0,1,0,1},
				{0,0,0,1,1,0,1,0},
				{0,0,0,0,0,1,0,1},
				{0,0,0,0,1,0,1,0}};
		
		long[][] DP = new long[8][D+1];
		
		// 0초, 정보과학관에 있음
		DP[0][0] = 1;
		 
		
		// t 초에
		for(int t=1 ; t<=D ; t++) {
			// b 번 건물에 도착하는 경우
			for(int b=0 ; b<8 ; b++) {
				for(int x=0 ; x<8 ; x++) {
					if(adjArr[b][x]==1) {
						// 인접한 x 건물에서 온다
						DP[b][t] += DP[x][t-1]%mod;
					}
				}
				DP[b][t] %= mod;
			}
		}
		
		
		System.out.println(DP[0][D]);
		
	} // main
	




} // Main class