import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
			int mini = 10000000;
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<(1<<N);i++) {
				int sum=0;
				int count=0;
				ArrayList<Integer> arr1 = new ArrayList<>();
				ArrayList<Integer> arr2 = new ArrayList<>();
				for(int j=0;j<N;j++) {
					if((i&(1<<j))==0) {
						arr1.add(j);
						count+=1;
					} else {
						arr2.add(j);
					}
				}
				if(count!=N/2)
					continue;
				for(int k=0;k<N/2;k++) {
					for(int j=0;j<N/2;j++) {
						sum=sum+arr[arr1.get(k)][arr1.get(j)]-arr[arr2.get(k)][arr2.get(j)];
					}
				}
				sum=Math.abs(sum);
				if(mini>sum)
					mini=sum;	
			}
			sb.append("#").append(tc).append(" ").append(mini).append("\n");
		}
		System.out.println(sb);
	}
}
