import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[][] visited;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// 미로 상 하 좌 우
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for (int n = 0; n < N; n++) {
			String[] strs = br.readLine().split("");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(strs[m]);
			}
		}
		
		visited[0][0] = 1;
		bfs(0, 0, 0);
		
		System.out.println(min);
		min = Integer.MAX_VALUE;
	}
	
	static void bfs(int y, int x, int count) {
		Queue<int[]> Q = new PriorityQueue<>((int[] a, int[] b) -> {
			return a[2] - b[2];
		});
		
		visited[y][x] = 1;
		Q.add(new int[] {y, x, count});
		
		while(!Q.isEmpty()) {
			int[] curr = Q.poll();
			
			if (curr[0] == N - 1 && curr[1] == M - 1) {
				min = Math.min(min, curr[2]);
				return;
			}
			
			for (int i = 0; i < 4; i++) {				
				int ny = curr[0] + dy[i];
				int nx = curr[1] + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
					continue;
				}
				
				if (visited[ny][nx] == 0) {
					visited[ny][nx] = 1;
					if (map[ny][nx] == 0) {
						Q.add(new int[] {ny, nx, curr[2]});
					} else {
						Q.add(new int[] {ny, nx, curr[2] + 1});
					}
				}
			}
		}
	}

}
