import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 보석 수
		int N = Integer.parseInt(st.nextToken());
		
		// 가방 수 
		int K = Integer.parseInt(st.nextToken());
		
		// 보석 정보 
		int[][] jewel = new int[N][2];
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			// 무게
			jewel[i][0] = Integer.parseInt(st.nextToken());
			// 가격
			jewel[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 보석 정렬
		Arrays.sort(jewel,(o1,o2)->Integer.compare(o1[0], o2[0]));
		
		// 가방 크기
		int[] bag = new int[K];
		
		for(int i=0 ; i<K ; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}

		// 크기 순 정렬
		Arrays.sort(bag);
		
		// 최대 가격의 보석을 저장할 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        int idx = 0;

        // 가방 크기 순서대로 처리
        for (int i = 0; i < K; i++) {
            // 현재 가방 크기보다 작거나 같은 보석을 우선순위 큐에 추가
            while (idx < N && jewel[idx][0] <= bag[i]) {
                pq.add(jewel[idx][1]); // 보석의 가격 추가
                idx++;
            }

            // 가장 비싼 보석을 가방에 담기
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

		
		System.out.println(sum);
				
		
	}	// main



}	// Main
