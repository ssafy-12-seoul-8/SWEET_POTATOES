import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		long count = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0 ; i < N ; i++) {
			count = (count + (long)arr[i]*(pow(2,i)-pow(2,N-1-i)))%1000000007;
		}
		
		System.out.println(count);

	}
	
	public static long pow(int a, int b) {
		if(b==0) {
			return (long)1;
		}
		long c = pow(a,b/2);
		
		if(b%2==0) {
			return (c*c)%1000000007;
		} 
		return (c*c*a)%1000000007;		
	}
}
