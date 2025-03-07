import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int MOD = 1_000_000_007;
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        long[] input = new long[N + 1];
        
        for (int n = 1; n <= N; n++)
        	input[n] = Long.parseLong(br.readLine());
        
        SegmentTree sTree = new SegmentTree(N);
        sTree.init(input, 1, 1, N);
        
        for (int i = N+2; i <= N+M+K+1; i++) {

        	st = new StringTokenizer(br.readLine());
        	
        	int cmd = Integer.parseInt(st.nextToken());
        	long num1 = Long.parseLong(st.nextToken());
        	long num2 = Long.parseLong(st.nextToken());
        	
        	if (cmd == 1)
        		sTree.update(1, 1, N, num1, num2);
        	else {
        		long result = sTree.mul(1, 1, N, num1, num2);
        		sb.append(result).append("\n");
        	}
        }
        
        System.out.println(sb);
    }
    
    static class SegmentTree {
    	
    	long[] tree;
    	
    	SegmentTree(int n) {
    		tree = new long[4 * n];
    	}
    	
    	long init(long[] arr, int node, int start, int end) {
    		if (start == end)
    			return tree[node] = arr[start] % MOD;
    		else
    			return tree[node] = init(arr, node*2, start, (start+end)/2)
    								* init(arr, node*2+1, (start+end)/2+1, end) % MOD;
    	}
    	
    	long mul(int node, int nodeStart, int nodeEnd, long mulStart, long mulEnd) {
    		
    		if (nodeEnd < mulStart || mulEnd < nodeStart)
    			return 1;
    		else if (mulStart <= nodeStart && nodeEnd <= mulEnd)
    			return tree[node];
    		else
    			return mul(node*2, nodeStart, (nodeStart+nodeEnd)/2, mulStart, mulEnd)
    					* mul(node*2+1, (nodeStart+nodeEnd)/2+1, nodeEnd, mulStart, mulEnd) % MOD;
    	}
    	
    	long update(int node, int start, int end, long index, long value) {
    		
    		if (index < start || end < index)
    			return tree[node];
    		else if (start == index && end == index)
    			return tree[node] = value;
    		else
    			return tree[node] = update(node*2, start, (start+end)/2, index, value)
    								* update(node*2+1, (start+end)/2+1, end, index, value) % MOD;
    	}
    }
}