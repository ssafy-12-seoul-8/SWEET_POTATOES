import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K, answer;
	static int[] papers;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	papers = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int n = 0; n < N; n++)
    		papers[n] = Integer.parseInt(st.nextToken());
    	
    	int L = 0;
    	int R = 2_000_000;
    	while (L <= R) {
    		
    		int M = (L + R) / 2;
    		
    		if (canMax(M)) {
    			answer = M;
    			L = M + 1;
    		} else {
    			R = M - 1;
    		}
    	}
    	
    	System.out.println(answer);
    }

    static boolean canMax(int minMaxScore) {
    	
    	int idx = 0;
    	int cnt = 0;
    	int score = 0;
    	
    	while (idx < N) {
    		
    		score += papers[idx++];
    		
			if (score >= minMaxScore) {
				score = 0;
				cnt++;
			}
    	}
    	
    	return cnt >= K;
    }
}