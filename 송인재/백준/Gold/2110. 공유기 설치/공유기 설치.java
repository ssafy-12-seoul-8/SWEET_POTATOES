import java.io.*;
import java.util.*;

public class Main {
	
	static int n, c;
	static int[] houses;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		houses = new int[n];
		
		for (int i = 0; i < n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(houses);
		
		int left = 1;
		int right = houses[n - 1] - houses[0];
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (isPossible(mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}
	
	static boolean isPossible(int distance) {
		int count = 1;
		int from = 0;
		
		for (int i = 1; i < n; i++) {
			if (houses[i] - houses[from] >= distance) {
				from = i;
				count++;
			}
			
			if (count >= c) {
				return true;
			}
		}
		
		return false;
	}
	
}
