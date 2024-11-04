import java.util.*;
import java.io.*;

public class Main {
	
	static int[] d = { -1, 1 };
	static int sb, dongsang;
	static int[] distances;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = Integer.parseInt(st.nextToken());
		dongsang = Integer.parseInt(st.nextToken());
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
		distances = new int[100_001];
		int min = 0;
		
		Arrays.fill(distances, Integer.MAX_VALUE);
		queue.add(new int[] { sb, 0 });
		
		distances[sb] = 0;
		
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int loc = next[0];
			int dist = next[1];
			
			if (loc == dongsang) {
				min = dist;
				
				break;
			}
			
			for (int i = 0; i < 2; i++) {
				int nextLoc = loc + d[i];
				int nextDist = dist + 1;
				
				if (!isInMap(nextLoc) || distances[nextLoc] <= nextDist) {
					continue;
				}
				
				distances[nextLoc] = nextDist;
				
				queue.add(new int[] { nextLoc, nextDist });
			}
			
			int nextLoc = loc * 2;
			
			if (!isInMap(nextLoc) || distances[nextLoc] <= dist) {
				continue;
			}
			
			distances[nextLoc] = dist;
			
			queue.add(new int[] { nextLoc, dist });
		}
		
		System.out.println(min);
	}
	
	static boolean isInMap(int loc) {
		return loc >= 0 && loc < 100_001;
	}
	
}
