import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		int r = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(st.nextToken());
		
		N = (int)Math.pow(2, N);
		
		N /= 2;
		
		int sum = 0;
		
		while(N>0) {
			
			if(r<N && c<N) {
				
			}else if(r<N && c>=N) {
				c -= N;
				sum += N*N;
			}else if(r>=N && c<N) {
				r -= N;
				sum += N*N*2;
			}else {
				r -= N;
				c -= N;
				sum += N*N*3;
			}
			
			N /= 2;
		}
		
		System.out.println(sum);
		
	} // main



} // Main class
