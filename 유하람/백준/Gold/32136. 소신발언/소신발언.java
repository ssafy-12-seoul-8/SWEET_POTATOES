import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 소의 마리 수 
		// ( 2 <= N <= 300,000) 
		int N = Integer.parseInt(br.readLine());
		
		// 각 소의 얼음이 녹는데 걸리는 시간
		// ( 1<= a <= 500,000)
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 왼쪽의 인덱스
		int L = 0;
		// 오른쪽의 인덱스
		int R = N-1;
		
		while(L<R-1) {
			int mid = (L+R)/2;
			
			long max = arr[mid];
			int maxIdx = mid;
			
			for(int i=0 ; i<N ; i++) {
				long tmp = Math.abs(mid-i)*arr[i];
				if(tmp>max) {
					max = tmp;
					maxIdx = i;
				}
			}
			
			if(maxIdx<mid) {
				// 최대값이 기준점 왼쪽에 있는 경우
				R = mid;
			}else if(maxIdx>mid) {
				// 최대값이 기준점 오른쪽에 있는 경우
				L = mid;
			}else {
				L = mid;
				R = mid+1;
				break;
			}
			
		}
		
		long leftT = 0;
		long rightT = 0;
		
		for(int i=0 ; i<N ; i++) {
			// 히터가 L에 있을 떄 시간
			leftT = Math.max(leftT, Math.abs(i-L)*arr[i]);
			// 히터가 R에 있을 떄 시간
			rightT = Math.max(rightT, Math.abs(i-R)*arr[i]);
		}
		
		System.out.println(Math.min(leftT, rightT));
		
		
		
	}

}