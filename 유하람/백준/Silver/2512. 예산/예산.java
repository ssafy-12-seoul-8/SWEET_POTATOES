import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer> restPlace;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 지방의 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 예산 요청 최대 값
		long max = 0;
		
		// 각 지방의 예산 요청
		long[] want = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			want[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, want[i]);
		}
		
		// 총 예산 M
		long M = Long.parseLong(br.readLine());
		
		long L = 0;
		long R = M;
		
		while(L<=R) {
			
			long mid = (L+R)/2;
			
			long sum = 0;
			for(long w : want) {
				if(w>mid) {
					sum += mid;
				}else {
					sum += w;
				}
			}
			
			if(sum > M) {
				R = mid-1;
			}else {
				L = mid+1;
			}
			
		}
		if(R!=M) {
			System.out.println(R);
		}else {
			System.out.println(max);
		}
		
		
	} // main


} // Main class