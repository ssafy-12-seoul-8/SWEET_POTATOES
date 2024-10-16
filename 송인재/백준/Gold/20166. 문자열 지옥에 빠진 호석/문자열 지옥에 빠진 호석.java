import java.io.*;
import java.util.*;
	
public class Main {
	
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int n, m;
	static char[][] world;
	static Map<String, int[][]> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		world = new char[n][m];
		map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			world[i] = br.readLine()
					.toCharArray();
		}
		
		map.put("", new int[n][m]);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < k; i++) {
			String word = br.readLine();
			
			sb.append(countPossible("", word.substring(0, 1), word))
				.append("\n");
		}
		
		System.out.print(sb);
	}
	
	static int countPossible(String prev, String word, String target) {
		if (prev.isEmpty()) {
			map.put(word, init(word.charAt(0)));
		}
		
		if (!map.containsKey(word)) {
			map.put(word, increment(word.charAt(word.length() - 1), map.get(prev)));
		}
		
		if (word.equals(target)) {
			return count(map.get(target));
		}
		
		return countPossible(word, word + target.charAt(word.length()), target);
	}
	
	static int[][] init(char ch) {
		int[][] dp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (world[i][j] == ch) {
					dp[i][j] = 1;
				}
			}
		}
		
		return dp;
	}
	
	static int[][] increment(char ch, int[][] dp) {
		int[][] incremented = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (world[i][j] != ch) {
					continue;
				}
				
				for (int k = 0; k < 8; k++) {
					int row = (i + dr[k] + n) % n;
					int col = (j + dc[k] + m) % m;
					incremented[i][j] += dp[row][col];
				}
			}
		}
		
		return incremented;
	}
	
	static int count(int[][] dp) {
		int count = 0;
		
		for (int[] d : dp) {
			for (int num : d) {
				count += num;
			}
		}
		
		return count;
	}
	
}
