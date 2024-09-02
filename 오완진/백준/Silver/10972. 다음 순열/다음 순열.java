import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] NN = new int[N];
		boolean checked = false;
		for (int n = 0; n < N; n++)
			NN[n] = sc.nextInt();
		
		for (int n = N - 1; n > 0; n--) {
			// 뒤 인덱스부터 오름차순인 첫 인덱스 찾기 ~ 없으면 checked false 유지 ~ -1 출력됨
			if (NN[n - 1] < NN[n]) {
				// n번째 ~ 맨 뒤 N -1 중에 가장 작은 값을 n-1 번째랑 swap
				int idxN = -1;
				int minN = Integer.MAX_VALUE;
				for (int m = n; m < N; m++) {
					if (minN > NN[m] && NN[m] > NN[n-1]) {
						minN = NN[m];
						idxN = m;
					}
				}
				// swap 할 값이 없다면 다음 오름차순 찾기
				if (idxN == -1) continue;
				// Swap
				int tmp = NN[n - 1];
				NN[n - 1] = NN[idxN];
				NN[idxN] = tmp;
				// 나머지는 오름차순 정렬
				Arrays.sort(NN, n, N);
				checked = true;
				break;
			}
		}
		
		if (checked) {
			for (int num : NN)
				sb.append(num).append(" ");
			System.out.println(sb);
		} else
			System.out.println(-1);
		
	}
}