import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int[] dx = {0, 0, 1, 0, -1};		// 델타배열 X
	static int[] dy = {0, -1, 0, 1, 0};		// 델타배열 Y
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int M = sc.nextInt();			// 0초 + 1~M초
			int A = sc.nextInt();			// BC 개수
			int[] DA = new int[M+1];		// Direction A (입력)
			int[] DB = new int[M+1];		// Direction B (입력)
			int[] PA = new int[] {1, 1};	// Position A (X Y)
			int[] PB = new int[] {10, 10};	// Position B (X Y)
			int[][] BC = new int[A][4];		// BCinfo (X Y C P)
			DA[0] = 0;
			for (int m = 1; m <= M; m++)
				DA[m] = sc.nextInt();
			DA[0] = 0;
			for (int m = 1; m <= M; m++)
				DB[m] = sc.nextInt();
			for (int a = 0; a < A; a++)
				for (int bc = 0; bc < 4; bc++)
					BC[a][bc] = sc.nextInt();
			
			int sumP = 0;
			for (int m = 0; m <= M; m++) {
				
				PA[0] += dx[DA[m]];
				PA[1] += dy[DA[m]];
				PB[0] += dx[DB[m]];
				PB[1] += dy[DB[m]];
				
				availableA = new ArrayList<>();
				availableB = new ArrayList<>();

                for (int a = 0; a < A; a++) {
                    if (isConnected(PA, BC[a]))
                        availableA.add(a);
                    if (isConnected(PB, BC[a]))
                        availableB.add(a);
                }
                
                int maxP = 0;
                
                if (availableA.isEmpty() && !availableB.isEmpty()) {
                	for (int a2 : availableB)
                		maxP = Math.max(maxP, BC[a2][3]);
                } else if (!availableA.isEmpty() && availableB.isEmpty()) {
                	for (int a1 : availableA)
                		maxP = Math.max(maxP, BC[a1][3]);
                } else if (!availableA.isEmpty() && !availableB.isEmpty()) {
                    for (int a1 : availableA) {
                        for (int a2 : availableB) {
                            if (a1 == a2) {
                                maxP = Math.max(maxP, BC[a1][3]);	// 0.5 + 0.5
                            } else {
                                maxP = Math.max(maxP, BC[a1][3] + BC[a2][3]);
                            }
                        }
                    }
                } else {}	// P = 0

                sumP += maxP;
                
                // TEST -------------------------------------------------------
//                System.out.println(m + "초 ***********************************");
//                System.out.println("PA: \t\t" + PA[0] + ", " + PA[1]);
//                System.out.println("PB: \t\t" + PB[0] + ", " + PB[1]);
//                
//                System.out.print("availableA: \t");
//                for (int a : availableA)
//                	System.out.print(a + " ");
//                System.out.println();
//                System.out.print("availableB: \t");
//                for (int b : availableB)
//                	System.out.print(b + " ");
//                System.out.println();
                // TEST -------------------------------------------------------
                
            }

            System.out.println("#" + tc + " " + sumP);
        }
    }

	static List<Integer> availableA = new ArrayList<>();
	static List<Integer> availableB = new ArrayList<>();
	
	static boolean isConnected(int[] position, int[] BCinfo) {
		int Distance = Math.abs(position[0] - BCinfo[0]) + Math.abs(position[1] - BCinfo[1]);
		if (Distance <= BCinfo[2]) 	return true;
		else						return false;
	}
	
}

/*
 * 거리 = |Xa - Xb| + |Ya - Yb|
 * 충전범위 C 이내 P만큼 충전 (2인 이상 ~ 균등분배)
 * 둘 중 하나 접속 -> P 큰 곳 접속이 유리
 * - 예제) 50 + 50 < 100 + 70
 * BC (X, Y) C P
 * (1,1) / (10,10) 출발
 * - A, B 같은 위치로 이동 가능
 * 총 이동시간 20 <= M <= 100
 * - 0초부터 충전 시작
 * BC 개수 1 <= A <= 8
 * 충전범위 1 <= C <= 4
 * 충전성능 10 <= P(짝수) <= 500
 */