import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, l, max;
	static int[] scores, calories;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			scores = new int[n];
			calories = new int[n];
			max = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0, 0);
			System.out.println("#" + t + " " + max);
		}
		
	}
	
	static void combination(int index, int totalScore, int totalCalories) {
		if (totalCalories > l) {
			return;
		}
		
		max = Math.max(max, totalScore);
		
		for (int i = index; i < n; i++) {
			combination(i + 1, totalScore + scores[i], totalCalories + calories[i]);
		}
	}
	
}
