import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] num1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			N = Integer.parseInt(br.readLine());
			num1 = new int[N];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num1[i] = Integer.parseInt(st1.nextToken());
			}

			Arrays.sort(num1);

			int M = Integer.parseInt(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(st2.nextToken());
				if(check(0,N-1,num)) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				
			}

		}
		
		System.out.println(sb.toString());

	} // main

	private static boolean check(int L, int R , int num) {
		
		while(L<=R) {
			int mid = (L+R)/2;
			
			if(num1[mid]==num)
				return true;
			
			if(num<num1[mid]) {
				R=mid-1;
			}else {
				L=mid+1;
			}
		}
		
		return false;
	}


}
