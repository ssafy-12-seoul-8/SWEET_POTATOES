import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		int total = 0;
		int end =0;
		
		for(int t : time) {
			end += t;
			total += end;
		}
		
		System.out.println(total);
		
	} // main

}
// Main class
