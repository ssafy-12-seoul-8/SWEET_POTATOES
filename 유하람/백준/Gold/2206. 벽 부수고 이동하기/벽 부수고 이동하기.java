import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 행
		int N = Integer.parseInt(st.nextToken());
		// 열
		int M = Integer.parseInt(st.nextToken());
		// 맵 : 1 -> 벽, 0 -> 이동할 수 있는 곳
		int[][] map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j+1] = Character.getNumericValue(row.charAt(j));
			}
		}
		

		// 각 위치까지의 최단 경로 저장할 배열
		int[][][] degree = new int[N + 1][M + 1][2];

		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=M ; j++) {
				degree[i][j][0] = Integer.MAX_VALUE;
				degree[i][j][1] = Integer.MAX_VALUE;
			}
		}
		
		
		// 시작점 : [1, 1, (이동한 칸 수), (벽 부순 수)]
		int[] start = new int[] { 1, 1, 1, 0 };

		// 최단 거리를 꺼 낼 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}

		});

		pq.add(start);

		// 델타 배열
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			if(degree[curr[0]][curr[1]][curr[3]] < curr[2]) continue;

			degree[curr[0]][curr[1]][curr[3]] = curr[2];

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr > 0 && nr <= N && nc > 0 && nc <= M) {
					// 벽 부술 수 있고 부수는 경우
                    if (curr[3] == 0 && map[nr][nc] == 1 && curr[2] + 1 < degree[nr][nc][1]) {
                        degree[nr][nc][1] = curr[2] + 1;
                        pq.add(new int[]{nr, nc, curr[2] + 1, 1});
                    }

                    // 벽 안 부수는 경우
                    if (map[nr][nc] == 0 && curr[2] + 1 < degree[nr][nc][curr[3]]) {
                        degree[nr][nc][curr[3]] = curr[2] + 1;
                        pq.add(new int[]{nr, nc, curr[2] + 1, curr[3]});
                    }
				}
			}

		}
		
		int answer = Math.min(degree[N][M][0], degree[N][M][1]);
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
		

	} // main

}