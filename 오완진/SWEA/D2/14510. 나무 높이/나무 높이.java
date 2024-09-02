import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int K = 0;
			int[] tree = new int[N];
			int evenCnt = 0;
			int oddCnt = 0;
			int waterCnt = 0;
			
			for (int n = 0; n < N; n++) {
				tree[n] = sc.nextInt();
				K = Math.max(K, tree[n]);
			}
			
			for (int n = 0; n < N; n++)
				tree[n] = K - tree[n];

			for (int n = 0; n < N; n++) {
				evenCnt += (tree[n] / 2);
				oddCnt += (tree[n] % 2);
			}
			
			if (oddCnt == evenCnt) {
				waterCnt += 2 * evenCnt;
			} else if (oddCnt > evenCnt) {
				waterCnt += 2 * evenCnt + 2 * (oddCnt - evenCnt) - 1;
			} else {
				waterCnt += 2 * oddCnt;
				waterCnt += 4 * ((evenCnt - oddCnt) / 3);
				if ((evenCnt - oddCnt) % 3 == 1)
					waterCnt += 2;
				else if ((evenCnt - oddCnt) % 3 == 2)
					waterCnt += 3;
			}

			System.out.println("#" + tc + " " + waterCnt);
		}
	}
}
