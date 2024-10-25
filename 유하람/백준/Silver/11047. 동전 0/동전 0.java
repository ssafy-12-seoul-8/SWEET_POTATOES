import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		int[] money = new int[N];
		
		for(int i=N-1 ; i>=0 ; i--) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		
		for(int m : money) {
			if(K==0) break;
			cnt += K/m;
			K %= m;
		}
		
		System.out.println(cnt);
		
	} // main

}
// Main class
