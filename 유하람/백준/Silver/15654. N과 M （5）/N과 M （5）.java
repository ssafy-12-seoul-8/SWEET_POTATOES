import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws Exception{
    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String nm = br.readLine();
    	StringTokenizer st = new StringTokenizer(nm);
    	
    	int N = Integer.parseInt(st.nextToken());
    	
    	int M = Integer.parseInt(st.nextToken());
    	
    	// N개의 자연수
    	int[] arr = new int[N];
    	String a = br.readLine();
    	StringTokenizer st2 = new StringTokenizer(a);
    	for(int i=0 ; i<N ; i++) {
    		arr[i] = Integer.parseInt(st2.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	boolean[] visited = new boolean[N];
    	int[] data = new int[M];
    	permutation(arr, N, data, M, 0, visited);
    	
    	String ans = sb.toString();
    	bw.write(ans);
    	bw.flush();
    	bw.close();
    	br.close();
    	
    }

	private static void permutation(int[] arr, int n, int[] data, int m, int depth, boolean[] visited) {
		if(depth==m) {
			for(int i : data) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0 ; i<n ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				data[depth] = arr[i];
				permutation(arr,n,data,m,depth+1,visited);
				visited[i] = false;
			}
		}
		
		
	}
    
}