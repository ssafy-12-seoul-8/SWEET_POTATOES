import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        testCase:
        for (int tc = 1; tc <= T; tc++) {
        	
        	int[][] sudoku = new int[9][9];
        	for (int r = 0; r < 9; r++) {
        		for (int c = 0; c < 9; c++) {
        			sudoku[r][c] = sc.nextInt();
        		}
        	}
        		
    		// 가로
    		for (int r = 0; r < 9; r++) {
    			if (isRight(sudoku[r]) == false) {
    				System.out.println("#" + tc + " " + 0);
    				continue testCase;
    			}
    		}
    		
    		// 세로
			for (int c = 0; c < 9; c++) {
    			int[] number9 = new int[9];
    			for (int r = 0; r < 9; r++) {
    				number9[r] = sudoku[r][c];
    			}
    			if (isRight(number9) == false) {
    				System.out.println("#" + tc + " " + 0);
    				continue testCase;
    			}
    		}
    		
        	// 3x3
			for (int r = 0; r < 9; r += 3) {
			    for (int c = 0; c < 9; c += 3) {
			        int[] number9 = new int[9];
			        number9[0] = sudoku[r][c];
			        number9[1] = sudoku[r][c+1];
			        number9[2] = sudoku[r][c+2];
			        number9[3] = sudoku[r+1][c];
			        number9[4] = sudoku[r+1][c+1];
			        number9[5] = sudoku[r+1][c+2];
			        number9[6] = sudoku[r+2][c];
			        number9[7] = sudoku[r+2][c+1];
			        number9[8] = sudoku[r+2][c+2];
			        
			        if (isRight(number9) == false) {
			            System.out.println("#" + tc + " " + 0);
	    				continue testCase;
			        }
			    }
			}
        		
            System.out.println("#" + tc + " " + 1);
        }
        
    }
    
    static boolean isRight(int[] number9) {
    	int[] count = new int[10];
    	
    	for (int i = 0; i < 9; i++) {
    		// 숫자 범위 체크
    		if (number9[i] < 1 || number9[i] > 9)
    			return false;
    		// 중복 숫자 체크
    		if (count[number9[i]] != 0)
    			return false;
    		else
    			count[number9[i]]++;
    	}
    	// 모두 통과
    	return true;
    }
    
}