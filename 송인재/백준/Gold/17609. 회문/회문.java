import java.io.*;
	
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			System.out.println(palindrome(str, 0, str.length() - 1, 0));
		}
	}
	
	static int palindrome(String str, int start, int end, int wrongCount) {
		if (wrongCount >= 2) {
			return 2;
		}
		
		int left = start;
		int right = end;
		
		while (left < right) {
			if (str.charAt(left) == str.charAt(right)) {
				left++;
				right--;
				
				continue;
			}
			
			return Math.min(palindrome(str, left + 1, right, wrongCount + 1), palindrome(str, left, right - 1, wrongCount + 1));
		}
		
		return wrongCount;
	}
	
}
