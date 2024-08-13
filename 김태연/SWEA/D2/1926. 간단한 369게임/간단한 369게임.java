import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String result = "";
		for (int i = 1; i <= N; i++) {
			result = "";
			Integer number = i;
			String sNumber = number.toString();
			int numberLength = sNumber.length();
			
			
			for (int j = 0; j < numberLength; j++) {
				int thisNumber = sNumber.charAt(j) - '0';	// 1번자리부터 numberLength 자리까지 369가 몇개 있는지 확인해야함
				if (thisNumber == 3 || thisNumber == 6 || thisNumber == 9 ) {
					result += "-";
				}
			}
			if (result.equals("")) result += i;
			
			System.out.print(result + " ");
		}
	}
}
