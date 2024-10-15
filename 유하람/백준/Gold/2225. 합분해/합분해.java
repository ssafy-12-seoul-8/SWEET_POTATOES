import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N 까지의 정수
		// 1 <= N <= 200
		int N = Integer.parseInt(st.nextToken());
		
		// 정수 K 개
		int K = Integer.parseInt(st.nextToken());
		
		int mod = 1000000000;
		
		long answer = 1;
		
		long[][] DP = new long[K+1][N+1];
		
		for(int i=0 ; i<=N ; i++) {
			// 1개 뽑는 경우들
			DP[1][i] = 1;
		}
		
		for(int i=2 ; i<=K ; i++) {
			for(int j=0 ; j<=N ; j++) {
				for(int k=0 ; k<=j ; k++) {
					DP[i][j] += DP[i-1][k];
				}
				DP[i][j] %= mod;
			}
		}
		
//		System.out.println("DP 확인");
//		for(int[] i : DP) {
//			System.out.println(Arrays.toString(i));
//		}
		
		System.out.println(DP[K][N]);

	} // main

} // Main class

/*
 * 	i 까지의 정수 중에서
 *  j 개를 더해서 그 합이 i가 되는 경우
 *  
 *  => j-1개를 더해서 그 합이 i가 되는경우
 *     j-1개를 더해서 그 합이 i-1가 되는 경우
 *     j-1개를 더해서 그 합이 i-2가 되는 경우
 *     ...
 *     j-1개를 더해서 그 합이 0이 되는 경우
 *  
 *  => j-2개를 더해서 
 * 
 * 
 */


