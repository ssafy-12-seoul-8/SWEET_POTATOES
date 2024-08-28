import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*
		 * 1. X : 0 _ _
		 * 2. X 0,1 <-> X' 1,0
		 * 3. X += X'
		 * ... K 번째 문자?
		 * 
		 *                    1            2         3            4          5         6
		 * 1  2  3 4  56 78  9012 3456  78901234 56789012  3456789012345678 9012345678901234
		 * 0  1  1.0  10.01  1001.0110  10010110.01101001  1001011001101001.0110100110010110
		 * 
		 * 비트연산자 풀이방법이 있나???
		 * 
		 * left 2^1 2^3 .. 유지 => false
		 * left 2^2 2^4 .. 반전 => true
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		long K = sc.nextLong();
		long left = 576460752303423488l;	// 2^59
		long right = 1152921504606846976l;	// 2^60
		boolean leftCheck = false;
		boolean reverse = false;
		
		while (left > 1) {
			if (left < K && K <= right) {
				K = (right+1) - K;
				if (leftCheck) reverse = !reverse;
			}
			left /= 2;
			right /= 2;
			leftCheck = !leftCheck;
		}
		
		if (K == 1) {
			if (reverse) System.out.println(1);
			else	 	 System.out.println(0);
		} else {
			if (reverse) System.out.println(0);
			else		 System.out.println(1);
		}
		
	}
}