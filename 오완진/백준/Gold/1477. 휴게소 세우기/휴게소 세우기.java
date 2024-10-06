import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int A, B, C;
	static int[] restArea, betweenArea;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();	// O = 0,L-1 X
		
		restArea = new int[A];
		for (int i = 0; i < A; i++)
			restArea[i] = sc.nextInt();
		
		 Arrays.sort(restArea);
		
		betweenArea = new int[A+1];
		int tmp = 0;
		for (int i = 0; i < A; i++) {
			betweenArea[i] = restArea[i] - tmp;
			tmp = restArea[i];
		}
		betweenArea[A] = C - tmp;
		
		int L = 1;
		int R = C;
		while (L <= R) {
			int M = (L + R) / 2;
			
			if (canPlace(M))
				R = M - 1;
			else
				L = M + 1;
		}
		
		System.out.println(L);
	}
	
	static boolean canPlace(int maxLength) {
		int cnt = 0;
		
		for (int length : betweenArea)
			if (length > maxLength)
				cnt += (length - 1) / maxLength;
		
		return cnt <= B;
	}
}