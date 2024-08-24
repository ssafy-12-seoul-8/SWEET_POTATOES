import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= TC; tc++) {
			
			int cnt = 0;
			String str = sc.nextLine();
			char[] charArr = str.toCharArray();
			boolean[] boolArr = new boolean[charArr.length];
			
			for (int c = 0; c < charArr.length; c++)
				if (charArr[c] == '1') boolArr[c] = true;
			
			boolean tmp = false;
			for (int b = 0; b < boolArr.length; b++) {
				if (boolArr[b] != tmp) {
					tmp = !tmp;
					cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}	
	}
}