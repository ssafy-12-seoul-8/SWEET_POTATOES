import java.util.Scanner;

public class Main {
	
	static int N, M, nNow, mNow, dWay, cleanCnt;
	static int[][] room;
	static boolean isWorking;
	static int[] dn = new int[] {-1, 0, 1, 0};
	static int[] dm = new int[] {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		nNow = sc.nextInt();
		mNow = sc.nextInt();
		dWay = sc.nextInt();
		cleanCnt = 0;
		isWorking = true;
		room = new int[N][M];
		
		/*
		 * 1. if 현재칸 더러운곳(0) -> 청소(2)
		 * 2. 주변 4칸 중 더러운곳(0) X
		 * 	a. 방향 유지한채로 뒤쪽=벽(1) X -> 한 칸 후진
		 * 	b. 방향 유지한채로 뒤쪽=벽(1) O -> 작동 중지
		 * 3. 주변 4칸 중 더러운곳(0) O
		 * 	a. 반시계 90도 회전
		 * 	b. 바라보는 방향 기준 더러운곳(0)으로 한 칸 전진
		 */
		
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				room[n][m] = sc.nextInt();
		
		if (room[nNow][mNow] == 0) {
			room[nNow][mNow] = 2;
			cleanCnt++;
		}
		
		while (isWorking) {
			if (isBackward()) moveBackward();
			else		 	  moveForward();
		}
		
		System.out.println(cleanCnt);
	}
	
	static boolean isBackward() {
		boolean isAllCleaned = true;
		for (int d = 0; d < 4; d++) {
			int nNext = nNow + dn[d];
			int mNext = mNow + dm[d];
			
			if (room[nNext][mNext] == 0)	// 주변 4칸 중 빈칸 O
				isAllCleaned = false;
		}
		
		return isAllCleaned;	// true Backward - false Forward
	}
	
	static void moveBackward() {
		int nNext = nNow + dn[(dWay + 2) % 4];
		int mNext = mNow + dm[(dWay + 2) % 4];
		
		if (room[nNext][mNext] == 1) {
			isWorking = false;				// 작동 중지
		} else {
            nNow = nNext;
            mNow = mNext;
		}
	}
	
	static void moveForward() {
        for (int d = 0; d < 4; d++) {
            dWay = (dWay + 3) % 4; 

            int nNext = nNow + dn[dWay];
            int mNext = mNow + dm[dWay];

            if (room[nNext][mNext] == 0) {
                room[nNext][mNext] = 2;
                cleanCnt++;
                nNow = nNext;
                mNow = mNext;
                return;
            }
        }
    }
	
}