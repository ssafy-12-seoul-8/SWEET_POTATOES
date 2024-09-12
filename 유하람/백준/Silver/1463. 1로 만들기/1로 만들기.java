import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N+1];
		
		if(N==1) {
			System.out.println(0);
		}else if(N==2 || N==3) {
			System.out.println(1);
		}else {
			nums[0] = 0;
			nums[1] = 0;
			nums[2] = 1;
			nums[3] = 1;
			
			for(int i=4 ; i<N+1 ; i++) {
				nums[i] = Integer.MAX_VALUE;
				if(i%3==0) 
				{
					nums[i] = nums[i/3]+1;
				}
				if(i%2==0) 
				{
					nums[i] = Math.min(nums[i], nums[i/2]+1);
				}
				nums[i] = Math.min(nums[i], nums[i-1]+1);
			}
			System.out.println(nums[N]);
		}
		
		
		
		
	}


}
