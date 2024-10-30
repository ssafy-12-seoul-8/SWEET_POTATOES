import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k;
	static int[] corrects;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		corrects = new int[n];
		st = new StringTokenizer(br.readLine());
		int left = 0;
		int right = 0;
		
		for (int i = 0; i < n; i++) {
			corrects[i] = Integer.parseInt(st.nextToken());
			right += corrects[i];
		}
		
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
	
	static boolean isPossible(int score) {
		int sum = 0;
		int total = 0;
		
		for (int i = 0; i < n; i++) {
			sum += corrects[i];
			
			if (sum >= score) {
				total++;
				sum = 0;
			}
			
			if (total == k) {
				return true;
			}
		}
		
		return false;
	}
	
}
