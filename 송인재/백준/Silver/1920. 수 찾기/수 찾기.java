import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < m; i++) {
			int found = Arrays.binarySearch(nums, Integer.parseInt(st.nextToken()));
			sb.append(found < 0 ? 0 : 1)
				.append(System.lineSeparator());
		}
		
		System.out.print(sb);
	}
	
}
