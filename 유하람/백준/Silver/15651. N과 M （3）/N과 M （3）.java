import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int[] arr;
	static List<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		StringTokenizer st = new StringTokenizer(s);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		for(int i=0 ; i<n ; i++) {
			arr[i] = i+1;
		}
		
		int[] data = new int[m];
		NM(data, 0);
		
		String result = "";
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int[] d : list) {
			for(int i : d) {
				sb.append(i).append(" ");
				
			}
			sb.append("\n");
		}
		
		result = sb.toString();
		bw.write(result);
		bw.flush();
		bw.close();

	}
	
	static void NM(int[] data, int idx) {
		if(idx == m) {
			list.add(data.clone());
			return;
		}
		for(int i=0 ; i<n ; i++) {
			data[idx] = arr[i];
			NM(data, idx+1);
		}
	}
	


}
