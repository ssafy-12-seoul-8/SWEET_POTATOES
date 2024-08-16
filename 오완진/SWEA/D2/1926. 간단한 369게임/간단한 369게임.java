import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		int N = sc.nextInt();
		for (int n = 1; n <= N; n++) {
			String str = n + "";
			char[] charArr = str.toCharArray();
			List<Integer> numArr = new ArrayList<>();
			int clapCnt = 0;
			for (int m = 0; m < charArr.length; m++) {
				int num = charArr[m] - '0';
				if (num == 3 | num == 6 | num == 9)
					clapCnt++;
				else
					numArr.add(num);
			}
			if (clapCnt > 0) {
				for (int i = 0; i < clapCnt; i++) {
					System.out.print("-");
				}
				System.out.print(" ");
			} else {
				for (int num : numArr)
					System.out.print(num);
				System.out.print(" ");
			}
		}
		
	}
}