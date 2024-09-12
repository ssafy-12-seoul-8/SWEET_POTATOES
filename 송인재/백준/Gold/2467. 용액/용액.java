import java.io.*;
import java.util.*;

public class Main {
	
	static int n, min;
	static int[] solutions, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		solutions = new int[n];
		min = Integer.MAX_VALUE;
		answer = new int[2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n - 1; i++) {
			binarySearch(i);
		}
		
		Arrays.sort(answer);
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	static void binarySearch(int current) {
		int left = current + 1;
		int right = n - 1;
		
		while (left <= right) {
			if (min == 0) {
				break;
			}
			
			int mid = left + right >> 1;
			int sum = Math.abs(solutions[current] + solutions[mid]);
			
			if (sum < min) {
				min = sum;
				answer[0] = solutions[current];
				answer[1] = solutions[mid];
			}
			
			if (solutions[current] < -solutions[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
	}
	
}
