import java.util.*;

public class Solution {
    static int N, M;
    static List<Integer>[] order;
    static Map<String, Long> dp;
    static boolean[] visited;
    
    public static void main(String[] args) {
		
    	Scanner sc = new Scanner(System.in);
    	
    	int TC = sc.nextInt();
    	for (int tc = 1; tc <= TC; tc++) {
    		
    		N = sc.nextInt();
    		M = sc.nextInt();
    		
    		order = new ArrayList[N + 1];
    		for (int n = 0; n <= N; n++)
    			order[n] = new ArrayList<>();
    		
    		for (int m = 0; m < M; m++) {
    			int x = sc.nextInt();
    			int y = sc.nextInt();
    			order[y].add(x);
    		}
    		
    		dp = new HashMap<>();
    		visited = new boolean[N + 1];
    		
    		System.out.println("#" + tc + " " + btk());
    		
    	}//tc
    	
	}
    
    static long btk() {
    	
    	boolean allFinished = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                allFinished = false;
                break;
            }
        }
    	
    	if (allFinished) return 1;
    	
    	String stateKey = Arrays.toString(visited);
    	
    	if (dp.containsKey(stateKey))
    		return dp.get(stateKey);
    	
    	long simuls = 0;
    	for (int i = 1; i <= N; i++) {
    	    if (visited[i]) continue;
    	    
    	    boolean canFinish = true;
    	    for (int odr : order[i]) {
    	    	if (!visited[odr]) {
    	    		canFinish = false;
    	    		break;
    	    	}
    	    }
    	    
    	    if (canFinish) {
    	    	visited[i] = true;
    	    	simuls += btk();
    	    	visited[i] = false;
    	    }
    	}
    	
    	dp.put(stateKey, simuls);
    	return simuls;
    	
    }
}