import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			room[r] = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		// 반시계 방향
		// 북 동 남 서
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int answer = 0;
		
		while(true) {
			
			// 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if (room[x][y] == 0) {
				room[x][y] = 2;
				answer++;
			}
			
			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			if ((room[x + dx[0]][y + dy[0]] != 0) &&
				(room[x + dx[1]][y + dy[1]] != 0) &&
				(room[x + dx[2]][y + dy[2]] != 0) &&
				(room[x + dx[3]][y + dy[3]] != 0) 
			) {
				int nx = x - dx[d];
				int ny = y - dy[d];
				
				// 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진
				if (room[nx][ny] != 1) {
					x = nx;
					y = ny;
				} else {
					System.out.println(answer);
					return;
				}
			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
			} else {
				// 반시계 방향으로 90도 회전한다.
				d = d - 1;
				
				if (d < 0) {
					d = 3;
				}
				
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
				if (room[nx][ny] == 0) {
					x = nx;
					y = ny;
				}
			}
		}

	}

}
