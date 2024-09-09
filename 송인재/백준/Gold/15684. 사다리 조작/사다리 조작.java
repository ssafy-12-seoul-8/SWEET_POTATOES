import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, h, min = 4;
	static boolean[][] line;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		line = new boolean[h][n];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			line[a][b] = true;
		}
		
		backtrack(0, 0);
		System.out.println(min == 4 ? -1 : min);
	}
	
	static void backtrack(int depth, int count) {
		if (min == 0 || depth == h * n) {
			return;
		}
		
		if (count >= min) {
			return;
		}
		
		if (simulate()) {
			min = Math.min(min, count);
			
			return;
		}
		
		for (int i = depth; i < h * n; i++) {
			int row = i / n;
			int col = i % n;
			
			if (line[row][col] || col == n - 1) {
				continue;
			} 
			
			if (col > 0 && line[row][col - 1] || line[row][col + 1]) {
				continue;
			} 
			
			line[row][col] = true;
				
			backtrack(i + 1, count + 1);
				
			line[row][col] = false;
		}
	}
	
	static boolean simulate() {
		for (int i = 0; i < n; i++) {
			int current = i;
			
			for (int j = 0; j < h; j++) {
				if (line[j][current]) {
					current++;
				} else if (current > 0 && line[j][current - 1]) {
					current--;
				}
			}
			
			if (current != i) {
				return false;
			}
		}
		
		return true;
	}

}
