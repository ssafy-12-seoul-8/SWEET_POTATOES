import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			/*
			 * Deque = Stack + Queue
			 * offerFirst & offerLast
			 * pollFirst & pollLast
			 * peekFirst & peekLast
			 */
			Deque<Integer> deque1 = new LinkedList<>();
			Deque<Integer> deque2 = new LinkedList<>();
			for (int n = 0; n < N; n++)
				deque1.offerLast(sc.nextInt());
			for (int m = 0; m < M; m++)
				deque2.offerLast(sc.nextInt());

			int N1;
			int N2;
			Deque<Integer> dequeL;
			Deque<Integer> dequeS;
			N1 = (N >= M) ? N : M;
			N2 = (N >= M) ? M : N;
			dequeL = (N >= M) ? deque1 : deque2;
			dequeS = (N >= M) ? deque2 : deque1;
			
			for (int n = 0; n < N1-N2; n++)
				dequeS.offerLast(0);			// 사이즈 맞추기
			
			long max = 0;
			for (int n = 0; n <= N1-N2; n++) {	// 미는 횟수
				long sum = 0;
				for (int m = 0; m < N1; m++) {	// 0~N-1 합
					int num1 = dequeL.pollFirst();
					int num2 = dequeS.pollFirst();
					sum += num1 * num2;
					dequeL.offerLast(num1);
					dequeS.offerLast(num2);
				}
				max = Math.max(max, sum);
				dequeS.offerFirst(dequeS.pollLast());
			}
			
			System.out.println("#" + tc + " " + max);
		}
		
	}
}