import java.io.*;
import java.util.*;
	
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] store = new int[n];
		int index = 0;
		
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			if (index == 0 || store[index - 1] < nums[i]) {
				store[index] = nums[i];
				index++;
				
				continue;
			}
			
			int left = 0;
			int right = index - 1;
			
			while (left <= right) {
				int mid = (left + right) / 2;
				
				if (store[mid] > nums[i]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
						
			if (right >= 0 && store[right] == nums[i]) {
				continue;
			}
			
			store[left] = nums[i];
		}
		
		System.out.println(index);
	}
	
}
