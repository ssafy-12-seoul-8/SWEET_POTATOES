import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			int max = -10000000;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				arr1[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<M;i++) {
				arr2[i]=Integer.parseInt(st.nextToken());
			}
			if (N>M) {
				int tmp = N;
				N=M;
				M=tmp;
				int[] tmp_arr = arr1;
				arr1 = arr2;
				arr2 = tmp_arr;
			}
			for(int i=0;i<M-N+1;i++) {
				int count=0;
				for(int j=0;j<N;j++) {
					count+=arr1[j]*arr2[i+j];
				}
				if (max<count) {
					max=count;
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
