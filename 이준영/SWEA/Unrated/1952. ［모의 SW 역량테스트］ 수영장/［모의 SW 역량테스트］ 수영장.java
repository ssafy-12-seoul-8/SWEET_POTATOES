import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			int[] price = new int[4];
			int[] month_price = new int[12];
			int[][] dp = new int[12][3];   // i+1월에 딱맞춰끝나는 경우/3개월 코스중 가운데 끝나는 경우/이 달에 시작하는 경우
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				price[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<12;i++) {
				int a=Integer.parseInt(st.nextToken());
				month_price[i]=Math.min(price[1],price[0]*a);
			}
			int minimum = price[3];
			dp[0][0]=month_price[0];
			dp[0][1]=10000;
			dp[0][2]=price[2];
			for(int i=1;i<12;i++) {
				dp[i][0]=Math.min(dp[i-1][1],dp[i-1][0]+month_price[i]);
				dp[i][1]=dp[i-1][2];
				dp[i][2]=dp[i-1][0]+price[2];
			}
			minimum=find_min(new int[] {minimum,dp[11][0],dp[11][1],dp[11][2]});
			sb.append("#").append(tc).append(" ").append(minimum).append("\n");
		}
		System.out.println(sb);
	}
	static int find_min(int[] arr) {
		int mini=arr[0];
		for(int i=1;i<arr.length;i++) {
			if (mini>arr[i])
				mini=arr[i];
		}
		return mini;
	}
}
