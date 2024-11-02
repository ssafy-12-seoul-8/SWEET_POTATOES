import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) {
					return 1;
				} else if (o1[0] < o2[0]) {
					return -1;
				} else {
					if (o1[1] > o2[1]) {
						return 1;
					} else {
						return -1;
					}
				}
			}

		});
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.add(new int[] {x,y});
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			sb.append(tmp[0]+" "+tmp[1]+"\n");
		}
		
		System.out.println(sb);
		

	} // main

}
// Main class
