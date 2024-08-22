import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String r = br.readLine();
		StringTokenizer st2 = new StringTokenizer(r);
		
		int[] arr = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] data = new int[M];
		NM(N, M, arr, 0, data);
		
		String ans = sb.toString();
		bw.write(ans);
		bw.flush();
		bw.close();

	}
	
	static void NM(int N , int M, int[] arr, int depth, int[] data) {
		if(depth==M) {
			for(int i : data) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0 ; i<N ; i++) {
			data[depth] = arr[i];
			
			NM(N, M, arr, depth+1, data);
		}
		
			
	}
	


}
