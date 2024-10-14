import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pos {
	int y;
	int x;
	
	Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

// 모든 로직을 순차적으로 진행하지 않고 한꺼번에 처리하려고 했을 때 에러 발생
// 주의할 것

public class Main {

	static int N;
	static int M;
	
	static int[][] SKY;
	
	static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	
	// array -> arrayList
	static List<Pos> groom = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		SKY = new int[N][N];
		groom.add(new Pos(N - 2, 0));
		groom.add(new Pos(N - 2, 1));
		groom.add(new Pos(N - 1, 0));
		groom.add(new Pos(N - 1, 1));
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				SKY[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			// d 방향으로 s 칸 이동
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int[] add = new int[groom.size()];
			
			// 구름 자리 + 1
			for (int i = 0; i < groom.size(); i++) {
				// 처음과 끝이 연결된 배열에서 d방향으로 s번 이동한 위치
				int groomY = ((groom.get(i).y + (dy[d] * s)) % N + N) % N;
				int groomX = ((groom.get(i).x + (dx[d] * s)) % N + N) % N;
				groom.set(i, new Pos(groomY, groomX));
				
				SKY[groomY][groomX] += 1;

			}
			
			// 대각선 check
			for (int i = 0, idx = 0; i < groom.size(); i++) {
				int count = 0;
				
				for (int j = 2; j < dy.length; j += 2) {
					int ny = groom.get(i).y + dy[j];
					int nx = groom.get(i).x + dx[j];
					
					if (ny >= 0 && ny < N && nx >= 0 && nx < N && SKY[ny][nx] > 0) {
						count++;
					}
				}
				
				add[idx++] = count;
			}
			
			
			for (int i = 0; i < groom.size(); i++) {
				SKY[groom.get(i).y][groom.get(i).x] += add[i];
			}
			
			int[][] tmp = new int[groom.size()][2];
			
			for (int i = 0, idx = 0; i < groom.size(); i++) {
				tmp[idx++] = new int[] {groom.get(i).y, groom.get(i).x};
			}
			
			groom = new ArrayList<>();
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					boolean pass = true;
					
					for (int k = 0; k < tmp.length; k++) {
						if (tmp[k][0] == y && tmp[k][1] == x) {
							pass = false;
							break;
						}
					}
					
					if (pass && SKY[y][x] >= 2) {
						groom.add(new Pos(y, x));
						SKY[y][x] -= 2;
					}
				}
			}
			
		}
		
		long result = 0;
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				result += SKY[y][x];
			}
		}
		
		System.out.println(result);
	
	}

}
