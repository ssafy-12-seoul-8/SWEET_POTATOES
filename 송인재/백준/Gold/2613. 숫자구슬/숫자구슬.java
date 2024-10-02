import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[] beads;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		beads = new int[n];
		st = new StringTokenizer(br.readLine());
		int left = 0;
		int right = 0;
		
		for (int i = 0; i < n; i++) {
			beads[i] = Integer.parseInt(st.nextToken());
			left = Math.max(left, beads[i]);
			right += beads[i];
		}
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (isPossible(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		StringBuilder sb = new StringBuilder(left + "\n");
		
		int count = 0;
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += beads[i];
			
			if (sum > left) {
				sb.append(count)
					.append(" ");
				
				sum = beads[i];
				count = 0;
				m--;
			}
			
			count++;
			
			if (m == n - i) {
				break;
			}
		}
		
		while (m > 0) {
			sb.append(count)
				.append(" ");
			
			count = 1;
			m--;
		}
		
		System.out.println(sb);
	}
	
	static boolean isPossible(int max) {
		int sum = 0;
		int count = 1;
		
		for (int i = 0; i < n; i++) {
			sum += beads[i];
			
			if (sum > max) {
				count++;
				sum = beads[i];
			}
		}
		
		return count <= m;	
	}
	
}