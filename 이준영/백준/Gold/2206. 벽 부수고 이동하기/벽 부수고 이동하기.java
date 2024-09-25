import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int[][][] dp = new int[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		for(int i = 0 ; i <N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=0;k<2;k++) {
					dp[i][j][k] = 1000002;
				}
			}
		}

		dp[0][0][0] = 1;

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 0 });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int y = tmp[0];
			int x = tmp[1];
			int count = tmp[2];

			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if(0<=nx && nx <M && 0<=ny && ny<N) {
					if(arr[ny][nx]==0) {
						if(dp[y][x][count]+1 < dp[ny][nx][count]) {
							dp[ny][nx][count] = dp[y][x][count]+1;
							queue.add(new int[] {ny,nx,count});
						}
					} else {
						if(count == 0) {
							if(dp[y][x][0]+1 <dp[ny][nx][1]) {
								dp[ny][nx][1] = dp[y][x][0]+1;
								queue.add(new int[] {ny,nx,1});
							}
						}
					}
				}
			}
		}
		int ans = Math.min(dp[N-1][M-1][0], dp[N-1][M-1][1]);
		if(ans==1000002) {
			ans = -1;
		}
		
		System.out.println(ans);
		
	}
}
