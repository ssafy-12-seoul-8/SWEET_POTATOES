import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			
			System.out.print("#" + tc + " ");

			int N = sc.nextInt();
			for (int n = 0; n < N; n++) {
				int cmd = sc.nextInt();
				if (cmd == 1)
					maxHeap.add(sc.nextLong());
				else {
					if (!maxHeap.isEmpty()) {
						long data = maxHeap.poll();
						System.out.print(data + " ");
					} else
						System.out.print(-1 + " ");
				}
			}
			System.out.println();
		}
	}
	
}