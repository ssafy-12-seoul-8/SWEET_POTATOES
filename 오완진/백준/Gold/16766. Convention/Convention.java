import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, B, C;
	static int[] cows;
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        cows = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            cows[i] = Integer.parseInt(st.nextToken());
    	
    	Arrays.sort(cows);
    	
    	int L = 0;			// 불가능
    	int R = cows[N-1];	// 가능
    	int answer = R;
    	
    	while (L <= R) {
    		
    		int M = (L + R) / 2;
    		
    		if (canCarry(M)) {
    			answer = M;
    			R = M - 1;
    		}
    		else
    			L = M + 1;
    	}
    	
    	System.out.println(answer);
    }
    
    static boolean canCarry(int M) {
    	
    	int idx = 0;
    	int cntBus = 0;
    	
    	while (idx < N) {
    		
    		cntBus++;
    		
    		int time = cows[idx];
    		int cntCow = 0;
    		
    		while (idx < N) {
    			// 정원 초과 ~ 버스 출발
    			if (cntCow >= C) break;
    			// 시간 초과 ~ 버스 출발
    			if (cows[idx] - time > M) break;

    			idx++;
    			cntCow++;
    		}
    	}
    	
    	return cntBus <= B;
    }
}