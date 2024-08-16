import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		int TC = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= TC; tc++) {
			
			int cnt = 0;
			char[] charArr = sc.nextLine().toCharArray();
			int N = charArr.length;
			for (int i = 0; i < charArr.length; i++) {
				if (charArr[i] == '(') {
					if (i + 1 < charArr.length)
						if (charArr[i+1] == ')' || charArr[i+1] == '|')
							cnt++;
				}
				if (charArr[i] == '|') {
					if (i + 1 < charArr.length && charArr[i+1] == ')')
						cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		
	}
}