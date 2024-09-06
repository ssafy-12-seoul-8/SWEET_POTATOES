import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		Set<Integer>[] direction = new HashSet[8];
		direction[1] = new HashSet<>(Arrays.asList(0, 1, 2, 3));
		direction[2] = new HashSet<>(Arrays.asList(0, 1));
		direction[3] = new HashSet<>(Arrays.asList(2, 3));
		direction[4] = new HashSet<>(Arrays.asList(1, 2));
		direction[5] = new HashSet<>(Arrays.asList(0, 2));
		direction[6] = new HashSet<>(Arrays.asList(0, 3));
		direction[7] = new HashSet<>(Arrays.asList(1, 3));
		
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int count = 1;
			boolean[][] visited = new boolean[N][M];
			int[][] arr = new int[N][M];	
			visited[R][C] = true;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {R,C});
			
			while(L>1 && !queue.isEmpty()) {
				Queue<int[]> queue2 = new LinkedList<>();
				for(int[] tmp:queue) {
					int y = tmp[0];
					int x = tmp[1];
					for(int i:direction[arr[y][x]]) {
						int ny = y - dy[i];
						int nx = x - dx[i];
						if(0<=nx && nx<M && 0<=ny && ny<N && !visited[ny][nx]&& arr[ny][nx]!=0 && direction[arr[ny][nx]].contains(change_direction(-dy[i],-dx[i]))) {
							visited[ny][nx] = true;
							queue2.add(new int[] {ny,nx});
//							System.out.println(ny+" "+nx);
							count+=1;
						}
					}
				}
				queue = queue2;
//				System.out.println();
				L=L-1;
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
		
	}
	static int change_direction(int y, int x) {
		if(x==0) {
			if(y==-1) {
				return 0;
			} else {
				return 1;
			}
		} else if(x==1) {
			return 3;
		} else {
			return 2;
		}
	}
}
