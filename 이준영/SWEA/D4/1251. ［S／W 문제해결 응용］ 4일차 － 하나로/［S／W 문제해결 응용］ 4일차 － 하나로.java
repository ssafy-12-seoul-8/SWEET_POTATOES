import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] par;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long[][] arr = new long[N][2];
			par = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				par[i] = i; 
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			List<long[]> len = new ArrayList<>();
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					long length = (arr[i][0]-arr[j][0])*(arr[i][0]-arr[j][0])+(arr[i][1]-arr[j][1])*(arr[i][1]-arr[j][1]);
					len.add(new long[] {length,i,j});
				}
			}
			Collections.sort(len, new Comparator<long[]>() {
	            @Override
	            public int compare(long[] o1, long[] o2) {
	                return Long.compare(o1[0], o2[0]);
	            }
	        });
			int count = 0;
			long sum = 0;
			for(long[] l: len) {
				int a = (int)l[1];
				int b = (int)l[2];
				int c = union_find(a);
				int d = union_find(b);
				if(c==d) {
					continue;
				} else {
					sum = sum +l[0];
					par[d] = c;
					count+=1;
					if(count==N-1) {
						break;
					}
				}
			}
			st = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(st.nextToken());
			double tmp = (double) sum;
			tmp = tmp*E;
			sum = Math.round(tmp);
			sb.append("#").append(tc).append(" ").append(sum).append("\n");	
		}
		System.out.println(sb);
	}
	static int union_find(int x) {
		if(par[x]==x) {
			return x;
		}
		par[x] = union_find(par[x]);
		return par[x];
	}
}
