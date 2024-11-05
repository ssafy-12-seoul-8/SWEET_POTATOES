import java.io.*;

public class Main {
	
	static char[] line;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine()
				.toCharArray();
		
		findPalindrome();
		min--;
		
		if (min != 0) {
			for (int i = 0; i < line.length; i++) {
				for (int j = i + 1; j < line.length; j++) {
					swap(i, j);
					findPalindrome();
					swap(j, i);
				}
			}
		}
		
		System.out.println(min);
	}
	
	static void findPalindrome() {
		int[][] dp = new int[line.length][line.length];
		
		for (int i = 0; i < line.length - 1; i++) {
			if (line[i] != line[i + 1]) {
				dp[i][i + 1] = 1;
			}
		}
		
		for (int i = 2; i < line.length; i++) {
			for (int j = 0; j < line.length - i; j++) {
				dp[j][j + i] = Math.min(dp[j][j + i - 1], dp[j + 1][j + i]) + 1;
				dp[j][j + i] = Math.min(dp[j][j + i], dp[j + 1][j + i - 1] + 1);
				
				if (line[j + i] == line[j]) {
					dp[j][j + i] = Math.min(dp[j][j + i], dp[j + 1][j + i - 1]);
				}
			}
		}
		
		min = Math.min(min, dp[0][line.length - 1] + 1);
	}
	
	static void swap(int first, int second) {
		char temp = line[first];
		line[first] = line[second];
		line[second] = temp;
	}
	
}
