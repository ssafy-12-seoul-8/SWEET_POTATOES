import java.io.*;
import java.util.*;

public class Solution {
	
	static final int maxNum = 18;
	
	static int[] gy;
	static boolean[] submitted;
	static int gyWin, iyWin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gyWin = 0;
			iyWin = 0;
			gy = new int[maxNum / 2];
			submitted = new boolean[maxNum + 1];
			
			for (int i = 0; i < maxNum / 2; i++) {
				gy[i] = Integer.parseInt(st.nextToken());
				submitted[gy[i]] = true;
			}
			
			permutation(0, 0, 0);
			System.out.println("#" + t + " " + gyWin + " " + iyWin);
		}
	}
	
	static void permutation(int current, int gySum, int iySum) {
		if (current == maxNum / 2) {
			if (gySum > iySum) {
				gyWin++;
			}
			
			if (gySum < iySum) {
				iyWin++;
			}
			
			return;
		}
		
		for (int i = 1; i <= maxNum; i++) {
			if (submitted[i]) {
				continue;
			}
			
			submitted[i] = true;
			int sum = gy[current] + i;
			
			if (gy[current] > i) {
				permutation(current + 1, gySum + sum, iySum);
			} else {
				permutation(current + 1, gySum, iySum + sum);
			}
			
			submitted[i] = false;
		}
	}

}
