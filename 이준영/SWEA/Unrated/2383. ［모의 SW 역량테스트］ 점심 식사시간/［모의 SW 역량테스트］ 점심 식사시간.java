import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			int min_time = Integer.MAX_VALUE;
			
			List<int[]> people = new ArrayList<>();
			List<int[]> stairs = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==1) {
						people.add(new int[] {i,j});
					}
					if(arr[i][j]>=2) {
						stairs.add(new int[] {i,j,arr[i][j]});
					}
					
				}
			}
			
			int len = people.size();
			int[][] distance = new int[len][2];
			for(int i=0;i<len;i++) {
				for(int j=0;j<2;j++) {
					distance[i][j] = Math.abs(people.get(i)[0]-stairs.get(j)[0])+Math.abs(people.get(i)[1]-stairs.get(j)[1]);
				}
			}
			
			for(int i=0;i<(1<<len);i++) {
				
				List<Integer> group1 = new ArrayList<>();
				List<Integer> group2 = new ArrayList<>();
				int time1 = 0;
				int time2 = 0;
				
				for(int j=0;j<len;j++) {
					if((i&(1<<j))==0) {
						group1.add(distance[j][0]);
					} else {
						group2.add(distance[j][1]);
					}
				}
				
				Collections.sort(group1);
				Collections.sort(group2);
				
				if(!group1.isEmpty()) {
					int len1 = group1.size();
					int k = stairs.get(0)[2];
					if(len1<=3) {
						time1 = group1.get(len1-1)+1+k;
					} else {
						int[] dp = new int[len1];
						for(int j=0;j<3;j++) {
							dp[j] = group1.get(j)+1;
						}
						for(int j=3;j<len1;j++) {
							dp[j] = Math.max(group1.get(j)+1,dp[j-3]+k);
						}
						time1 = dp[len1-1]+k;
					}
				}
				if(!group2.isEmpty()) {
					int len2 = group2.size();
					int k = stairs.get(1)[2];
					if(len2<=3) {
						time2 = group2.get(len2-1)+1+k;
					} else {
						int[] dp = new int[len2];
						for(int j=0;j<3;j++) {
							dp[j] = group2.get(j)+1;
						}
						for(int j=3;j<len2;j++) {
							dp[j] = Math.max(group2.get(j)+1,dp[j-3]+k);
						}
						time2 = dp[len2-1]+k;
					}
				}
				int time = Math.max(time1, time2);
				min_time = Math.min(min_time, time);
			}
			sb.append("#").append(tc).append(" ").append(min_time).append("\n");
		}
		System.out.println(sb);
	}
}
