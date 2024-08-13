import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		int[] dx1 = {1,0,-1,0};
		int[] dy1 = {0,1,0,-1};
		int[] dx2 = {1,1,-1,-1};
		int[] dy2 = {1,-1,1,-1};
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int max=0;
			int[][] arr = new int[N][N];
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					int count1=arr[i][j];
					int count2=arr[i][j];
					for(int k=1;k<M;k++) {
						for(int l=0;l<4;l++) {
							int ny = i+dy1[l]*k;
							int nx = j+dx1[l]*k;
							if (0<=ny && ny<N && 0<=nx && nx<N)
								count1+=arr[ny][nx];
						}
					}
					for(int k=1;k<M;k++) {
						for(int l=0;l<4;l++) {
							int ny = i+dy2[l]*k;
							int nx = j+dx2[l]*k;
							if (0<=ny && ny<N && 0<=nx && nx<N)
								count2+=arr[ny][nx];
						}
					}
					if (max<count1)
						max=count1;
					if (max<count2)
						max=count2;
						
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			
		}
		System.out.println(sb);
	}
}
