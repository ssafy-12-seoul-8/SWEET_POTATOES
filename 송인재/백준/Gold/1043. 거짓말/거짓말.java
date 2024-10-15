import java.io.*;
import java.util.*;
	
public class Main {
	
	static boolean[] truth;
	static boolean[] visited;
	static Map<Integer, List<Integer>> parties = new HashMap<>();
	static Map<Integer, List<Integer>> participants = new HashMap<>();
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		truth = new boolean[m + 1];
		st = new StringTokenizer(br.readLine());
		int knowTotal = Integer.parseInt(st.nextToken());
		int[] whoKnows = new int[knowTotal];
		
		for (int i = 0; i < knowTotal; i++) {
			whoKnows[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int participantCount = Integer.parseInt(st.nextToken());
			
			parties.putIfAbsent(i, new ArrayList<>());
			
			List<Integer> inParty = parties.get(i);
			
			for (int j = 0; j < participantCount; j++) {			
				int participant = Integer.parseInt(st.nextToken());
				
				inParty.add(participant);
				participants.putIfAbsent(participant, new ArrayList<>());
				participants.get(participant)
						.add(i);
			}
		}
		
		for (int i = 0; i < knowTotal; i++) {
			dfs(whoKnows[i]);
		}
		
		int count = 0;
		
		for (int i = 1; i <= m; i++) {
			if (!truth[i]) {
				count++;
			}
		}
		
		System.out.println(count);
	}
    
    static void dfs(int warning) {
    	visited[warning] = true;
    	
    	if (!participants.containsKey(warning)) {
    		return;
    	}
    	
    	for (int warnedParty : participants.get(warning)) {
    		truth[warnedParty] = true;
    		
    		for (int participant : parties.get(warnedParty)) {
    			if (visited[participant]) {
    				continue;
    			}
    			
    			dfs(participant);
    		}
    	}
    }
	
}
