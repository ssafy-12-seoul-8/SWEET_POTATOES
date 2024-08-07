import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int M = sc.nextInt();
			int N = sc.nextInt();
			int[] cardM = new int[M];
			int[] cardN = new int[N];
			int[] count = new int[M+N];
			
			for (int m = 0; m < M; m++) {
				for (int n = 0; n < N; n++) {
					count[m+n]++;
				}
			}

			int max = -1;
			List<Integer> maxList = new ArrayList<>();
			for (int c = 0; c < count.length; c++) {
				if (count[c] > max) {
					maxList = new ArrayList<>();
					max = count[c];
					maxList.add(c);
				} else if (count[c] == max) {
					maxList.add(c);
				} else {
					continue;
				}
			}
			
			System.out.print("#" + t + " ");
			for (int num : maxList)
				// M과 N 인덱스 계산될때 1씩 빠진걸 다시 추가
				System.out.print((num+2) + " ");
			System.out.println();
		}
		
	}
}