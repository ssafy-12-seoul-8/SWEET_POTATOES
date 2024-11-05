import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M, N1, N2, W;
	static int[][] adj;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (i != j)
					adj[i][j] = 1_000_000_000;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			N1 = Integer.parseInt(st.nextToken()) - 1;
			N2 = Integer.parseInt(st.nextToken()) - 1;
			W = Integer.parseInt(st.nextToken());
			
			adj[N1][N2] = Math.min(adj[N1][N2], W);
		}
		
		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
		
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(adj[i][j] != 1_000_000_000 ? adj[i][j] : 0).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}