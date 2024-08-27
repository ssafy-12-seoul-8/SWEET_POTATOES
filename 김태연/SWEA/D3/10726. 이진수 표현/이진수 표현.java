import java.util.Scanner;

public class Solution {

	static int N;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = sc.nextInt();
			int M = sc.nextInt();
			
			boolean bitOn = changeBit(M);
			
			
			
			
			String result = "";
			if (bitOn) result += "ON";
			else result += "OFF";
			
			System.out.println("#" + test_case + " " + result);
		}
	}
	
//	static boolean changeBit (int number) {
//		// N번만 반복하면 됨
//		for (int i=0; i<N; i++) {
//			if (number % 2 == 0) {
//				return false;
//			}
//		}
//		return true;
//	}

	static boolean changeBit (int number) {
		// N번만 반복하면 됨
		if ( (number & ((1<<N) -1) ) == ((1<<N) -1)) {
				return true;
		}
		return false;
	}
	
}
