package 벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] visit;
	// 동 서 남 북
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static int N,M;
	static int[][] map;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			String line =  br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		// 시작 좌표와, 벽 부수는 여부, 카운트를 표기해보자
		result = Integer.MAX_VALUE;
		bfs(0,0, true, 0);
		
		if (result == Integer.MAX_VALUE) result = -1;
		
		System.out.println(result);
	}

	private static void bfs(int row, int column, boolean canBreak, int count) {
		
		// BFS 시작
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, column});
		visit[row][column] = true;

		// 시작 카운트는 0으로.
		while (!queue.isEmpty()) {
			
			int[] current = queue.poll();
			count++;
			// 현재 위치
			int cr = current[0];
			int cc = current[1];
			
			// 목적지(N-1 , M-1) 에 도착하면 종료
			if (cr == N-1 && cc == M-1) {
				result = Math.min(result, count);
			}
			
			// 다음 위치
			for (int dir = 0; dir < 4; dir ++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				
				// 범위 밖이거나, 이미 방문했다면 스킵
				if (!isBoundary(nr,nc) || visit[nr][nc]) continue;

				// 벽을 만났는데 부술 수 있는 경우 + 처음 만난 벽일 경우
				if (map[nr][nc] == 1 && canBreak && !visit[nr][nc]) {

					// 1. 벽을 부순다
					canBreak = false;
					visit[nr][nc] = true;
					
					boolean[][] newVisit = new boolean[N][M];
					for (int i=0; i<N; i++) {
						for (int j=0; j<M; j++) {
							newVisit[i][j] = visit[i][j];
						}
					}
					
					// 벽을 부섰을 경우, (nr,nc) 를 출발으로 해서 도착지까지 bfs를 새로 돌린다.
					// count 를 넘겨준다.
					bfs(nr, nc, canBreak, count);	// (0,0) ~ (nr,nc) , (nr,nc) ~ (목적지) 까지 계산
					
					// 초기화
					// visit 배열을 어떻게 초기화시키지..?
					visit = newVisit;
					canBreak = true;
				}
				
				if (map[nr][nc] == 0) {
					visit[nr][nc] = true;
					queue.add(new int[] {nr,nc});
				}
				
			}
		}
	}

	private static boolean isBoundary(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
}
