import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int maxTree = 0;
        int[] tree = new int[N];
        for (int n = 0; n < N; n++) {
        	
        	tree[n] = Integer.parseInt(br.readLine());
        	maxTree = Math.max(maxTree, tree[n]);
        }
        
        long maxSum = 0;
        for (int i = 1; i <= maxTree; i++) {
        	
        	long sum = 0;
        	for (int j = 0; j < N; j++) {
        		
        		int cut = 0;
        		if (tree[j] >= i) {
        			
        			if (tree[j] % i == 0)
        				cut = tree[j] / i - 1;
        			else
        				cut = tree[j] / i;
        			
        			long cost = W * i * (tree[j] / i) - C * cut;
        			if (cost > 0)
        				sum += cost;
        		}
        	}
        	
        	maxSum = Math.max(maxSum, sum);
        }
        
        System.out.println(maxSum);
    }
}