import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 백트래킹 + 조합

public class Main {

	static int N, M;
	static int[][] road;
	static List<Point> house = new ArrayList<>();
	static List<Point> chicken = new ArrayList<>();
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N * N 
		// 빈 칸 / 치킨집 / 집
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		road = new int[N][N];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int l = 0; l < N; l++) {
				int number = Integer.parseInt(st.nextToken());
				
				if (number == 1) {
					house.add(new Point(n, l));
				} else if (number == 2) { 
					chicken.add(new Point(n, l));
				}
				
				road[n][l] = number;
			}
		}
		
		// 조합을 구할 때도 백트래킹을 사용하여 구할 수 있구나
		// 구현 방법 : 반복문 + 백트래킹 
		visited = new boolean[chicken.size()];
		bfs(0, 0);
		// bw.write(result);
		System.out.println(result);
		
		br.close();
		bw.close();
	}
	
	public static void bfs(int count, int idx) {
		if (count == M) {
			// System.out.println(Arrays.toString(visited));
			
			int total = 0;
			
			for (int j = 0; j < house.size(); j++) {
				int min = Integer.MAX_VALUE;
				
				for (int i = 0; i < chicken.size(); i++) {
					if (visited[i] == true) {
						min = Math.min(min, Math.abs(house.get(j).x - chicken.get(i).x) + Math.abs(house.get(j).y - chicken.get(i).y));
					}
				}
				
				total += min;
			}
			
			result = Math.min(result, total);
			return;
		}
		
		for (int i = idx; i < chicken.size(); i++) {
			if (visited[i] == false) {
				visited[i] = true;
				bfs(count + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}
