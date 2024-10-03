import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 돌의 개수 N (1 <= N <= 20)
		int N = Integer.parseInt(br.readLine());
		
		// 작은 점프, 큰점프를 위해 필요한 에너지
		int[][] energy = new int[2][N+1];
		
		for(int i=1 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			energy[0][i] = Integer.parseInt(st.nextToken());
			energy[1][i] = Integer.parseInt(st.nextToken());
		}

		// 매우 큰 점프를 위해 필요한 에너지
		int K = Integer.parseInt(br.readLine());
		
		// i번째 돌에서, 
		// 매우 큰 점프를 했는지 안했는지에 따른
		// 최소 에너지를 저장한 DP 배열
		int[][] DP = new int[2][N+1];
		for(int i=0 ; i<2 ; i++) {
			for(int j=0 ; j<=N ; j++) {
				DP[i][j] = 5000*N;
			}
		}
		
		DP[0][0] = 0;
		
		for(int i=1 ; i<=N ; i++) {
			// 매우 큰 점프를 하는 경우
			if(i>=4) {
				DP[1][i] = Math.min(DP[1][i], DP[0][i-3] + K);
			}
			// 큰 점프를 하는 경우
			if(i>=3) {
				DP[0][i] = Math.min(DP[0][i], DP[0][i-2]+energy[1][i-2]);
				if(DP[1][i-2]!=5000*N) {
					DP[1][i] = Math.min(DP[1][i], DP[1][i-2]+energy[1][i-2]);
				}
			}
			// 작은 점프를 하는 경우
			DP[0][i] = Math.min(DP[0][i], DP[0][i-1]+energy[0][i-1]);
			if(DP[1][i-1]!=5000*N) {
				DP[1][i] = Math.min(DP[1][i], DP[1][i-1]+energy[0][i-1]);
			}
			
		}
		
//		for(int[] d : DP) {
//			System.out.println(Arrays.toString(d));
//		}
		
		System.out.println(Math.min(DP[0][N], DP[1][N]));
		
		
	}	// main

}