import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 행 : 길이
		// 열 : 단어 집합
		
		
		PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
			if (a.length() == b.length()) {
				// 길이가 같을 때 사전순 정렬
				return a.compareTo(b);
			}
			else {	// 길이가 다를 때 길이 순으로 정렬
				return a.length() - b.length();
			}
		});
		
		// 중복 제거
		HashSet<String> set = new HashSet<>();
		
		
		int N = sc.nextInt();
		sc.nextLine();
		for (int i=0; i<N; i++) {
			
			String word = sc.nextLine();
			
			if (set.contains(word)) continue;
			else {
				set.add(word);	// 중복 단어 제외.
				pq.offer(word);	// 우선순위 큐에 단어 추가
			}
			
			
		}
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
