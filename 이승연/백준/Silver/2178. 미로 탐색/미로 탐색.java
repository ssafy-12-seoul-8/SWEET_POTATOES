import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nums = br.readLine().split(" ");
		int N = Integer.parseInt(nums[0]);
		int M = Integer.parseInt(nums[1]);
		
		int[][] miro = new int[N][M];
		int[][] visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			// StringTokenizer 는 빈문자열을 인식하지 못한다
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				miro[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		// 상 하 좌 우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		// 최종적으로 도달해야하는 위치 {N-1, M-1}
		
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {0, 0, 1});
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			// 현재 위치
			int[] curr = queue.poll();
			// 방문한 곳은 표시
			visited[curr[0]][curr[1]] = 1;
			
			if (curr[0] == N - 1 && curr[1] == M - 1) {
				bw.write(curr[2] + ""); // BufferedWriter 는 String 만 출력
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				
				// 배열 범위를 넘지 않으면서
				// 미로에서 이동 가능한 칸이면서
				// 방문하지 않았던 칸일때만 queue에 넣어주기
				if (0 <= nx && nx < N && 0 <= ny && ny < M && 
					miro[nx][ny] == 1 && visited[nx][ny] == 0
				) {
					queue.add(new int[] {nx, ny, curr[2] + 1});
					visited[nx][ny] = 1;
				}
			}
		}
		
		br.close();
		bw.close();
	}

}
