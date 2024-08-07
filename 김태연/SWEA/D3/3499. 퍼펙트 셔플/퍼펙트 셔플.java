import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;

//		int T = Integer.parseInt(br.readLine());	// 3 읽어옴
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			// 한 줄을 읽어옴
//			st = new StringTokenizer(br.readLine());	// 6 읽어옴

			int N;
			N = sc.nextInt();
			Queue<String> deck1 = new LinkedList<String>();
			Queue<String> deck2 = new LinkedList<String>();
			/*
			 * 예를 들어 N = 5 일 때, 2/N = 2 이고
			 * i = 0,1,2 에 대해서 deck1 으로 가고
			 * i = 3,4 는 deck2로 가야함
			 * 
			 * N = 4 일때 2/N = 2 이고
			 * i = 0,1 이 deck1
			 * i = 2,3 이 deck2로 가야함
			 */
			for (int i=0; i < N; i++) {
				String x = sc.next();
				// 홀 짝 판단
				// 먼저 짝수인 경우
				if (N % 2 == 0) {
					// 0,1 < 2 는 덱1, 2,3 !< 2 는 덱4 
					if (i < N/2) deck1.add(x);
					else deck2.add(x);
				} else {
					// 홀수의 경우
					if (i <= N/2) deck1.add(x);
					else deck2.add(x);
				}
			}
			
			System.out.print("#" + test_case);
			while (!(deck1.isEmpty() && deck2.isEmpty())) {
				if (!deck1.isEmpty())
				System.out.print(" " + deck1.poll());
				if (!deck2.isEmpty())
				System.out.print(" " + deck2.poll());
			}
			
			System.out.println();
		}
	}
}