import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			// 트리맵 : <값, 개수>
			TreeMap<Integer, Integer> pq = new TreeMap<>();
			
			int K = sc.nextInt();
			
			for (int k = 0; k < K; k++) {
                String cmd = sc.next();
                int num = sc.nextInt();
                
                if (cmd.equals("I")) {
                	pq.put(num, pq.getOrDefault(num, 0) + 1);
                }
                
                if (cmd.equals("D")) {
                	if (!pq.isEmpty()) {
                    	if (num == 1) {
                    		int min = pq.lastKey();
                    		int cnt = pq.get(min);
                    		if (cnt == 1)
                    			pq.remove(min);
                    		else
                    			pq.put(min, cnt - 1);
                    	} else {
                    		int max = pq.firstKey();
                    		int cnt = pq.get(max);
                    		if (cnt == 1)
                    			pq.remove(max);
                    		else
                    			pq.put(max, cnt - 1);
                    	}
                	}
                }
			}
			
			if (pq.isEmpty())
				System.out.println("EMPTY");
			else
				System.out.println(pq.lastKey() + " " + pq.firstKey());
			
		}//TC
	}
}