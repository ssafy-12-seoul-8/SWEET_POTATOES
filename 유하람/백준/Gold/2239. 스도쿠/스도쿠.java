import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] board;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 보드
		board = new int[9][9];
		
		for(int i=0 ; i<9 ; i++) {
			String row = br.readLine();
			for(int j=0 ; j<9 ; j++) {
				board[i][j] = Character.getNumericValue(row.charAt(j));
			}
		}
		
		btk(0);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<9 ; i++) {
			for(int j=0 ; j<9 ; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}	// main

	private static boolean btk(int i) {
		if(i>=81) return true;

		int r = i/9;
		int c = i%9;
		
		if(board[r][c]!=0) return btk(i+1);
		
		for(int n=1 ; n<=9 ; n++) {
			if (check(r,c,n)) {
				board[r][c] = n;
				if(btk(i+1)) return true;
				board[r][c] = 0;
			}
		}
		
		return false;
	}

	private static boolean check(int r, int c, int n) {
		// 행 검사
		for(int j=0 ; j<9 ; j++) {
			if(board[r][j]==n) return false;
		}
		
		// 열 검사
		for(int i=0 ; i<9 ; i++) {
			if(board[i][c]==n) return false;
		}
		
		// 3*3 검사
		for(int i=(r/3)*3 ; i<(r/3+1)*3 ; i++) {
			for(int j=(c/3)*3 ; j<(c/3+1)*3 ; j++) {
				if(board[i][j]==n) return false;
			}
		}
		
		
		return true;
	}

}	// Main class
