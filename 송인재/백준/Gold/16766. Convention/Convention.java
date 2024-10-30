import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, c;
	static int[] arrived;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arrived = new int[n];
		st = new StringTokenizer(br.readLine());
		int left = 0;
		int right = 0;
		
		for (int i = 0; i < n; i++) {
			arrived[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arrived[i]);
		}
		
		Arrays.sort(arrived);
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (isPossible(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left);
	}
	
	static boolean isPossible(int time) {
		int last = arrived[0];
		int total = 1;
		int busSize = 1;
		
		for (int i = 1; i < n; i++) {
			if (arrived[i] - last <= time && busSize < c) {
				busSize++;
				
				continue;
			}
			
			total++;
			last = arrived[i];
			busSize = 1;
			
			if (total > m) {
				return false;
			}
		}
		
		return total <= m;
	}
	
}
