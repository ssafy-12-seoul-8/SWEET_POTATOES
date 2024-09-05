import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static long[] dp;
	static int N;
	static int[] check;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			dp = new long[1<<N];
			check = new int[N];
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				check[b-1] = check[b-1]|(1<<(a-1));
			}
			
			sb.append("#").append(tc).append(" ").append(race(0)).append("\n");		
		}
		System.out.println(sb);
	}
	static long race(int cur) {
		
		if(dp[cur]!=0)
			return dp[cur];
		if((cur&((1<<N)-1))==(1<<N)-1) {
			dp[cur] = 1;
			return 1;
		}
		
		for(int i=0;i<N;i++) {
			if((cur&(1<<i))==0 && (cur&check[i])==check[i]){
				dp[cur] += race(cur|(1<<i));
			}
		}
		return dp[cur];	
	}
}
