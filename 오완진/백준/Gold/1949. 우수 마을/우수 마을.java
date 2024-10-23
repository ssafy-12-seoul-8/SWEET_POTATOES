import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] heads;
	static List<Integer>[] roads;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		heads = new int[N + 1];
		roads = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			roads[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			heads[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int city1 = Integer.parseInt(st.nextToken());
			int city2 = Integer.parseInt(st.nextToken());
			
			roads[city1].add(city2);
			roads[city2].add(city1);
		}
		
		dp = new int[N + 1][2];
        getDp(1, 0);
        
//        for (int i = 1; i <= N; i++)
//        	System.out.println(Arrays.toString(dp[i]));
        
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    
    static void getDp(int selected, int parent) {
    	
    	dp[selected][0] = 0;
    	dp[selected][1] = heads[selected];
    	
    	for (int neighbor : roads[selected]) {
    		
    		if (neighbor == parent) continue;
    		
    		getDp(neighbor, selected);
    		
    		dp[selected][0] += Math.max(dp[neighbor][0], dp[neighbor][1]);
    		dp[selected][1] += dp[neighbor][0];
    	}
    }
}