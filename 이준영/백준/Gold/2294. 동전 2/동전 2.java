import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Set<Integer> set = new HashSet<>();
		int[] dp = new int[k+1];

		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		
		List<Integer> lst = new ArrayList<>();
		
		for (int i:set) {
			lst.add(i);
		}
		
		int len = lst.size();
		for(int i = 1 ; i <= k ; i++ ) {
			int min = 10001;
			for(int j = 0 ; j<len;j++) {
				if(lst.get(j)<=i) {
					min = Math.min(min, dp[i-lst.get(j)]+1);
				}
			}
			dp[i] = min;
		}
		
		int ans = dp[k];
		if(ans == 10001) {
			ans = -1;
		}
		System.out.println(ans);
		
	}
}
