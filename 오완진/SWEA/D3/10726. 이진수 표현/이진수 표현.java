import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		outer:
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String reverseBinary = "";
			while (M > 0) {
				int tmp = M % 2;
				M /= 2;
				reverseBinary += (tmp + "");
			}
			
			int bl = reverseBinary.length();
			if (bl < N) {
				for (int b = 0; b < N - bl; b++) {
					reverseBinary += "0";
				}
			}
			
//			System.out.println(tc + ": " + reverseBinary);
			char[] charArr = reverseBinary.toCharArray();
			
			for (int n = 0; n < N; n++) {
				if (charArr[n] == '0') {
					System.out.println("#" + tc + " " + "OFF");
					continue outer;
				}
			}
			
			System.out.println("#" + tc + " " + "ON");
		}
		
	}
}
