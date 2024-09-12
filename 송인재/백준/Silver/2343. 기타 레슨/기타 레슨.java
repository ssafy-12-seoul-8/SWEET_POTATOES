import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[] courses;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		courses = new int[n];
		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			courses[i] = Integer.parseInt(st.nextToken());
			left = Math.max(left, courses[i]);
			right += courses[i];
		}
		
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
	
	static boolean isPossible(int limit) {
		int count = 0;
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			if (sum + courses[i] > limit) {
				count++;
				sum = 0;
			}
			
			if (count > m) {
				return false;
			}
			
			sum += courses[i];
		}
		
		return count + 1 <= m;
	}
	
}
