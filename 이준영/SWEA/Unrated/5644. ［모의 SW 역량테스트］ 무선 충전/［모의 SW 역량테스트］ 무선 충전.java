import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		int[] dx = {0,0,1,0,-1};
		int[] dy = {0,-1,0,1,0};
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int count=0;
			int[] move_a = new int[M+1];
			int[] move_b = new int[M+1];
			int a_x=1;
			int a_y=1;
			int b_x=10;
			int b_y=10;
			int[][] BC = new int[A][4];
			ArrayList<Integer[]>[][] arr = new ArrayList[11][11];
			for (int i=0;i<11;i++) {
				for (int j=0;j<11;j++) {
					arr[i][j] = new ArrayList<Integer[]>();
				}
			}
			st = new StringTokenizer(br.readLine());
			for (int i=1;i<M+1;i++) {
				move_a[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i=1;i<M+1;i++) {
				move_b[i]=Integer.parseInt(st.nextToken());
			}
			for (int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][0] = Integer.parseInt(st.nextToken());
				BC[i][1] = Integer.parseInt(st.nextToken());
				BC[i][2] = Integer.parseInt(st.nextToken());
				BC[i][3] = Integer.parseInt(st.nextToken());
			}
			for (int i=1;i<11;i++) {
				for(int j=1;j<11;j++) {
					for(int k=0;k<A;k++) {
						if(Math.abs(BC[k][0]-i)+Math.abs(BC[k][1]-j)<=BC[k][2]) {
							Integer[] v = {BC[k][3],20*BC[k][0]+BC[k][1]};
							arr[i][j].add(v);
						}
						while(arr[i][j].size()<2) {
							Integer[] v= {0,10*i+j};
							arr[i][j].add(v);
						}
						
					}
					Collections.sort(arr[i][j], (a,b) -> b[0]-a[0]);
				}
			}
			int result=0;
			for(int i=0;i<M+1;i++) {
				a_x=a_x+dx[move_a[i]];
				a_y=a_y+dy[move_a[i]];
				b_x=b_x+dx[move_b[i]];
				b_y=b_y+dy[move_b[i]];
				if (!arr[a_x][a_y].get(0)[1].equals(arr[b_x][b_y].get(0)[1])) {
					result=(arr[a_x][a_y].get(0)[0]+arr[b_x][b_y].get(0)[0]);
					count+=result;
				} else {
					result=arr[a_x][a_y].get(0)[0]+Math.max(arr[b_x][b_y].get(1)[0],arr[a_x][a_y].get(1)[0]);
					count+=result;
				}
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
			
		}
		System.out.println(sb);
	}
}
