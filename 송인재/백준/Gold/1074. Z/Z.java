import java.io.*;
import java.util.*;
	
public class Main {
	
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int pow = (int) Math.pow(2, n);
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		backtrack(r, c, pow);
		System.out.println(count);
	}
	
	static void backtrack(int row, int col, int pow) {
		if (pow == 1) {
			return;
		}
		
		int half = pow / 2;
		int skip = pow * pow / 4;
		
		if (row < half && col < half) {
			backtrack(row, col, half);
		} else if (row < half && col >= half) {
			count += skip;
			
			backtrack(row, col - half, half);
		} else if (row >= half && col < half) {
			count += skip * 2;
			
			backtrack(row - half, col, half);
		} else {
			count += skip * 3;
			
			backtrack(row - half, col - half, half);
		}
	}
	
}
