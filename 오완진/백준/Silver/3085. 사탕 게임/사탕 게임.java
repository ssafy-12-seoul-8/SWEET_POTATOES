import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        
        char[][] candyArr = new char[N][N];
        
        for (int r = 0; r < N; r++)
        	candyArr[r] = sc.nextLine().toCharArray();
        
//        System.out.println(N);
//        for (int r = 0; r < N; r++) {
//        	for (int c = 0; c < N; c++) {
//        		System.out.print(candyArr[r][c]);
//        	}
//        	System.out.println();
//        }
        
        int cnt = 0;
        int max = 0;
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        for (int rNow = 0; rNow < N; rNow++) {
        	for (int cNow = 0; cNow < N; cNow++) {
        		// 동서남북 4번
        		for (int d = 0; d < 4; d++) {
        			int rChange = rNow + dr[d];
        			int cChange = cNow + dc[d];
        			
        			// 교환할 좌표 유효 확인 -> 사탕 교환
        			if (rChange >= 0 && rChange < N && cChange >= 0 && cChange < N) {
        				char tmp = candyArr[rChange][cChange];
        				candyArr[rChange][cChange] = candyArr[rNow][cNow];
        				candyArr[rNow][cNow] = tmp;

						for (int r = 0; r < N; r++) {
	        				cnt = 1;
	        				for (int c = 0; c < N - 1; c++) {
	        		            if (candyArr[r][c] == candyArr[r][c + 1]) {
	        		                cnt++;
	        		            } else {
	        		                max = Math.max(max, cnt);
	        		                cnt = 1;
	        		            }
	        				}
	        				max = Math.max(max, cnt);
						}
						
						for (int c = 0; c < N; c++) {
	        				cnt = 1;
	        				for (int r = 0; r < N - 1; r++) {
	        		            if (candyArr[r][c] == candyArr[r + 1][c]) {
	        		                cnt++;
	        		            } else {
	        		                max = Math.max(max, cnt);
	        		                cnt = 1;
	        		            }
	        				}
	        				max = Math.max(max, cnt);
	        			}
						
	        			// 최대값 탐색 후 원복
	    				tmp = candyArr[rChange][cChange];
	    				candyArr[rChange][cChange] = candyArr[rNow][cNow];
	    				candyArr[rNow][cNow] = tmp;
        			}
        			
        		}
        	}
        }
        
        System.out.println(max);
    }
}