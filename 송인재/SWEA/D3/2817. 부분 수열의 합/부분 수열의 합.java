import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, k, count;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			nums = new int[n];
			count = 0;
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			System.out.println("#" + t + " " + count);
		}
		
	}
	
	static void combination(int index, int sum) {
		if (sum >= k) {
			if (sum == k) {
				count++;
			}
			
			return;
		}
		
		for (int i = index; i < n; i++) {
			combination(i + 1, sum + nums[i]);
		}
	}
	
}
