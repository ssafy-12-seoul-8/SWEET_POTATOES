import java.io.*;
import java.util.*;
	
public class Main {
	
	static Queue<Cow> pq = new PriorityQueue<>(Comparator.comparingInt(cow -> cow.priority));
	static int maxWait, samplingEnd;
	
	static class Cow {
		int priority;
		int arrivedAt;
		int time;
		
		Cow(int priority, int arrivedAt, int time, int estimatedEnd) {
			this.priority = priority;
			this.arrivedAt = arrivedAt;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Cow[] cows = new Cow[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arrivedAt = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			cows[i] = new Cow(i, arrivedAt, time, arrivedAt + time);
		}
		
		Arrays.sort(cows, Main::compareArrival);
		
		samplingEnd = 0;
		maxWait = 0;
		
		for (int i = 0; i < n; i++) {
			Cow current = cows[i];
			
			if (current.arrivedAt <= samplingEnd) {
				pq.add(current);
				
				continue;
			}
			
			if (pq.isEmpty()) {
				samplingEnd = current.arrivedAt + current.time;
				
				continue;
			}
			
			proceedSampling(current);
			
			if (current.arrivedAt > samplingEnd) {
				samplingEnd = current.arrivedAt + current.time;
			}
		}
		
		proceedSampling(null);
		System.out.println(maxWait);
	}
	
	static int compareArrival(Cow c1, Cow c2) {
		if (c1.arrivedAt == c2.arrivedAt) {
			return c1.priority - c2.priority;
		}
		
		return c1.arrivedAt - c2.arrivedAt;
	}
	
	static void proceedSampling(Cow current) {
		while (!pq.isEmpty()) {
			Cow waiting = pq.poll();
			maxWait = Math.max(maxWait, samplingEnd - waiting.arrivedAt);
			samplingEnd += waiting.time;
			
			if (Objects.nonNull(current) && current.arrivedAt <= samplingEnd) {
				pq.add(current);
				
				return;
			}
		}
	}
	
}
