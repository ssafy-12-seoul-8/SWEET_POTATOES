import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static List<Integer> limits;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 칭호의 개수 N (1 <= N <= 10**5)
		N = Integer.parseInt(st.nextToken());
		
		// 캐릭터의 개수 M (1 <= M <= 10**5)
		int M = Integer.parseInt(st.nextToken());

		// 칭호명
		List<String> titles = new ArrayList<>();
		
		// 칭호 상한선
		limits = new ArrayList<>();
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			String title = st.nextToken();
			int limit = Integer.parseInt(st.nextToken());
			
			if(!limits.isEmpty() && limits.get(limits.size()-1)==limit) continue;
			
			titles.add(title);
			limits.add(limit);
			
		}
		
		N = limits.size()-1;
		
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int power = Integer.parseInt(st.nextToken());
			
			int idx = Check(power);
			sb.append(titles.get(idx)).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	} // main

	private static int Check(int power) {
		
		int L =  0;
		int R =  N;
		
		while(L<=R) {
			int mid = (L+R)/2;
			
			if(limits.get(mid)>=power) {
				// 가능
				R = mid-1;
			}else {
				// 불가능
				L = mid+1;
			}
		}
		
		return L;
	}

} // Main class