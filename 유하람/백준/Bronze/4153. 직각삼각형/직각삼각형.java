import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		long[] nums = new long[3];
		Arrays.fill(nums, -1);
		
		for(int i=0 ; i<3 ; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);

		while(nums[0]!=0 || nums[1]!=0 || nums[2]!=0) {
			
			if(nums[2]*nums[2]==nums[0]*nums[0]+nums[1]*nums[1]) {
				sb.append("right").append("\n");
			}else {
				sb.append("wrong").append("\n");
			}

			for(int i=0 ; i<3 ; i++) {
				nums[i] = sc.nextInt();
			}
			
			Arrays.sort(nums);
			
		}
		
		System.out.println(sb.toString());
		
	}

}
