import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
	
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	
	static int N, M, K, answer;
	static int[][] bugList;
	static Stack<Integer>[][] contact;
	
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
        	
        	N = sc.nextInt();
        	M = sc.nextInt();
        	K = sc.nextInt();
        	answer = 0;
        	bugList = new int[K][4];
        	contact = new Stack[N][N];
        	
        	for (int k = 0; k < K; k++) {
        		bugList[k][0] = sc.nextInt();	// rNow
        		bugList[k][1] = sc.nextInt();	// cNow
        		bugList[k][2] = sc.nextInt();	// cnt
        		bugList[k][3] = sc.nextInt();	// way
        	}
        	
        	for (int m = 1; m <= M; m++) {
        		
        		for (int n1 = 0; n1 < N; n1++)
        			for (int n2 = 0; n2 < N; n2++)
        				contact[n1][n2] = new Stack<>();					// 합체 여부 판단용
        		List<int[]> memo = new ArrayList<>();						// 스택 좌표 메모용
        		
        		for (int k = 0; k < K; k++) {
        			if (bugList[k][2] == 0) continue;
        			
        			int rNow = bugList[k][0];
        			int cNow = bugList[k][1];
        			int cnt = bugList[k][2];
        			int way = bugList[k][3];
        			int rNext = rNow + dr[way];
        			int cNext = cNow + dc[way];
        			
        			// 반갈죽 Zone
        			if (rNext == 0 || rNext == N -1 || cNext == 0 || cNext == N - 1) {
        				bugList[k][2] = cnt / 2;
        				
        				if 		(way == 1) bugList[k][3] = 2;
        				else if (way == 2) bugList[k][3] = 1;
        				else if (way == 3) bugList[k][3] = 4;
        				else if (way == 4) bugList[k][3] = 3;
        			} 

                    // 위치 업데이트
        			bugList[k][0] = rNext;
        			bugList[k][1] = cNext;
        			contact[rNext][cNext].add(k);
        			
        			if (bugList[k][2] > 0)									// 사망
        				memo.add(new int[] {rNext, cNext});
    			}
        			
    			for (int[] mem : memo) {
    				int rCheck = mem[0];
    				int cCheck = mem[1];
    				
    				// 합체!
    				if (contact[rCheck][cCheck].size() > 1) {
    					List<Integer> kList = new ArrayList<>();
    					// 합체 미생물 목록
    					while (!contact[rCheck][cCheck].isEmpty())
    						kList.add(contact[rCheck][cCheck].pop());
    					
    					int kMax = 0;
    					int kMaxIdx = 0;
    					// 살아남는 미생물 찾기
    					for (int kIdx : kList) {
    						if (bugList[kIdx][2] > kMax) {
    							kMax = bugList[kIdx][2];
    							kMaxIdx = kIdx;
    						}
    					}
    					// 미생물 합체
    					for (int kIdx : kList) {
    						if (kIdx != kMaxIdx) {
    							bugList[kMaxIdx][2] += bugList[kIdx][2];
    							bugList[kIdx][2] = 0;						// 사망
    						}
    					}
    				}
        		}
        		
        	}
        	
        	for (int k = 0; k < K; k++)
        		answer += bugList[k][2];
    
            System.out.println("#" + tc + " " + answer);
             
        }
    }
}