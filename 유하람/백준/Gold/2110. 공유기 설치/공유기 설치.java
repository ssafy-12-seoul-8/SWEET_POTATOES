import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 집의 개수
		// 2 <= N <= 200,000
		int N = Integer.parseInt(st.nextToken());
		
		// 공유기 개수
		// 2 <= C < = N
		int C = Integer.parseInt(st.nextToken());
		
		// 집의 좌표
		int[] coor = new int[N];
		
		
		for(int i=0 ; i<N ; i++) {
			coor[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coor);

		
		long L = 0;
		long R = 1000000000;
		
		while(L<=R) {
			long mid = (L+R)/2;
			
			long cnt = 0;
			long end = 0;
			for(int i=0 ; i<N ; i++) {
				if(coor[i]>=end) {
					end = coor[i]+mid;
					cnt++;
				}
			}
			
			// cnt 는 길이가 mid 인 공유기가 필요한 개수
			if(cnt<C) {
				R = mid-1;
			}else {
				L = mid+1;
			}
			
			
		}
		
		System.out.println(R);
		
		
	} // main


} // Main class