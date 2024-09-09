import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] paper;
	static boolean[][] visited;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				paper[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				visited[y][x] = true;
				dfs(y, x, paper[y][x], 1);
				visited[y][x] = false;
			}
		}
		
		System.out.println(max);
		
	}
	
	static void dfs(int y, int x, int sum, int count) {
		if (count == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
				continue;
			}
			
			if (!visited[ny][nx]) {
				if (count == 2) {
					visited[ny][nx] = true;
					dfs(y, x, sum + paper[ny][nx], count + 1);
					visited[ny][nx] = false;
				}
				
				visited[ny][nx] = true;
				dfs(ny, nx, sum + paper[ny][nx], count + 1);
				visited[ny][nx] = false;
			}
		}
	}

}
