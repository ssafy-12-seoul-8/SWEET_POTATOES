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
    	
    	int[] visited = new int[10000];
    	
    	// N개의 자연수
    	int[] arr = new int[N];
    	String a = br.readLine();
    	StringTokenizer st2 = new StringTokenizer(a);
    	for(int i=0 ; i<N ; i++) {
    		arr[i] = Integer.parseInt(st2.nextToken());
    		visited[arr[i]]++;
    	}
    	
    	Arrays.sort(arr);
    	
    	int[] data = new int[M];
    	
    	combination(arr,N,data,M,0,0,visited);
    	
    	String ans = sb.toString();
    	bw.write(ans);
    	bw.flush();
    	bw.close();
    	br.close();
    	
    }

	private static void combination(int[] arr, int n, int[] data, int m, int depth, int idx, int[] visited) {
		if(depth==m) {
			for(int i : data) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1; // 같은 레벨(깊이)에서 중복 값 뽑지 않기 위해
		
		for(int i=idx ; i<n ; i++) {
			if(visited[arr[i]]>0 && arr[i]!=prev) {
				visited[arr[i]]--;
				data[depth] = arr[i];
				prev = arr[i];
				combination(arr,n,data,m,depth+1,i+1,visited);
				visited[arr[i]]++;
			}
		}
		
		
	}


    
}