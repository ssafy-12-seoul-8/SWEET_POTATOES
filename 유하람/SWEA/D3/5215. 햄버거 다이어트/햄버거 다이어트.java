import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[][] element;
	static int answer;
    
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			// 재료의 수 N
			int N = sc.nextInt();
			
			// 제한 칼로리 L
			int L = sc.nextInt();
			
			// 재료의 점수와 칼로리를 저장하는 int[][] 배열
			element = new int[N][2];
			for(int i=0 ; i<N ; i++) {
				element[i][0] = sc.nextInt();	// 점수
				element[i][1] = sc.nextInt();	// 칼로리
			}
			
			answer = Integer.MIN_VALUE;
			
			cal(N, L, 0, 0, 0);
			
			System.out.println("#"+tc+" "+answer);
		}
	}
    static void cal(int N, int L, int idx, int score, int cal) {
		
		if(idx==N) {
			if(cal<L) {
				answer = Math.max(answer, score);
			}
			return;
		}
		
		// 안뽑는 경우
		cal(N,L,idx+1, score, cal);
		
		// 뽑는 경우
		score += element[idx][0];
		cal += element[idx][1];
		cal(N, L, idx+1, score, cal);
		
	}
    
}