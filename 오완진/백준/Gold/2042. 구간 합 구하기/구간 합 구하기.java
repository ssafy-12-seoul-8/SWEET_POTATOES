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
        		long result = sTree.sum(1, 1, N, num1, num2);
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
    			return tree[node] = arr[start];
    		else
    			return tree[node] = init(arr, node*2, start, (start+end)/2)
    								+ init(arr, node*2+1, (start+end)/2+1, end);
    	}
    	
    	long sum(int node, int nodeStart, int nodeEnd, long sumStart, long sumEnd) {
    		
    		if (nodeEnd < sumStart || sumEnd < nodeStart)
    			return 0;
    		else if (sumStart <= nodeStart && nodeEnd <= sumEnd)
    			return tree[node];
    		else
    			return sum(node*2, nodeStart, (nodeStart+nodeEnd)/2, sumStart, sumEnd)
    				   + sum(node*2+1, (nodeStart+nodeEnd)/2+1, nodeEnd, sumStart, sumEnd);
    	}
    	
    	long update(int node, int start, int end, long index, long value) {
    		
    		if (index < start || end < index)
    			return tree[node];
    		else if (start == index && end == index)
    			return tree[node] = value;
    		else
    			return tree[node] = update(node*2, start, (start+end)/2, index, value)
    								+ update(node*2+1, (start+end)/2+1, end, index, value);
    	}
    }
}