import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> pyramid = new ArrayList<>();
        
        int idx = 0;
        int tri = 0;
        int tet = 0;
        while (true) {

        	idx++;
        	tri += idx;
        	tet += tri;
        	
        	if (tet <= 300_000)
        		pyramid.add(tet);
        	else
        		break;
        }
        
        int M = pyramid.size();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++)
        	Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        dp[0][0] = 0;
        for (int i = 1; i <= M; i++) {
        	
        	int cnt = pyramid.get(i - 1);
        	for (int j = 0; j <= N; j++) {
        		
        		dp[i][j] = dp[i - 1][j];
        		
        		if (j >= cnt)
        			dp[i][j] = Math.min(dp[i][j], dp[i][j - cnt] + 1);
        	}
        }
        
        System.out.println(dp[M][N]);
    }
}