import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] dy = {0,0,1,-1};
		int[] dx = {1,-1,0,0};
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			int[][] distance = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for(int j=0;j<N;j++) {
					arr[i][j] = Character.getNumericValue(str.charAt(j));
				}
			}
			
			pq.offer(new int[] {0,0,0});
			
			while(!pq.isEmpty()) {
				int[] tmp = pq.poll();
				int y = tmp[1];
				int x = tmp[2];
				if(!visited[y][x]) {
					visited[y][x] = true;
					for(int k=0;k<4;k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];
						if(0<=ny && ny<N &&0<=nx && nx<N && !visited[ny][nx] && tmp[0] + arr[ny][nx] < distance[ny][nx]) {
							distance[ny][nx] = tmp[0] + arr[ny][nx];
							pq.offer(new int[] {distance[ny][nx],ny,nx});
							
						}
					}
				
				}
			}
			sb.append("#").append(tc).append(" ").append(distance[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
