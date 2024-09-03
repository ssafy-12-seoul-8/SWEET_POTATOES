import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[] nums;
	static int[] opers;
	
	static int min;
	static int max;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			N = sc.nextInt();
			
			// {+,-,*,/}
			opers = new int[4];
			
			for(int i=0 ; i<4 ; i++) {
				opers[i] = sc.nextInt();
			}
			
			// 숫자
			nums = new int[N];
			
			for(int i=0 ; i<N ; i++) {
				nums[i] = sc.nextInt();
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			cal(1, nums[0]);
			
			int answer = max - min;
			
			System.out.println("#"+tc+" "+answer);
			
			
		}
	}

	private static void cal(int depth, int result) {
		if(depth==N) {
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}
		
		if(opers[0]!=0) {	// + 선택
			opers[0]--;
			cal(depth+1, result+nums[depth]);
			opers[0]++;
		}
		
		if(opers[1]!=0) {	// - 선택
			opers[1]--;
			cal(depth+1, result-nums[depth]);
			opers[1]++;
		}
		
		if(opers[2]!=0) {	// * 선택
			opers[2]--;
			cal(depth+1, result*nums[depth]);
			opers[2]++;
		}
		
		if(opers[3]!=0) {	// / 선택
			opers[3]--;
			cal(depth+1, result/nums[depth]);
			opers[3]++;
		}
		
	}


}
