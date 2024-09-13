import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, l;
	static int[] at;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		at = new int[n + 2];
		at[0] = 0;
		at[n + 1] = l;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			at[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(at);
		
		int left = 1;
		int right = l;
		
		while (left <= right) {
			int mid = left + right >> 1;
		
			if (isPossible(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left);
	}
	
	static boolean isPossible(int distance) {
		int count = 0;
		
		for (int i = 1; i < n + 2; i++) {
			count += (at[i] - 1 - at[i - 1]) / distance;
			
			if (count > m) {
				return false;
			}
		}
		
		return true;
	}
	
}
