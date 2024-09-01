import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
    	
    	// 1 ~ N 의 자연수
    	int[] arr = new int[N];
    	for(int i=0 ; i<N ; i++) {
    		arr[i] = i+1;
    	}
    	
    	int[] data = new int[M];
    	
    	combination(arr, N, data, M, 0, 0);
    	
    	String ans = sb.toString();
    	bw.write(ans);
    	bw.flush();
    	bw.close();
    	br.close();
    	
    }

	private static void combination(int[] arr, int n, int[] data, int m, int depth, int idx) {
		if(depth==m) {
			for(int i : data) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=idx ; i<n ; i++) {
			data[depth] = arr[i];
			combination(arr,n,data,m,depth+1,i);
		}
	}





    
}