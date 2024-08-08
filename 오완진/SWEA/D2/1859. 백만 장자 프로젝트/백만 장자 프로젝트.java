import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
        	
            int N = sc.nextInt();
            int[] maemaeCalendar = new int[N];
            
            for (int i = 0; i < N; i++) {
                maemaeCalendar[i] = sc.nextInt();
            }
            
            long max = 0;
            int candle = 0;
            
            for (int i = N - 1; i >= 0; i--) {			// 미래에서부터 접근
                if (maemaeCalendar[i] > candle) {
                    candle = maemaeCalendar[i];			// 캔들 찾기
                }
                max += (candle - maemaeCalendar[i]);	// 매수구간
            }
            
            System.out.println("#" + tc + " " + max);
        }
        
    }
}