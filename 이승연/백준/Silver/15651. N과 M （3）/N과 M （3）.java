import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dfs(0, "");
		
		System.out.println(sb);
	}
	
	static void dfs(int depth, String result) {
		if (depth == M) {
			sb.append(result + "\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			dfs(depth + 1, result + (i + 1) + " ");
		}
	}
}
