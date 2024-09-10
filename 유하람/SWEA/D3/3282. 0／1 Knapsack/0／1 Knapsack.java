
import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<= T ; tc++) {
			
			int N = sc.nextInt();	//	물건의 개수 (1<=N<=100)
			int K = sc.nextInt();	//	가방의 최대 부피 (1<=K<=1000)
			
			int[][] stuffs = new int[N+1][2]; 	// 물건들 {부피, 가치}
			int[][] DP = new int[N+1][K+1];		// r에 해당하는 물건을 크기가 c인 가방에 넣을 수 있는지, 최대인지 저장
			
			for(int i=1 ; i<N+1 ; i++) {
				stuffs[i] = new int[] {sc.nextInt(), sc.nextInt()};
			}
			
			for(int i=1 ; i<=N ; i++) {			// i 번째 물건을 
				for(int j=0 ; j<=K ; j++) {		// 크기가 j인 가방에 넣을 지 말 지
					if(stuffs[i][0] <= j ) {
						// i 번 물건을 선택하는 경우
						int choice1 = DP[i-1][j-stuffs[i][0]]+stuffs[i][1];
						// i 번 물건을 선택 안 하는 경우
						int choice2 = DP[i-1][j];
						// 둘 중 최대 값을 저장
						DP[i][j] = Math.max(choice1, choice2);
					}else {
						DP[i][j] = DP[i-1][j];	// i 번째 물건을 못 넣는다면 전의 최선의 선택 가져옴
					}
				}
			}
			
			System.out.println("#"+tc+" "+DP[N][K]);
			
			
		}
		
		
		
	} // main
	
	
}
