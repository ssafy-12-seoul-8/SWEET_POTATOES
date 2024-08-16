import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int number = sc.nextInt();	// 2 라고 해보자
			Map<Integer, Integer> map = new HashMap<>();

			int count = 0;
			
			while (map.size() != 10 ) {
				count++;
			
				Integer product = number * count;	// 2*1, 2*2, 2*3, 2*4 ...
				String sProduct = product.toString();
				for (int i=0; i < sProduct.length(); i++) {
					int n = sProduct.charAt(i) - '0';
					map.put(n,n);
//					System.out.println(map);
				}
			}
			
			int result = count * number;
			System.out.println("#" + test_case + " " + result);
		}
	}
}
