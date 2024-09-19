import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i=1; i<= N; i++) {
			queue.add(i);
		}
		
//		System.out.println(queue.poll());
		
		
		int lastNumber = -1;
		while (!queue.isEmpty()) {
		
			// 우선, 제일 위에 있는 카드를 바닥에 버린다
			lastNumber = queue.poll();
			
			// 그 다음, 카드가 남아있을 경우 제일 위에 있는 카드를 제일 아래로 보낸다
			if (!queue.isEmpty()) {
				queue.add(queue.poll());
			}
			
		}
		
		System.out.println(lastNumber);
	}
}
