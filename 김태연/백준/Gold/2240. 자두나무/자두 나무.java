package 자두나무;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int T,W;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		// 연속되는 양을 pq에 집어넣은 후, W+1 만큼 꺼내면 되는거 아닐까?
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int lastNumber = 1;	// 자두는 1번 자두에 위치해있다
		int count = 0;
		for (int i=0; i<T; i++) {
			int input = Integer.parseInt(br.readLine());
			if (i==0 && input==1) W++;
			// 방금 입력받은 수랑 같으면
			if (input == lastNumber) {
				count++;
			} else {
				// 방금 입력받은 수랑 다르면
				pq.add(count);
				count = 1;
				lastNumber = input;
			}
		}
		// 끝났을때 가진 값 넣어야함
		pq.add(count);
		
		int result = 0;
		
		for (int i=0; i<W; i++) {
			if (pq.isEmpty()) break;
			result += pq.poll();
		}
		
		System.out.println(result);
	}
}
