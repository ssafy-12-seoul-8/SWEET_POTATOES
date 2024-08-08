import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			// 손님 도착시간 배열 입력
			int[] waiting = new int[N];
			for (int n = 0; n < N; n++)
				waiting[n] = sc.nextInt();	// (n+1)번 손님은 몇초에 도착 입력

			// 카운트배열 사전 작업 ~ 가장 늦게 도착하는 손님 시간 기준
			int lastTime = -1;
			for (int n = 0; n < N; n++)
				lastTime = Math.max(lastTime, waiting[n]);
			
			// 몇초에 몇명이 오는지 배열
			int[] headCnt = new int[lastTime + 1];
			for (int n = 0; n < N; n++)
				headCnt[waiting[n]]++;

			// 시간따라 ~ 붕어빵 생성 & 가능 판단
			int boongCnt = 0;
			boolean isPossible = true;
			for (int t = 0; t <= lastTime; t++) {
				if (t != 0 && t % M == 0) boongCnt += K;		// M초마다 K개 생산
				if (headCnt[t] > boongCnt) {
					isPossible = false;				// 종료
					break;
				} else {
					boongCnt -= headCnt[t];			// 냠냠
				}
			}
			
			if (isPossible)
				System.out.println("#" + tc + " Possible");
			else
				System.out.println("#" + tc + " Impossible");
			
		}
	}
}