import java.util.*;
import java.io.*;

public class Main {
	
	static int[] diff;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] tabs = new int[n];
		diff = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			tabs[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			diff[i] = Integer.parseInt(st.nextToken()) - tabs[i];
		}
		
		int total = 0;
		boolean notDone = true;
		
		while (notDone) {
			int last = 0;
			int lastMin = 0;
			
			for (int i = 0; i < n - 1; i++) {
				if (lastMin == 0 || Math.abs(diff[i]) < Math.abs(lastMin)) {
					if (lastMin == 0) {
						last = i;
					}
					
					lastMin = diff[i];
				}
				
				if (diff[i] * diff[i + 1] <= 0) {
					calculateGroup(last, i, lastMin);
					
					total += Math.abs(lastMin);
					last = i + 1;
					lastMin = diff[i + 1];
				}
			}
			
			if (Math.abs(diff[n - 1]) < Math.abs(lastMin)) {
				lastMin = diff[n - 1];
			}
			
			calculateGroup(last, n - 1, lastMin);
			
			total += Math.abs(lastMin);
			notDone = false;
			
			for (int i = 0; i < n; i++) {
				if (diff[i] != 0) {
					notDone = true;
					
					break;
				}
			}
		}
		
		System.out.println(total);
	}
	
	static void calculateGroup(int from, int to, int offset) {
		for (int i = from; i <= to; i++) {
			diff[i] -= offset;
		}
	}
	
}
