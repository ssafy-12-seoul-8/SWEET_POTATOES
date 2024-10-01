import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
		int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] water = new int[N][N];
		int[][] cloud = new int[N][N]; // -1은 생성불가, 0은 생성가능, 1은 구름있음

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				water[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cloud[N - 1][0] = 1;
		cloud[N - 1][1] = 1;
		cloud[N - 2][0] = 1;
		cloud[N - 2][1] = 1;

		for (int l = 0; l < M; l++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			ArrayList<int[]> cloud_loc = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cloud[i][j] == 1) {
						int tmp_y = (i + (dy[d] * (s % N)) + N) % N;
						int tmp_x = (j + (dx[d] * (s % N)) + N) % N;
						cloud_loc.add(new int[] { tmp_y, tmp_x });
						water[tmp_y][tmp_x] += 1;
					}
					cloud[i][j] = 0;
				}
			}
			
			ArrayList<int[]> tmp_water = new ArrayList<>();
			for (int[] tmp : cloud_loc) {

				int tmp_y = tmp[0];
				int tmp_x = tmp[1];
				int count = 0;

				cloud[tmp_y][tmp_x] = -1;

				for (int k = 1; k <= 4; k++) {
					int ny = tmp_y + dy[2 * k];
					int nx = tmp_x + dx[2 * k];
					if (0 <= nx && nx < N && 0 <= ny && ny < N && water[ny][nx] > 0) {
						count += 1;
					}
				}
				tmp_water.add(new int[] {tmp_y,tmp_x,count});
			}

			for(int[] tmp:tmp_water) {
				water[tmp[0]][tmp[1]]+=tmp[2];
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (water[i][j] >= 2 && cloud[i][j] == 0) {
						water[i][j] -= 2;
						cloud[i][j] = 1;
					}
				}
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(water[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(cloud[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();

		}
		int water_sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				water_sum += water[i][j];
			}
		}
		System.out.println(water_sum);

	}

}
