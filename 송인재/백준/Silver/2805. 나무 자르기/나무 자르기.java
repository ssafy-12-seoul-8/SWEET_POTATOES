import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		trees = new int[n];
		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, trees[i]);
		}
		
		while (left <= right) {
			int mid = (left + right) / 2;
			long collected = cutAndCollect(mid);
			
			if (collected >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}
	
	static long cutAndCollect(int height) {
		long sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += trees[i] > height ? trees[i] - height : 0;
		}
		
		return sum;
	}
	
}
