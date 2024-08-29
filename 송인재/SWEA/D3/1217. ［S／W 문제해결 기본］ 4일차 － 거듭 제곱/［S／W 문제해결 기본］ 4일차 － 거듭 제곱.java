import java.util.Scanner;

public class Solution {
    
    static final int cases = 10;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= cases; t++) {
			int tc = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
            int answer = 1;
			
			while (m > 0) {
				if ((m & 1) == 1) {
					answer *= n;
				}
				
				n *= n;
				m >>= 1;
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
}
