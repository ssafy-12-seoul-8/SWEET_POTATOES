import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < m; i++) {
				sb.append(find(Integer.parseInt(st.nextToken()), 0, n - 1))
					.append(System.lineSeparator());
			}
			
			System.out.print(sb);
		}
	}
	
	static int find(int target, int left, int right) {
		if (left > right) {
			return 0;
		}
		
		int mid = left + (right - left) / 2;
		
		if (nums[mid] == target) {
			return 1;
		}
		
		return nums[mid] > target ? find(target, left, mid - 1) : find(target, mid + 1, right);
	}
	
}
