import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			// maxHeap (... 중간값) & minHeap (...)
			// 우선순위 큐 : poll -> maxHeap 에서는 가장 큰 값, minHeap 에서는 가장 작은 값
	        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	        PriorityQueue<Long> minHeap = new PriorityQueue<>();

			int N = sc.nextInt();
			long A = sc.nextLong();
			maxHeap.offer(A);
			long sum = 0;

			for (int n = 0; n < N; n++) {
				
				long mid = maxHeap.peek();
				long new1 = sc.nextLong();
				long new2 = sc.nextLong();
				// 둘 다 작거나 같으면 maxHeap에 넣고 maxHeap 하나 빼서 minHeap으로
				if (mid >= new1 && mid >= new2) {
					maxHeap.offer(new1);
					maxHeap.offer(new2);
					minHeap.offer(maxHeap.poll());
				// 둘 다 크면 minHeap에 넣고 minHeap 하나 빼서 maxHeap으로
				} else if (mid < new1 && mid < new2) {
					minHeap.offer(new1);
					minHeap.offer(new2);
					maxHeap.offer(minHeap.poll());
				} else {
					if (mid >= new1) {
						maxHeap.offer(new1);
						minHeap.offer(new2);
					} else {
						maxHeap.offer(new2);
						minHeap.offer(new1);
					}
				}
				
				mid = maxHeap.peek();
				sum = (sum + mid) % 20171109;
				
			}
			System.out.println("#" + tc + " " + sum);

		}
	}
}