import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int start=0;
		int end=N-1;
		while(end-start>1) {
			int mid = (end+start)/2;
			long max=0;
			int max_index=mid;
			for(int i=0;i<N;i++) {
				long a = Math.abs((i-mid)*arr[i]);
				if(a>max) {
					max=a;
					max_index=i;
				}
			}
			if(max_index>mid) {
				start=mid;
			} else {
				end=mid;
			}
		}
		long min=150000000001l;
		for(int i=-1;i<3;i++) {
			int tmp = start+i;
			long max=0;
			for(int j=0;j<N;j++) {
				long a = Math.abs((j-tmp)*arr[j]);
				if(a>max) {
					max=a;
				}
			}
			if (min>max) {
				min=max;
			}
		}
		System.out.println(min);
		
		
	}
}
