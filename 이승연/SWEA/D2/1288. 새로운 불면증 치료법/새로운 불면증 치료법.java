import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			Set<Integer> S = new HashSet<>();
			long number = 1;
			long count = 0;
			
			while(S.size() != 10) {
				long n = number * N;
				String s = n + "";
				
				for (int i = 0; i < s.length(); i++) {
					S.add(Character.getNumericValue(s.charAt(i)));
				}
				
				number += 1;
				count = n;
			}
			
			System.out.printf("#%d ", test_case);
			System.out.println(count);
		}
	}

}
