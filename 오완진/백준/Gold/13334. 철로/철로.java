import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N, D;
	static int[] rail;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<int[]> persons = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if (A <= B)
				persons.add(new int[] {A, B});
			else
				persons.add(new int[] {B, A});
		}
		
		// 1. 오른쪽좌표[1]를 기준으로 오름차순 정렬
		// 2. 왼쪽좌표[0]를 기준으로 오름차순 정렬
		Collections.sort(persons, (a, b) -> {
			if (a[1] != b[1])
				return a[1] - b[1];
			else
				return a[0] - b[0];
		});

		int D = sc.nextInt();
		
//		for (int[] person : persons)
//			System.out.println(Arrays.toString(person));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int cnt = 0;
		int maxCnt = 0;
		for (int i = 0; i < N; i++) {
			int[] person = persons.get(i);
			int L = person[0];
			int R = person[1];
			int railL = R - D;
			
			while (!pq.isEmpty() && pq.peek() < railL) {
				pq.poll();
				cnt--;
			}
			
			if (L >= railL) {
				pq.add(L);
				cnt++;
			}
			
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		System.out.println(maxCnt);
	}
}