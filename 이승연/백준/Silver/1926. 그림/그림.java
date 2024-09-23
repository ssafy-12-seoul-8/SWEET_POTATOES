import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	
	static int[][] map;
	
	// 상 하 좌 우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int count = 0;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				// 아직 방문하지 않은 그림이라면
				if (map[n][m] == 1) {
					Queue<int[]> queue = new LinkedList<>();
					int len = 0;
					
					map[n][m] = 2;
					queue.add(new int[] {n, m});
					
					while(!queue.isEmpty()) {
						int[] curr = queue.poll();
						len++;
						
						for (int i = 0; i < 4; i++) {
							int ny = curr[0] + dy[i];
							int nx = curr[1] + dx[i];
							
							if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 1) {
								map[ny][nx] = 2;
								queue.add(new int[] {ny, nx});
							}
						}
					}
					
					if (max < len) {
						max = len;
					}
					
					count++;
				}
			}
		}
		
		System.out.println(count + "\n" + max);
		
		count = 0;
		max = 0;
	}

}
