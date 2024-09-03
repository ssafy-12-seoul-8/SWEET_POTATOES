import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] cheese;
	static int answer;
	static int result;
	static int N;
	static boolean[][] visited;
	
	// 상 우 하 좌
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String n = br.readLine();
			N = Integer.parseInt(n);
			
			cheese = new int[N][N];
			
			for(int i=0 ; i<N ; i++) {
				String row = br.readLine();
				StringTokenizer st = new StringTokenizer(row);
				for(int j=0 ; j<N ; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 1;
			
			for(int day=1 ; day<=100 ; day++) {
				result = 0;
				visited = new boolean[N][N];
				
				for(int r=0 ; r<N ; r++) {
					for(int c=0 ; c<N ; c++) {
						if(cheese[r][c]>day && !visited[r][c]) {
							check(r,c, day);
							result++;
						}
					}
				}
				
				answer = Math.max(answer, result);
			}
			
			System.out.println("#"+tc+" "+answer);
			
			
		}
		
		
		
		
	}


	private static void check(int r, int c, int day) {
		
		Queue<int[]> queue = new LinkedList<>();
		
		int[] tmp = {r,c};
		queue.add(tmp);
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for(int i=0 ; i<4 ; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && cheese[nr][nc]>day) {
					int[] tmp2 = {nr,nc};
					queue.add(tmp2);
					visited[nr][nc] = true;
				}
			}
			
		}
		
		
	}

}
