import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    static int answer;
    
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int N = sc.nextInt();
			
			int K = sc.nextInt();
			
			int[] nums = new int[N];
			
			for(int i=0 ; i<N ; i++) {
				nums[i] = sc.nextInt();
			}
			
			answer = 0;
			
			cal(N, K, nums, 0, 0);
			
			System.out.println("#"+tc+" "+answer);
			
		}
	}
    
    static void cal(int N, int K, int[] nums, int idx, int sum) {
		
		if(idx==N) {
			if(sum==K) {
				answer++;
			}
			return;
		}
		
		cal(N,K,nums,idx+1,sum);
		
		sum += nums[idx];
		cal(N,K,nums,idx+1,sum);
		
		
	}
}