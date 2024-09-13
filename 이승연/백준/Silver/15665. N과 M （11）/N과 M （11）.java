import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	
	static int[] data;
	
	static Set<String> set = new LinkedHashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(data);
		
		dfs(0, "");
		
		for (String s : set) {
			sb.append(s + "\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int depth, String result) {
		if (depth == M) {
			set.add(result);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			dfs(depth + 1, result + data[i] + " ");
		}
	}
}
