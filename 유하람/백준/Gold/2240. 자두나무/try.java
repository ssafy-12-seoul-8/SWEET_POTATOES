import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		// 자두가 떨어지는 시간 T ( 1 <= T <=1,000 )
		int T = sc.nextInt();
		
		// 자두가 최대로 움직일 수 있는 횟수 W ( 1<= W <= 30 )
		int W = sc.nextInt();
		
		// 자두가 떨어지는 나무 순서
		int[] arr = new int[T+1];
		
		for(int i=1 ; i<=T ; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 자두가 p번 나무에서, t 시간에, w 만큼 움직이고 받을 수 있는 최대 자두의 수를 저장할 배열
		int[][][] DP = new int[3][T+1][W+1];
		
		// 자두는 0초에 1번 나무에 있음
		// 즉, 1초에 2번 나무에 있는 자두를 받으려면 한 번 움직여서 받아야 한다
		// 1초에 1번 나무에서 받는 경우
		if(arr[1]==1) {
			DP[1][1][0] = 1;
		}else {
			// 1초에 2번 나무로 움직여서 받을 경우
			DP[2][1][1] = 1;
		}
		
		for(int t=1 ; t<=T ; t++) {
			for(int w=0 ; w<=W ; w++) {
				if(arr[t]==1) {
					// t 초에 1번 나무에서 자두가 떨어질 경우
					// 1. 전에 1번 나무에 있었다면 움직이지 않고 받음
					// 2. 전에 2번 나무에 있었고 움직일 수 있다면 움직여서 받음
					DP[1][t][w] = Math.max(DP[1][t-1][w], (w>1)?DP[2][t-1][w-1]:0)+1;
					
					// 1. 전에 1번 나무에 있었다면 움직이고 받지 않음
					// 2. 전에 2번 나무에 있었다면 움직이지 않고 받지 않음
					DP[2][t][w] = Math.max((w>1)?DP[1][t-1][w-1]:0, DP[2][t-1][w]);
				}else if(arr[t]==2) {
					// t 초에 2번 나무에서 자두가 떨어질 경우
					// 1. 전에 2번 나무에 있었다면 움직이지 않고 받음
					// 2. 전에 1번 나무에 있었고 움직일 수 있다면 움직여서 받음
					DP[2][t][w] = Math.max(DP[2][t-1][w], (w>1)?DP[1][t-1][w-1]:0)+1;
					
					// 1. 전에 2번 나무에 있었다면 움직이고 받지 않음
					// 2. 전에 1번 나무에 있었다면 움직이지 않고 받지 않음
					DP[1][t][w] = Math.max((w>1)?DP[2][t-1][w-1]:0, DP[1][t-1][w]);
					
				}
			}
		}
		
		System.out.println(Math.max(DP[1][T][W], DP[2][T][W]));
		
	}	// main

}
