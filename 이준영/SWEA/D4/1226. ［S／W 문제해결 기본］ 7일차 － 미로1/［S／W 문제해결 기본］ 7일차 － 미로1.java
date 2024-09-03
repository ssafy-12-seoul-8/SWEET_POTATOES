import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		for(int tc=1; tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			int t_c = Integer.parseInt(st.nextToken());
			arr = new int[16][16];
			int start_y = 0;
			int start_x = 0;
			int end_y = 0;
			int end_x = 0;
			for(int i=0;i<16;i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for(int j=0;j<16;j++) {
					arr[i][j] = Character.getNumericValue(str.charAt(j));
					if(arr[i][j]==2) {
						start_y = i;
						start_x = j;
						arr[i][j] = 0;
					} else if(arr[i][j]==3) {
						end_y = i;
						end_x = j;
						arr[i][j] = 0;
					}
				}
			}
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {start_y,start_x});
			int ans = 0;
			while(!queue.isEmpty()) {
				int[] tmp = queue.poll();
				int y = tmp[0];
				int x = tmp[1];
				if(y==end_y && x==end_x) {
					ans =1;
					break;
				}
				if(arr[y][x]==0) {
					arr[y][x] = 1;
					for(int k=0;k<4;k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];
						if(arr[ny][nx]==0) {
							queue.add(new int[] {ny,nx});
						}
					}
				}
			}
			sb.append("#").append(t_c).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
