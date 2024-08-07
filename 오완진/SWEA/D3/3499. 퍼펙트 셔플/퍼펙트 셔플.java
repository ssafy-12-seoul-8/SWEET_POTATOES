import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();
			sc.nextLine();

			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			List<String> card = new ArrayList<>();

			for (int n = 0; n < N; n++) {
				if (n < (N+1)/2)	// 6 -> 7 ~ 0 1 2 3 (3.5)
									// 7 -> 8 ~ 0 1 2 3 (4)
					queue1.offer(sc.next());
				else
					queue2.offer(sc.next());
			}
			sc.nextLine();
			
//			System.out.print("#" + t + " ");
//			System.out.println();
//			System.out.print("queue1: ");
//			for (String str : queue1)
//				System.out.print(str + " ");
//			System.out.println();
//			System.out.print("queue2: ");
//			for (String str : queue2)
//				System.out.print(str + " ");
//			System.out.println();

			if (N % 2 == 0) {		// 6 -> 0 2 4 / 1 3 5
				for (int n = 0; n < N/2; n++) {
					card.add(queue1.poll());
					card.add(queue2.poll());
				}
			} else {				// 7 -> 0 2 4 6 / 1 3 5
				for (int n = 0; n < N/2; n++) {
					card.add(queue1.poll());
					card.add(queue2.poll());
				}
					card.add(queue1.poll());
			}
			
			System.out.print("#" + t + " ");
			for (String str : card)
				System.out.print(str + " ");
			System.out.println();
		}
		
	}
}