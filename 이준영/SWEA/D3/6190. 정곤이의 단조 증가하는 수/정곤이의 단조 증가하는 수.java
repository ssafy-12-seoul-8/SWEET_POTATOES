
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			int max=0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			for (int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					int num = arr[i]*arr[j];
					int temp = num;
					int last = num%10;
					while (num>0 && last>=num%10) {
						last=num%10;
						num=num/10;
					} 
					if (num==0 && max<temp) {
						max=temp;
					}
				}
			}
			if(max==0) {
				sb.append('#').append(tc).append(' ').append(-1).append('\n');
			} else {
				sb.append('#').append(tc).append(' ').append(max).append('\n');
			}
			
		}
		System.out.println(sb);
	}
}
