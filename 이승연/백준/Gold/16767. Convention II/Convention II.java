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
		
		while (!pqA.isEmpty() || !pqO.isEmpty()) {

            // 도착 시간이 현재 시간 이전이거나 같은 소들을 대기 큐(pqO)에 추가
            while (!pqA.isEmpty() && pqA.peek().arrivalTime <= T) {
                pqO.add(pqA.poll());
            }

            // 대기 중인 소가 없다면, 다음 소의 도착 시간으로 T를 갱신
            if (pqO.isEmpty()) {
                if (!pqA.isEmpty()) {
                    T = pqA.peek().arrivalTime; // 다음 소가 도착할 시간으로 설정
                    continue;
                }
            }

            // 대기 중인 소가 있다면, 순서대로 소를 꺼내어 처리
            cow currCow = pqO.poll();
            maxWaitingTime = Math.max(maxWaitingTime, T - currCow.arrivalTime); // 대기 시간 계산
            T += currCow.eatingTime; // 소가 먹고 있는 시간을 더함
        }
		
		System.out.println(maxWaitingTime);
	}

}