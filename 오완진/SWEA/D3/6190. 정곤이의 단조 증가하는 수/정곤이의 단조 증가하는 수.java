import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[] danjo = new int[N];
			for (int n = 0; n < N; n++)
				danjo[n] = sc.nextInt();
			
			long maxNum = -1;
			for (int n = 0; n < N; n++) {
				for (int m = n + 1; m < N; m++) {
					long num = danjo[n] * danjo[m];
					if (isDanjo(num)) 
						maxNum = Math.max(maxNum, num);
				}
			}
				
			System.out.println("#" + tc + " " + maxNum);
		}
		
	}
	
//	static boolean isDanjo(long num) {
//		
//		long tmp1 = num%10;
//		num /= 10;
//		
//		while (num > 1) {
//			long tmp2 = num % 10;
//			if (tmp1 < tmp2) return false;
//			tmp1 = tmp2;
//			num /= 10;
//		}
//		return true;
//		
//	}
	
	static boolean isDanjo(long num) {
		
		String str = num + "";
		char[] charArr = str.toCharArray();
		int[] intArr = new int[charArr.length];
		
		for (int n = 0; n < charArr.length; n++)
			intArr[n] = charArr[n] - '0';
		
		for (int n = 0; n < charArr.length - 1; n++)
			if (intArr[n] > intArr[n+1]) return false;
		
		return true;
		
	}
	
}