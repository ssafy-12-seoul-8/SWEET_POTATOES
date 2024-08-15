import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			boolean[] count = new boolean[10];
			
			int idx = 1;
			outer:
			while (true) {
				String numStr = new String();
				numStr = N*(idx) + " ";
				char[] numChars = numStr.toCharArray();
				
				for (int i = 0; i < numChars.length - 1; i++)
					count[numChars[i] - '0'] = true;
				
				for (boolean tf : count)
					if (!tf) {
						idx++;
						continue outer;
					}
				
				break;
			}
			
			System.out.println("#" + tc + " " + N*idx);
		}
		
	}
}