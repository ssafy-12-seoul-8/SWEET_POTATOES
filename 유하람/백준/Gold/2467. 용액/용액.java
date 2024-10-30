import java.io.*;
import java.util.*;

public class Main {

	static int[][] procession;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 전체 용액의 수 N (2<=N<=100,000)
		int N = Integer.parseInt(br.readLine());
		
		// 용액의 특성값 
		long[] solution = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			solution[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(solution);
		
		int L = 0;
		int R = N-1;
		
		long sol1 = 0;
		long sol2 = 0;
		
		long mix = Long.MAX_VALUE;
		
		while(L<R) {
			long tmp = solution[L] + solution[R];
			
			
			if(Math.abs(tmp)<mix) {
				sol1 = solution[L];
				sol2 = solution[R];
				mix = Math.abs(tmp);
				
				if(tmp==0) break;
			}
			
			if(tmp>0) {
				R--;
			}else {
				L++;
			}
			
		}
		
		if(sol1<sol2) {
			System.out.println(sol1+" "+sol2);
			
		}else {
			System.out.println(sol2+" "+sol1);
			
		}
		
		
	} // main

}
// Main class
