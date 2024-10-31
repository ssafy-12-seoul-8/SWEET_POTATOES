import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 시험지의 개수 N 
		int N = Integer.parseInt(st.nextToken());
		
		// 시험지를 나눌 그룹의 수 K (1<=K<=N<=10**5)
		int K = Integer.parseInt(st.nextToken());
		
		// 각 시험지마다 맞은 문제의 수 x (0<=x<=20)
		int[] X = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}
		
		int L = 0;
		int R = 2000000;
		
		while(L<=R) {
			int mid = (L+R)/2;
			
			// 나누어진 그룹의 수
			int cnt = 1;
			// 그룹의 점수 합
			int sum = 0;
			
			for(int x : X) {
				sum += x;
				
				if(sum>mid) {
					cnt++;
					sum = 0;
				}
			}
			
			
			if(cnt>K) {
				L = mid +1;
			}else {
				R = mid -1;
			}
			
		}
		
		System.out.println(L);
		
		
	} // main

}
// Main class
