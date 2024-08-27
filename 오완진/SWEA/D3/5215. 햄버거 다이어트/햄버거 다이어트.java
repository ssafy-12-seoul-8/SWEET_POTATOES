import java.util.Scanner;

public class Solution {
	
	static int N;
	static int L;
	static int maxScore;
	static int[][] hbg;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			L = sc.nextInt();
			hbg = new int[N][2];
			
			for (int n = 0; n < N; n++) {
				hbg[n][0] = sc.nextInt();	// 점수
				hbg[n][1] = sc.nextInt();	// 칼로리
			}
			
			maxScore = 0;	// 초기화
			
			makeHBG(0, 0, 0);
			
			System.out.println("#" + tc + " " + maxScore);
		}
		
	}
	
	static void makeHBG(int score, int cal, int idx) {
		
		if (cal <= L)
			maxScore = Math.max(maxScore, score);
		else return;
		
		for (int n = idx; n < N; n++) {
			score += hbg[n][0];
			cal += hbg[n][1];
			makeHBG(score, cal, n + 1);
			cal -= hbg[n][1];
			score -= hbg[n][0];
		}
	}
}
