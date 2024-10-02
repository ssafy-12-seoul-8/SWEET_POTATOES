import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (pq.isEmpty() && num == 0) {
				sb.append(0)
					.append(System.lineSeparator());
				
				continue;
			}
			
			if (num == 0) {
				sb.append(pq.poll())
					.append(System.lineSeparator());
				
				continue;
			}
			
			pq.add(num);
		}
		
		System.out.println(sb);
	}
	
}