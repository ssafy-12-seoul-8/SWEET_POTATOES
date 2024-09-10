import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int[] memo;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[5];
		int max = 0;
		
		for (int i = 0; i < 5; i++) {
			nums[i] = sc.nextInt();
			max = Math.max(max, nums[i]);
		}
		
		memo = new int[max+1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
		
		for(int i : nums) {
			System.out.println(fibo(i));
		}

	} // main

	private static int fibo(int num) {
		if(num==0) return 0;
		if(num==1) return 1;
		
		if(memo[num-2] != -1 && memo[num-1] != -1) {
			memo[num] = memo[num-2] + memo[num-1];
			return memo[num];
		}
		
		memo[num] = fibo(num-2) + fibo(num-1);
		return memo[num];
	
	}

}
