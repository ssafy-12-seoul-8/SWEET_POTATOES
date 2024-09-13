import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		NavigableMap<Integer, Integer> dpq = new TreeMap<>();
		
		for (int t = 1; t <= cases; t++) {
			int n = Integer.parseInt(br.readLine());
			dpq.clear();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				
				switch (command) {
				case "I":
					dpq.put(number, dpq.getOrDefault(number, 0) + 1);
					break;
				case "D":
					if (dpq.isEmpty()) {
						break;
					}
					
					if (number > 0) {
						int lastCount = dpq.get(dpq.lastKey());
						
						if (lastCount == 1) {
							dpq.pollLastEntry();
						} else {
							dpq.put(dpq.lastKey(), lastCount - 1);
						}
					} else {
						int firstCount = dpq.get(dpq.firstKey());
						
						if (firstCount == 1) {
							dpq.pollFirstEntry();
						} else {
							dpq.put(dpq.firstKey(), firstCount - 1);
						}
					}
					
					break;
				}
			}
			
			if (dpq.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(dpq.lastKey() + " " + dpq.firstKey());
			}
		}
	}
	
}
