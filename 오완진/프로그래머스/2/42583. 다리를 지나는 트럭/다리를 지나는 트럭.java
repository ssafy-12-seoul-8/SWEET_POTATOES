import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

    	int time = 0;
    	int sum = 0;
    	
    	Queue<Integer> trucks = new LinkedList<>();
    	for (int num : truck_weights)
    		trucks.add(num);
    	
    	Queue<Integer> bridge = new LinkedList<>();
    	for (int i = 0; i < bridge_length; i++)
    		bridge.add(0);
    	
    	while (!bridge.isEmpty()) {
    		time++;
    		sum -= bridge.poll();
    		
    		if (!(trucks.isEmpty())) {
    			if (sum + trucks.peek() <= weight) {
	    			sum += trucks.peek();
	    			bridge.add(trucks.poll());
    			} else {
    				bridge.add(0);
    			}
    		}
    		
    	}
    	return time;
    }
}