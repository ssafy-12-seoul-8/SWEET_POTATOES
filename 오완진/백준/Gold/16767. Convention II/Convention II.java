import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	
    	// 도착시간~시니어 순
    	PriorityQueue<int[]> cows = new PriorityQueue<>((a, b) -> {
    		if (a[1] != b[1])
    			return a[1] - b[1];
    		return a[0] - b[0];
    	});
    	
    	// 시니어 순
    	PriorityQueue<int[]> waitingCows = new PriorityQueue<>((a, b) -> {
    		return a[0] - b[0];
    	});
    	
    	// 시니어 도착시간 섭취시간
    	for (int i = 0; i < N; i++)
    		cows.add(new int[] {i, sc.nextInt(), sc.nextInt()});
    	
    	int time = 0;
    	int maxWaitingTime = 0;
    	while (!cows.isEmpty()) {
    		
    		if (!waitingCows.isEmpty()) {
    			
    			int[] eatingCow = waitingCows.poll();
    			maxWaitingTime = Math.max(maxWaitingTime, time - eatingCow[1]);
    			time += eatingCow[2];
    		} else {
    			
    			int[] eatingCow = cows.poll();
    			time = eatingCow[1] + eatingCow[2];
			}
    		
    		while (true) {
    			if (!cows.isEmpty()) {
    				int[] firstCow = cows.peek();
    				
    				if (firstCow[1] > time) break;
    				
    				waitingCows.add(cows.poll());
    			} else
    				break;
    		} 
    	}
    	
    	System.out.println(maxWaitingTime);
    }
}