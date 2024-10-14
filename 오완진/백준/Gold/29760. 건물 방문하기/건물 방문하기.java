import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int H = sc.nextInt();
        int W = sc.nextInt();
        
        // [층수][왼/오][호수/가로minTime]
        int[][][] dp = new int[H+1][2][2];

        dp[0][0][0] = 1;
        dp[0][1][0] = 1;
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        for (int h = 2; h <= H; h++)
        	dp[h][0][0] = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
        	int h = sc.nextInt();
        	int w = sc.nextInt();
        	
        	dp[h][0][0] = Math.min(dp[h][0][0], w);
        	dp[h][1][0] = Math.max(dp[h][1][0], w);
        }
        
        int floor = 0;
        for (int h = 1; h <= H; h++) {
        	if (dp[h][0][0] != Integer.MAX_VALUE) {
        		// 최고층 갱신 -> (floor - 1) x 100
        		floor = h;
        		// 머리 빠개지는 중......... 맞겠지???????
        		// 오->왼 방문
        		dp[h][0][1] = Math.min(
        				(dp[h][1][0] <= dp[h-1][1][0] ?
        				dp[h-1][1][0] - dp[h][0][0] :
        				(dp[h][1][0] - dp[h-1][1][0]) + (dp[h][1][0] - dp[h][0][0]))
        				+ dp[h-1][1][1],
        				(dp[h][1][0] <= dp[h-1][0][0] ?
        				dp[h-1][0][0] - dp[h][0][0] :
        					(dp[h][1][0] - dp[h-1][0][0]) + (dp[h][1][0] - dp[h][0][0]))
        				+ dp[h-1][0][1]);
        		// 왼->오 방문
        		dp[h][1][1] = Math.min(
        				(dp[h][0][0] >= dp[h-1][0][0] ?
        				dp[h][1][0] - dp[h-1][0][0] :
        				(dp[h-1][0][0] - dp[h][0][0]) + (dp[h][1][0] - dp[h][0][0]))
        				+ dp[h-1][0][1],
        				(dp[h][0][0] >= dp[h-1][1][0] ?
        				dp[h][1][0] - dp[h-1][1][0] :
        					(dp[h-1][1][0] - dp[h][0][0]) + (dp[h][1][0] - dp[h][0][0]))
        				+ dp[h-1][1][1]);
        		// 왼=오
        		if (dp[h][0][0] == dp[h][1][0]) {
        			int tmp = Math.min(dp[h][0][1], dp[h][1][1]);
        			dp[h][0][1] = tmp;
        			dp[h][1][1] = tmp;
        		}
        	} else {
        		// 아래층 정보 복사
        		dp[h][0] = dp[h-1][0];
        		dp[h][1] = dp[h-1][1];
        	}
        }
        
//        System.out.println("****************************************");
//        for (int h = H; h >= 1; h--) {
//        	System.out.printf("[%2d %2d] [%2d %2d]", dp[h][0][0], dp[h][0][1], dp[h][1][0], dp[h][1][1]);
//        	System.out.println();
//        }
        
        int time = (floor - 1) * 100;
        time += Math.min(dp[floor][0][1], dp[floor][1][1]);
        
        System.out.println(time);
    }
}