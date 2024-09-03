import java.io.*;
import java.util.*;

public class Solution {
	
	static int n, max, min;
	static int[] nums, ops;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			ops = new int[4];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				ops[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(n - 1, 1, nums[0]);
			
			System.out.println("#" + t + " " + (max - min));
		}
	}
	
	static void permutation(int left, int numIndex, int calculated) {
		if (left == 0) {
			max = Math.max(max, calculated);
			min = Math.min(min, calculated);

			return;
		}
		
		for (int j = 0; j < 4; j++) {
			if (ops[j] != 0) {
				ops[j]--;
				permutation(left - 1, numIndex + 1, calculate(j, numIndex, calculated));
				ops[j]++;
			}
		}
	}

	static int calculate(int operation, int numIndex, int sum) {
		switch (operation) {
		case 0:
			return sum + nums[numIndex];
		case 1:
			return sum - nums[numIndex];
		case 2:
			return sum * nums[numIndex];
		case 3:
			return sum / nums[numIndex];
		}
		
		return sum;
	}

}
