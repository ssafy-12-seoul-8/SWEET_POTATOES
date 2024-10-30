import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열의 크기 (1<=N<=10**5)
		long N = Long.parseLong(br.readLine());
		
		// k
		long K = Long.parseLong(br.readLine());
		
		long L = 1;
		long R = N*N;
		
		while(L<=R) {
			long mid = (L+R)/2;
			long cnt = 0;
			
			for(int i=1 ; i<=N ; i++) {
				cnt += Math.min(mid/i, N);
			}
			
			if(cnt<K) {
				L = mid+1;
			}else{
				R = mid-1;
			}
			
		}
		
		System.out.println(L);
		
		
	}
}
