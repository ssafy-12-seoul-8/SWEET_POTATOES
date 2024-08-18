import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Integer> printN = new ArrayList<>();
		pickN(N, M, printN);
		
	}
	
	static void pickN(int N, int M, List<Integer> printN) {
		if (printN.size() == M) {
			for (int num : printN)
				System.out.print(num + " ");
			System.out.println();
			return;
		}
		
		pickN:
		for (int n = 1; n <= N; n++) {
			// N과 M(2) 와 달리 1부터 다시 돌릴껀데 만약 중복되는 수가 있다면 Pass
			for (int m = 0; m < printN.size(); m++)
				if (n == printN.get(m)) continue pickN;
			printN.add(n);
			pickN(N, M, printN);
			printN.remove(printN.size() - 1);
		}
	}
}