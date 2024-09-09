import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int y = 0;
		int x = 0;
		int time = 0;
		int size = 2;
		int count = 0;
		int[] dy = { -1, 0, 0, 1 };
		int[] dx = { 0, -1, 1, 0 };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					y = i;
					x = j;
					arr[i][j] = 0;
				}
			}
		}

		while (true) {
			ArrayList<int[]> lst = new ArrayList<>();
			boolean[][] visited = new boolean[N][N];
			lst.add(new int[] { y, x, 0 });
			visited[y][x] = true;
			boolean check = false;
			while (true) {
				ArrayList<int[]> lst2 = new ArrayList<>();
				ArrayList<int[]> lst3 = new ArrayList<>();
				for (int[] tmp : lst) {
					int t_y = tmp[0];
					int t_x = tmp[1];
					
					for (int k = 0; k < 4; k++) {
						int ny = t_y + dy[k];
						int nx = t_x + dx[k];
						if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[ny][nx]) {
							visited[ny][nx] = true;
							if (arr[ny][nx] == 0 || arr[ny][nx] == size) {
								lst2.add(new int[] { ny, nx, tmp[2] + 1 });
							} else if (arr[ny][nx] < size) {
								lst3.add(new int[] { ny, nx, tmp[2] + 1 });
							}
						}
					}
				}
				if (!lst3.isEmpty()) {
					Collections.sort(lst3, (a, b) -> ((a[0] - b[0]) * 20 + a[1] - b[1]));
					int[] tmp = lst3.get(0);
					time = time + tmp[2];
					y = tmp[0];
					x = tmp[1];
					count+=1;
					arr[y][x] = 0;
					if(count==size) {
						size+=1;
						count=0;
					}
					break;
				} else if(!lst2.isEmpty()){
					lst = lst2;
				} else {
					check = true;
					break;
				}
			}
			if(check) {
				break;
			}
		}
		System.out.println(time);

	}
}
