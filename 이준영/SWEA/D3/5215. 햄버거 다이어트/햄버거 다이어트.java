import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int max_k=0;
	static int L;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			max_k=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			int[][] dp = new int[N+1][L+1];
			int[][] arr = new int[N+1][2];
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<L+1;j++) {
					if(j>=arr[i][1]) {
						dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-arr[i][1]]+arr[i][0]);
					} else {
						dp[i][j]=dp[i-1][j];
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[N][L]).append("\n");
			
		}
		System.out.println(sb);
	}
}
