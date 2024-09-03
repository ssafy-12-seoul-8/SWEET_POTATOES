import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int max_count;
	static int[][] arr;
	static int[][] arr2;
	static int N;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			max_count = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int time=0;time<=100;time++) {
				int count = 0;
				arr2 = new int[N][N];
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[i][j]>time) {
							arr2[i][j] = 1;
						}
					}
				}
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr2[i][j]==1) {
							count+=1;
							bfs(i,j);
						}
					}
				}
				if(max_count<count) {
					max_count = count;
				}
			}
			sb.append("#").append(tc).append(" ").append(max_count).append("\n");
		}
		System.out.println(sb);
	}
	static void bfs(int y,int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y,x});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int t_y = tmp[0];
			int t_x = tmp[1];
			if(arr2[t_y][t_x]==1) {
				arr2[t_y][t_x]=0;
				for(int k=0;k<4;k++) {
					int ny = t_y +dy[k];
					int nx = t_x +dx[k];
					if(0<=nx && nx<N && 0<=ny && ny<N && arr2[ny][nx]==1) {
						queue.add(new int[] {ny,nx});
					}
				}
			}
		}
	}
}
