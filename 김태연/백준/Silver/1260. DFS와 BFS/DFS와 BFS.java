import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,V;
	static int[][] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = 1;
			
			
		}

		dfs(V);
		// 초기화
		visit = new boolean[N+1];
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
		
		
	}
	
	public static void dfs(int node) {
		
		visit[node] = true;
		sb.append(node).append(" ");
		
		for (int i=1; i<= N; i++) {
			if (!visit[i] && arr[node][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int node) {
		queue.add(node);
		visit[node] = true;
		
		sb.append(node).append(" ");
		
		while (!queue.isEmpty()) {
			int index = queue.poll();
			
			for (int i=1; i<= N; i++) {
				if (!visit[i] && arr[index][i] == 1) {
					queue.add(i);
					visit[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
		
	}
}
