import java.io.*;
import java.util.*;

public class Main {
	
	static int n, min, total, totalBudget, maxBudget;
	static int[] requests;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		requests = new int[n];
		min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			requests[i] = Integer.parseInt(st.nextToken());
			maxBudget += requests[i];
		}
		
		total = Integer.parseInt(br.readLine());
		maxBudget = Math.min(total, maxBudget);
		
		binarySearch(0, total);
		System.out.println(min);
	}
	
	static void binarySearch(int left, int right) {
		if (left > right) {
			return;
		}
		
		int mid = (left + right) / 2;
		int budget = allocateBudget(mid);
		
		if (budget <= total) {
			if (budget > totalBudget) {
				min = mid;
				totalBudget = budget;
			} else if (budget == totalBudget) {
				min = Math.min(mid, min);
			}
		}
		
		if (budget < maxBudget) {
			binarySearch(mid + 1, right);
		} else {
			binarySearch(left, mid - 1);
		}
	}
	
	static int allocateBudget(int limit) {
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += requests[i] > limit ? limit : requests[i];
		}
		
		return sum;
	}
	
}
