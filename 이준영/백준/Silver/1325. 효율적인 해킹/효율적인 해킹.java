import java.io.*;
import java.util.*;

public class Main{
	static int n,m,a,b;
	static ArrayList<Integer>[] list;
	static boolean visit [];
	static int depth[];
	static int max;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		list=new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			list[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		depth=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			visit=new boolean[n+1];
			Queue <Integer>queue=new LinkedList<Integer>();
			queue.add(i);
			visit[i]=true;
			while(!queue.isEmpty()) {
				int n=queue.poll();
				for(int date:list[n]) {
					if(!visit[date]) {
						queue.add(date);
						visit[date]=true;
						depth[date]++;
					}
					
				}
			}

		}
		max=0;
		for(int date:depth) {
			max=Math.max(max, date);
		}
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=n;i++) {
			if(depth[i]==max) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);		
	}
}