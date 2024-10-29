import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 물품의 수 N (1 <= N <= 100)
		int N = Integer.parseInt(st.nextToken());
		
		// 버틸 수 있는 무게 K (1 <= k <= 10000)
		int K = Integer.parseInt(st.nextToken());
		
		// 물건의 무게, 가치
		int[][] stuff = new int[N+1][2];
		
		for(int i=1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(st.nextToken());
			stuff[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] DP = new int[N+1][K+1];
		
		for(int i=1 ; i<=N ; i++) {
			// i 번째 물건을 
			for(int j=1 ; j<=K ; j++) {
				// j 크기의 가방에 담을 때
				
				if(stuff[i][0]>j) {
					DP[i][j] = DP[i-1][j];
					continue;
				}

				DP[i][j] = Math.max(DP[i-1][j-stuff[i][0]]+stuff[i][1], DP[i-1][j]);
			}
		}
		
		System.out.println(DP[N][K]);
		
		
		
		
	}

}
