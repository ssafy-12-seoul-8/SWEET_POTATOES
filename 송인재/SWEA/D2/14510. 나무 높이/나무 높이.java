import java.io.*;
import java.util.*;

public class Solution {
	
	static int n, max, day;
	static int[] trees;
	static int[] differences;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			n = Integer.parseInt(br.readLine());
			trees = new int[n];
			differences = new int[120];
			max = 0;
			day = 0;
			int maxDifference = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				
				max = Math.max(max, trees[i]);
			}
			
			for (int i = 0; i < n; i++) {
				int difference = max - trees[i];
				maxDifference = Math.max(maxDifference, difference);
				
				differences[difference]++;
			}
			
			while (differences[0] != n) {
				int growth = ++day % 2 == 0 ? 2 : 1;
				
				if (growth == 1 && differences[1] != 0) {
					differences[1]--;
					differences[0]++;
					
					continue;
				}
				
				if (growth == 2 && differences[2] != 0) {
					differences[2]--;
					differences[0]++;
					
					continue;
				}
				
				for (int i = 3; i <= maxDifference; i++) {
					if (differences[i] == 0) {
						continue;
					}
					
					differences[i]--;
					differences[i - growth]++;
					
					break;
				}
			}
			
			System.out.println("#" + t + " " + day);
		}
	}

}
