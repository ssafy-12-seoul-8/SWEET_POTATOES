import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static int[] dn = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dm = {-1, 0, 1, 1, 1, 0, -1, -1};
	static char[][] map;
	static List<String> words;
	static HashMap<String, Integer>[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	map = new char[N][M];
    	for (int n = 0; n < N; n++)
    		map[n] = br.readLine().toCharArray();
    	
    	words = new ArrayList<>();
    	for (int k = 0; k < K; k++)
    		words.add(br.readLine());
    	
    	int maxKey = 10 * N + M;
    	dp = new HashMap[maxKey][6];
    	for (int i = 0; i < maxKey; i++)
    		for (int j = 0; j <= 5; j++)
    			dp[i][j] = new HashMap<>();
    	
    	for (int n = 0; n < N; n++) {
    		for (int m = 0; m < M; m++) {
    			int key = 10 * n + m;
    			dp[key][5] = getDp(key, 5);
    		}
    	}
    	
    	for (String word : words) {
    		
    		int cnt = 0;
    		int length = word.length();
        	for (int n = 0; n < N; n++) {
        		for (int m = 0; m < M; m++) {
        			int key = 10 * n + m;
        			
        			if (dp[key][length].containsKey(word))
        				cnt += dp[key][length].get(word);
        		}
        	}
    		
        	sb.append(cnt).append("\n");
    	}
    
    	System.out.println(sb);
    }
	
	static HashMap<String, Integer> getDp(int key, int length) {
		
		int nNow = key / 10;
		int mNow = key % 10;
		
		if (!dp[key][length].isEmpty())
			return dp[key][length];
			
		if (length == 1) {
			dp[key][length].put(map[nNow][mNow]+"", 1);
			return dp[key][length];
		}
		
		for (int d = 0; d < 8; d++) {
			int nPrev = (nNow + dn[d] + N) % N;
			int mPrev = (mNow + dm[d] + M) % M;
			int prevKey = 10 * nPrev + mPrev;
			
			for (String prevStr : getDp(prevKey, length - 1).keySet()) {
				String newStr = prevStr + map[nNow][mNow];
				dp[key][length].put(newStr, dp[key][length].getOrDefault(newStr, 0) + getDp(prevKey, length - 1).get(prevStr));
			}
		}
		
		return dp[key][length];
	}
}
