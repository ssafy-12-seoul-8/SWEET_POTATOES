import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 현재 휴게소의 개수
		// 0 <= N <=50
		int N = Integer.parseInt(st.nextToken());
		
		// 더 지으려고 하는 휴게소의 개수
		// 1 <= M <= 100
		int M = Integer.parseInt(st.nextToken());
		
		// 고속도로 길이
		// 100 <= L <= 1000
		int L = Integer.parseInt(st.nextToken());
		
		// 휴게소 위치
		int[] restPlace = new int[N+2];
		st = new StringTokenizer(br.readLine());
		restPlace[0] = 0;
		for(int i=1 ; i<N+1 ; i++) {
			restPlace[i] = Integer.parseInt(st.nextToken());
		}
		restPlace[N+1] = L;
		
		Arrays.sort(restPlace);
		
		int low = 1;
		int up = L;
		
		while(low<=up) {
			// 휴게소가 없는 구간의 최대 길이 가정
			int mid = (low + up)/2;
			
			
			// 한 구간 안에서는 균등하게 나누었을때가 최대길이
			//	=>	가정한 최대 길이로 각 구간을 나누었을 때 
			//		m 보다 많은 휴게소를 세울 수 있다면
			//		최대 길이가 아님
			
			// 가능한 휴게소 수
			int cnt = 0;
			for(int i=0 ; i<N+1 ; i++) {
				cnt += (restPlace[i+1]-restPlace[i]-1)/mid;
			}
			
			if(cnt > M) {
				// 최대 길이 아님
				low = mid+1;
			}else {
				// 최대 길이가 될 가능성이 있음
				up = mid-1;
			}
			
		}
		
		System.out.println(low);
		
		
	} // main

} // Main class