import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] sosin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sosin = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long left = 0;
		long right = 500_000L * 300_000L;
		
		for (int i = 0; i < n; i++) {
			sosin[i] = Integer.parseInt(st.nextToken());
		}
		
		while (left <= right) {
			long mid = (left + right) / 2;
			
			if (isPossible(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left);
	}
	
	static boolean isPossible(long time) {
		long range = time / sosin[0];
		long canLocatedAtLeft = 0;
		long canLocatedAtRight = range;
		
		for (int i = 1; i < n; i++) {
			range = time / sosin[i];
			canLocatedAtLeft = Math.max(canLocatedAtLeft, i - range);
			canLocatedAtRight = Math.min(canLocatedAtRight, i + range);
			
			if (canLocatedAtLeft > canLocatedAtRight) {
				return false;
			}
		}
		
		return true;
	}
}
