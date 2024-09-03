import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	
	static char[][] map;
	static int n, m, min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		min = -1;
		int[] red = null;
		int[] blue = null;
		
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine()
					.toCharArray();

			if (red != null && blue != null) {
				continue;
			}
			
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'R') {
					red = new int[] { i, j };
				}
				
				if (map[i][j] == 'B') {
					blue = new int[] { i, j };
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			conductTrial(0, i, red, blue);
		}
		
		System.out.println(min);
	}
	
	static void conductTrial(int count, int direction, int[] red, int[] blue) {
		if (count == 10) {
			return;
		}
		
		int[] result = roll(direction, red, blue);
		
		if (result[4] != 0) {
			if (result[4] == 1) {
				if (min == -1) {
					min = Integer.MAX_VALUE;
				}
				
				min = Math.min(min, count + 1);
			}
			
			return;
		}
		
		int[] newRed = new int[] { result[0], result[1] };
		int[] newBlue = new int[] { result[2], result[3] };
		
		for (int i = 0; i < 4; i++) {
			if (i % 2 == direction % 2) {
				continue;
			}
			
			conductTrial(count + 1, i, newRed, newBlue);
		}
	}
	
	static int[] roll(int direction, int[] red, int[] blue) {
		int[] result = new int[5];
		int[] redResult = null;
		int[] blueResult = null;
		
		if (isRedFirst(red, blue, direction)) {
			redResult = rollBead(red, blue[0], blue[1], direction);
			blueResult = rollBead(blue, redResult[0], redResult[1], direction);
		} else {
			blueResult = rollBead(blue, red[0], red[1], direction);
			redResult = rollBead(red, blueResult[0], blueResult[1], direction);
		}
		
		if (redResult[2] == 1) {
			result[4] = 1;
		}
		
		if (blueResult[2] == 1) {
			result[4] = 2;
		}
		
		result[0] = redResult[0];
		result[1] = redResult[1];
		result[2] = blueResult[0];
		result[3] = blueResult[1];
		
		return result;
	}
	
	static int[] rollBead(int[] bead, int anotherRow, int anotherCol, int direction) {
		int row = bead[0] + dr[direction];
		int col = bead[1] + dc[direction];
		
		while (map[row][col] != '#' && map[row][col] != 'O' && (row != anotherRow || col != anotherCol)) {
			row += dr[direction];
			col += dc[direction];
		}
		
		if (map[row][col] == 'O') {
			return new int[] { row, col, 1 };
		}
		
		return new int[] { row - dr[direction], col - dc[direction], 0 };
	}
	
	static boolean isRedFirst(int[] red, int[] blue, int direction) {
		switch (direction) {
		case 0:
			return red[0] < blue[0];
		case 1:
			return red[1] > blue[1];
		case 2:
			return red[0] > blue[0];
		case 3:
			return red[1] < blue[1];
		}
		
		return false;
	}
}
