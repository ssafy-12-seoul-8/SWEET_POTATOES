import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	static int N;
	static int[] person;
	static int[][] dp;
	static Vector<Integer>[] v; // tree 저장 방식
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        person = new int[N + 1];
        dp = new int[N + 1][2]; // 0 or 1
        v = new Vector[N + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i <= N; i++) {
        	v[i] = new Vector<>();
        }
        
        for (int i = 1; i <= N; i++) {
        	person[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < N - 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	v[a].add(b);
        	v[b].add(a);
        }
        
//        for (int i = 0; i < N - 1; i++) {
//        	System.out.println(v[i]);
//        }
        
        dfs(1, 0);
        
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    
    static void dfs(int n, int parent) {
    	for (int node : v[n]) {
    		if (node != parent) {
    			// System.out.println("자식 노드 : " + node + ", 부모 노드 : " + n);
    			dfs(node, n);
    			// System.out.println("--------call function--------");
    			// System.out.println("자식 노드 : " + node + ", 부모 노드 : " + n);
    			dp[n][0] += Math.max(dp[node][0], dp[node][1]);
    			dp[n][1] += dp[node][0];
    			// for (int i = 0; i <= N; i++) {
    			//	  System.out.println(Arrays.toString(dp[i]));
    			// }
    			// System.out.println("--------console--------");
    		}
    	}
    	
    	// System.out.println("dp[" + n + "][1] 에 " + person[n] + " 더함");
    	dp[n][1] += person[n];
    	
    }
}