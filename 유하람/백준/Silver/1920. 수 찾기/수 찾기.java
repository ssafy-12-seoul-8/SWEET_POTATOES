import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] nums;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			nums[i] = Integer.parseInt(st1.nextToken());
		}
		
		Arrays.sort(nums);
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0 ; i<M ; i++) {
			int num = Integer.parseInt(st2.nextToken());
			if(check(num)) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
		
	} // main

	private static boolean check(int num) {

		int L = 0;
		int R = N-1;
		
		while(L<=R) {
			
			int mid = (L+R)/2;

			if(nums[mid]==num)
				return true;
			
			if(nums[mid]>num) {
				R = mid-1;
			}else {
				L = mid+1;
			}
		}
		
		return false;
	}

}
