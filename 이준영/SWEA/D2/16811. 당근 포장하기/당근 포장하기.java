import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int count = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			count=1001;
			int[] arr = new int[31];
			int[] arr2 = new int[31];
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				int s = Integer.parseInt(st.nextToken());
				arr[s]+=1;
			}
			for (int i=1;i<31;i++) {
				arr2[i]=arr2[i-1]+arr[i];
			}
			for (int i=1;i<29;i++) {
				for(int j=i+1;j<30;j++) {
					int a=arr2[i];
					int b=arr2[j]-arr2[i];
					int c=arr2[30]-arr2[j];
					if(a*b*c==0||a>N/2||b>N/2||c>N/2)
							continue;
					int result=0;
					if((a-b)*(a-c)<=0) {
						result=Math.abs(b-c);
					} else if ((b-a)*(b-c)<=0) {
						result=Math.abs(c-a);
					} else {
						result=Math.abs(a-b);
					}
					if (count>result) {
						count=result;
					}
				}
				
			}
			if (count==1001)
				count=-1;
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
}
