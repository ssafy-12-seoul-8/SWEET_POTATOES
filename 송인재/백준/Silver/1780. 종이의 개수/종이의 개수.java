import java.io.*;
import java.util.*;
	
public class Main {
	
	static int[][] colors;
	static int[] count = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		colors = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				colors[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backtrack(0, n, 0, n);
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
	}
	
	static void backtrack(int rowFrom, int rowTo, int colFrom, int colTo) {
		if (check(rowFrom, rowTo, colFrom, colTo)) {
			return;
		}
		
		int rowLimit = (rowTo - rowFrom) / 3;
		int colLimit = (colTo - colFrom) / 3;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				backtrack(rowFrom + rowLimit * i, rowFrom + rowLimit * (i + 1), colFrom + colLimit * j, colFrom + colLimit * (j + 1));
			}
		}
	}
	
	static boolean check(int rowFrom, int rowTo, int colFrom, int colTo) {
		int color = colors[rowFrom][colFrom];
		
		for (int i = rowFrom; i < rowTo; i++) {
			for (int j = colFrom; j < colTo; j++) {
				if (colors[i][j] != color) {
					return false;
				}
			}
		}
		
		count[color + 1]++;
		
		return true;
	}
	
}
