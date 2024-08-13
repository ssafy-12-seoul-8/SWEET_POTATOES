import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Long> decreasingNums = new ArrayList<>();
		
		// prevDigitNum : 10 -> 0 ~ 9
		// maxDigit : 1 ~ 10 -> 0 1 2 ... 987654321 9876543210
        for (int i = 1; i <= 10; i++) {
            getDecreasingNums(0, 10, 0, i, decreasingNums);
        }
		
		if (decreasingNums.size() >= N)
			System.out.println(decreasingNums.get(N - 1));
		else
			System.out.println(-1);
		
	}
											 // 앞자리수		      현재자리수		 탐색자리수
	static void getDecreasingNums(long num, int prevDigitNum, int currDigit, int maxDigit, List<Long> decreasingNums) {
		if (currDigit == maxDigit) {
			decreasingNums.add(num);
			return;
		}
		
		for (int dgtNum = 0; dgtNum < prevDigitNum; dgtNum++) {
//			// 백트래킹 : 루프 내에서 재귀 호출 -> 호출 이후에 원래상태로 복구 필요
//			num = num * 10 + dgtNum;
//			prevDigitNum = dgtNum;
//			currDigit++;
//			getDecreasingNums(num, prevDigitNum, currDigit, maxDigit, decreasingNums);
			getDecreasingNums(num * 10 + dgtNum, dgtNum, currDigit + 1, maxDigit, decreasingNums);
		}
		
	}
	
}