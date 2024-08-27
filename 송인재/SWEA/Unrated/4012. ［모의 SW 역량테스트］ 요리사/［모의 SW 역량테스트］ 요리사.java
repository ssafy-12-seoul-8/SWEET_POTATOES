import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, min;
	static int[][] synergy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			n = Integer.parseInt(br.readLine());
			synergy = new int[n][n];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combination(new boolean[n], 0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void combination(boolean[] isA, int index, int aCount) {
		if (aCount == n / 2) {
			calculateSynergy(isA);
			
			return;
		}
		
		for (int i = index; i < n; i++) {
			isA[i] = true;
			
			combination(isA, i + 1, aCount + 1);
			
			isA[i] = false;
		}
	}
	
	static void calculateSynergy(boolean[] isA) {
		int aSynergy = 0;
		int bSynergy = 0;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (isA[i] && isA[j]) {
					aSynergy += synergy[i][j] + synergy[j][i];
				}
				
				if (!isA[i] && !isA[j]) {
					bSynergy += synergy[i][j] + synergy[j][i];
				}
			}
		}
		
		min = Math.min(min, Math.abs(aSynergy - bSynergy));
	}
	
}
