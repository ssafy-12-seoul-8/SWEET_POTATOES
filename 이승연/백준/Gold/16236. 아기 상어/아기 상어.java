import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] sea;
	static int[][] visited;
	
	static int bsy; // babyShark Position Y
	static int bsx; // babyShark Position x
	
	static int bs = 2;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int fish = 0;
	static int time = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		sea = new int[N][N];
		
		bs = 2;
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				sea[y][x] = Integer.parseInt(st.nextToken());
				
				if (sea[y][x] == 9) {
					bsy = y;
					bsx = x;
					sea[y][x] = 0;
				}
			}
		}
		
		int[] target = new int[3];
		
		while(true) {
			visited = new int[N][N];
			target = getTargetPosition();
			
			if (target[0] == Integer.MAX_VALUE && target[1] == Integer.MAX_VALUE) {
				System.out.println(time);
				break;
			}
			
			int y = target[0];
			int x = target[1];
			int d = target[2];
			
			bsy = y;
			bsx = x;
			sea[y][x] = 0;
			fish++;
			time += d;
			
			if (fish == bs) {
				fish = 0;
				bs++;
			}

		}
		
	}
	
	public static int[] getTargetPosition() {
		// 타겟 y 좌표, x 좌표, 거리
		int[] target = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
		
		Queue<int[]> Q = new LinkedList<>();
		
		visited[bsy][bsx] = 1;
		
		// 현재 y 좌표, x 좌표, 거리, visited 배열 
		Q.add(new int[] {bsy, bsx, 0});
		
		while(!Q.isEmpty()) {
			int[] curr = Q.poll();
			
			int y = curr[0];
			int x = curr[1];
			int d = curr[2];
			
			if (sea[y][x] != 0 && sea[y][x] < bs) {
				// 거리 짧으면 업데이트 
				if (d < target[2]) {
					target[0] = y;
					target[1] = x;
					target[2] = d;
				} 
				
				// 거리 같은 경우
				else if (d == target[2]) {
					// 가장 위 선택 
					if (y < target[0]) {
						target[0] = y;
						target[1] = x; 
					} 
					
					// 가장 왼쪽 선택
					else if (y == target[0] && x < target[1]) {
						target[1] = x;
					}
				}
				
			}
			
			if (d + 1 > target[2]) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && sea[ny][nx] <= bs && visited[ny][nx] == 0) {
					visited[ny][nx] = 1;
					Q.add(new int[] {ny, nx, d + 1});
				}
			}
			
		}
		
		return target;
	}

}
