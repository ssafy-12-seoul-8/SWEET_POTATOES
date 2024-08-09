import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
        	
        	int R = sc.nextInt();
        	int C = sc.nextInt();
        	sc.nextLine();
        	char[][] russia = new char[R][C];
        	
        	for (int r = 0; r < R; r++) {
        		String str = sc.nextLine();
        		russia[r] = str.toCharArray();
        	}
        	
//        	for (int r = 0; r < R; r++) {
//        		for (int c = 0; c < C; c++) {
//        			System.out.print(russia[r][c] + " ");
//        		}
//        		System.out.println();
//        	}
        	
        	// 행 별로 White Blue Red 카운트
        	int[][] cntWBR = new int[R][3];
        	for (int r = 0; r < R; r++) {
        		for (int c = 0; c < C; c++) {
        			if (russia[r][c] == 'W') cntWBR[r][0]++;
        			if (russia[r][c] == 'B') cntWBR[r][1]++;
        			if (russia[r][c] == 'R') cntWBR[r][2]++;
        		}
        	}
        	
        	
        	// Ex. W 바꿔야하는 수 : (C-cntWBR[r][0]) 개
        	// W : 0 ~ R-3 , B , R : r1+2 ~ R-1
        	int min = 999999999;
        	for (int r1 = 0; r1 <= R-3; r1++) {
        		for (int r2 = R-1; r2 >= r1+2; r2--) {
        			
        			int cnt = 0;
        			for (int i = 0; i <= r1; i++) {
        				cnt += (C - cntWBR[i][0]);
        			}
        			for (int i = r1+1; i <= r2-1; i++) {
        				cnt += (C - cntWBR[i][1]);
        			}
        			for (int i = r2; i <= R-1; i++) {
        				cnt += (C - cntWBR[i][2]);
        			}
        			min = Math.min(min, cnt);
        			
        		}
        	}
        	
        	System.out.println("#" + tc + " " + min);
        }
        
    }
}