
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N;
	static int[][] map;
	static int cnt;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		N = Integer.parseInt(n);
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0 ; i<N ; i++) {
			String row = br.readLine();
			for(int j=0 ; j<N ; j++) {
				map[i][j] = row.charAt(j)-'0';
			}
		}
		
		cnt = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(map[i][j]>0 && !visited[i][j]) {
					cnt++;
					visited[i][j] = true;
					dfs(i,j);
				}
			}
		}
		
		int[] count = new int[cnt+1];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				count[map[i][j]]++;
			}
		}
		
		count[0] = 0;
		Arrays.sort(count);
		
		System.out.println(cnt);
		for(int i=1 ; i<=cnt ; i++) {
			System.out.println(count[i]);
		}

	}

	private static void dfs(int r, int c) {
		map[r][c] = cnt;
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]>0) {
				visited[nr][nc] = true;
				dfs(nr,nc);
			}
			
		}
		
	}


}
