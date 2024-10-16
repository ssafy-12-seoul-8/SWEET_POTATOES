import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class cow {
	int arrivalTime;
	int eatingTime;
	int order;
	
	cow(int arrivalTime, int eatingTime, int order) {
		this.arrivalTime = arrivalTime;
		this.eatingTime = eatingTime;
		this.order = order;
	}

	@Override
	public String toString() {
		return "cow [arrivalTime=" + arrivalTime + ", eatingTime=" + eatingTime + ", order=" + order + "]";
	}

}

public class Main {

	static int N; // 마리 수 (소)
	static Queue<cow> pqA = new PriorityQueue<>((cow c1, cow c2) -> c1.arrivalTime - c2.arrivalTime);
	static Queue<cow> pqO = new PriorityQueue<>((cow c1, cow c2) -> c1.order - c2.order);
	static long T;
	static long maxWaitingTime = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int at = Integer.parseInt(st.nextToken());
			int et = Integer.parseInt(st.nextToken());
			
			pqA.add(new cow(at, et, n));
			min = Math.min(min, at);
		}
		
		T = min;
		
		while(!pqA.isEmpty() || !pqO.isEmpty()) {
			
			while(!pqA.isEmpty() && pqA.peek().arrivalTime <= T) {
				pqO.add(pqA.poll());
			}
			
			if (pqO.isEmpty() && !pqA.isEmpty()) {
				T = pqA.peek().arrivalTime;
				continue;
			}
			
			cow currCow = pqO.poll();
			
			maxWaitingTime = Math.max(maxWaitingTime, T - currCow.arrivalTime);
			T += currCow.eatingTime;
		}
		
		System.out.println(maxWaitingTime);
	}

}