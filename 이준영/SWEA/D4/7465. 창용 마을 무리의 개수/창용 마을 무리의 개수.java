import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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
			int M = Integer.parseInt(st.nextToken());
			
			par = new int[N+1];
			
			for(int i=1;i<=N;i++) {
				par[i] = i;
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = union_find(a);
				int d = union_find(b);
				
				if(c==d) {
					continue;
				} else {
					par[d] = c;
				}
			}
			
			int count = 0;
			for(int i=1;i<=N;i++) {
				if(par[i]==i) {
					count+=1;
				}
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
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
