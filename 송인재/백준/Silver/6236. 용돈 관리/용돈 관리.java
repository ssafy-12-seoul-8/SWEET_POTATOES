import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[] costs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		costs = new int[n];
		int left = 0;
		int right = 10_000 * n;
		
		for (int i = 0; i < n; i++) {
			costs[i] = Integer.parseInt(br.readLine());
			left = Math.max(left,  costs[i]);
		}
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = countWithdrawal(mid);
			
			if (count <= m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left);
	}
	
	static int countWithdrawal(int standard) {
		int count = 0;
		int left = 0;
		
		for (int i = 0; i < n; i++) {
			if (costs[i] <= left) {
				left -= costs[i];
			} else {
				left = standard - costs[i];
				count++;
			}
		}
		
		if (left < 0) {
			count++;
		}
		
		return count;
	}
	
}
