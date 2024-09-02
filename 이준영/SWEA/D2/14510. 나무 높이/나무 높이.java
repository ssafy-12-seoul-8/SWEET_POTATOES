import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			int[] count = new int[121];
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				count[arr[i]]+=1;
			}
			Arrays.sort(arr);
			int maxi = arr[N-1];
			int time = 0;
			while(true) {
				if(count[maxi]==N) {
					break;
				}
				time++;
				int c = (time+1)%2+1;
				if(c==2) {
					if(count[maxi-c]>0) {
						count[maxi-c]-=1;
						count[maxi] +=1;
						continue;
					}
					for(int i=1;i<maxi-2;i++) {
						if(count[i]>0) {
							count[i]-=1;
							count[i+c]+=1;
							break;
						}
					}
				} else {
					if(count[maxi-c]>0) {
						count[maxi-c]-=1;
						count[maxi] +=1;
						continue;
					} 
					if(count[maxi-2]>=2) {
						count[maxi-2]-=1;
						count[maxi-1]+=1;
						continue;
					} 
					for(int i=1;i<maxi-2;i++) {
						if(count[i]>0) {
							count[i]-=1;
							count[i+c]+=1;
							break;
						}
					}
				}
				
			}
			sb.append("#").append(tc).append(" ").append(time).append("\n");
		}
		System.out.println(sb);
	}
}
