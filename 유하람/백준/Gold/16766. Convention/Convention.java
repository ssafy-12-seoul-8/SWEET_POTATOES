import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 소의 마리 수 (1<=N<=10**5)
		int N = Integer.parseInt(st.nextToken());
		
		// 버스의 수 (1<=M<=10**5)
		int M = Integer.parseInt(st.nextToken());
		
		// 버스에 탈 수 있는 소의 수 C
		int C = Integer.parseInt(st.nextToken());
		
		
		// 소의 도착 시간
		int[] arrive = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			arrive[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrive);
		
		long L = 0;
		long R = (long) Math.pow(10, 9);
		
		while(L<=R) {
			// 소가 기다리는 시간
			long mid = (L+R)/2;
			
			int cnt = 0;
			long start = arrive[0];
			int cntB = 1;
			
			for(int t : arrive) {
				if(cnt==C || t-start>mid) {
					cntB++;
					cnt = 0;
					start = t;
				}
				cnt++;
			}
			
			
			if(cntB>M) {
				// 불가능
				L = mid+1;
			}else {
				// 가능
				R = mid-1;
			}
			
		}
		
		System.out.println(L);
		
		
	} // main

}
// Main class
