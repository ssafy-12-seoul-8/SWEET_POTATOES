import java.io.*;
	
public class Main {
	
	static int n;
	static int[][] video;
	static StringBuilder sb = new StringBuilder();
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		video = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < n; j++) {
				video[i][j] = line.charAt(j) - '0';
			}
		}
		
		backtrack(0, n, 0, n);
		System.out.println(sb);
	}
	
	static void backtrack(int rowFrom, int rowTo, int colFrom, int colTo) {
		if (check(rowFrom, rowTo, colFrom, colTo)) {
			sb.append(video[rowFrom][colFrom]);
			
			return;
		}
		
		sb.append("(");
		
		int rowLimit = (rowFrom + rowTo) / 2;
		int colLimit = (colFrom + colTo) / 2;
		
		backtrack(rowFrom, rowLimit, colFrom, colLimit);
		backtrack(rowFrom, rowLimit, colLimit, colTo);
		backtrack(rowLimit, rowTo, colFrom, colLimit);
		backtrack(rowLimit, rowTo, colLimit, colTo);
		
		sb.append(")");
	}
	
	static boolean check(int rowFrom, int rowTo, int colFrom, int colTo) {
		int color = video[rowFrom][colFrom];
		
		for (int i = rowFrom; i < rowTo; i++) {
			for (int j = colFrom; j < colTo; j++) {
				if (color != video[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
