import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static boolean[][] garo, sero, nemo;
	static int[][] map;
	static boolean checked = false;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		garo = new boolean[9][10];	// r
		sero = new boolean[9][10];	// c
		nemo = new boolean[9][10];	// 3 * (r/3) + (c/3)

		map = new int[9][9];
		for (int r = 0; r < 9; r++) {
			
			String line = br.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = line.charAt(c) - '0';
				
				if (map[r][c] != 0) {
					
					garo[r][map[r][c]] = true;
					sero[c][map[r][c]] = true;
					nemo[3 * (r/3) + (c/3)][map[r][c]] = true;
				}
			}
		}
		
		btk(0, 0);
		
		System.out.println(sb);
	}
	
	static void btk(int r, int c) {
		
		if (checked)
			return;
		
		if (c == 9) {
			r++;
			c = 0;
		}
		
		if (r == 9) {
			
			for (int rr = 0; rr < 9; rr++) {
				for (int cc = 0; cc < 9; cc++)
					sb.append(map[rr][cc]);
				sb.append("\n");
			}
			
			checked = true;
			return;
		}
		
		if (map[r][c] == 0) {
			
			for (int num = 1; num <= 9; num++) {
				
				if (garo[r][num] || sero[c][num] || nemo[3 * (r/3) + (c/3)][num])
					continue;
				
				map[r][c] = num;
				garo[r][num] = true;
				sero[c][num] = true;
				nemo[3 * (r/3) + (c/3)][num] = true;
				
//				System.out.println(r + " | " + c + " | " + num);
				
				btk(r, c + 1);
				
				map[r][c] = 0;
				garo[r][num] = false;
				sero[c][num] = false;
				nemo[3 * (r/3) + (c/3)][num] = false;
			}
		} else {
			btk(r, c + 1);
		}
	}
}