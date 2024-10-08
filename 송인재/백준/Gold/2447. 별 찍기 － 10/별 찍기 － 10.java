import java.io.*;
	
public class Main {
	
	static char[][] stars;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stars = new char[n][n];
		
		recursive(0, 0, n / 3, false);
		
		StringBuilder sb = new StringBuilder();
		
		for (char[] s : stars) {
			for (int i = 0; i < s.length; i++) {
				sb.append(s[i] == '*' ? '*' : ' ');
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void recursive(int row, int col, int depth, boolean isBlank) {
		if (isBlank) {
			for (int i = row; i < row + depth; i++) {
				for (int j = col; j < col + depth; j++) {
					stars[i][j] = ' ';
				}
			}
			
			return;
		}
		
		if (depth == 0) {
			stars[row][col] = '*';
			
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			int newRow = i / 3 * depth + row;
			int newCol = i % 3 * depth + col;
			
			recursive(newRow, newCol, depth / 3, i == 4);
		}
	}
	
}


