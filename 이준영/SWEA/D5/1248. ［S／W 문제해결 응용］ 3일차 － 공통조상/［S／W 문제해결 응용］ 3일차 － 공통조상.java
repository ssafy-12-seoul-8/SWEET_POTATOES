import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int count=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			count=0;
			ArrayList<Integer>[] arr = new ArrayList[V+1];
			ArrayList<Integer>[] arr2 = new ArrayList[V+1];
			int[] depth = new int[V+1];
			for (int i=1;i<V+1;i++) {
				arr[i] = new ArrayList<>();
				arr2[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<E;i++) {
				int c = Integer.parseInt(st.nextToken());;
				int d = Integer.parseInt(st.nextToken());
				arr[c].add(d);
				arr2[d].add(c);
			}
			ready(1,0,arr,depth);
			if (depth[a]<depth[b]) {
				int tmp=a;
				a=b;
				b=tmp;
			}
			int l = depth[a]-depth[b];
			for(int i=0;i<l;i++) {
				a=arr2[a].get(0);
			}
			while(a!=b) {
				a=arr2[a].get(0);
				b=arr2[b].get(0);
			}
			sb.append("#").append(tc).append(" ").append(a).append(" ");
			find_size(a,arr);
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	public static void ready(int root,int count, ArrayList<Integer>[] arr,int[] depth) {
		depth[root] = count;
		if(!arr[root].isEmpty()) {
			for(int i:arr[root]) {
				ready(i,count+1,arr,depth);
			}
		}
	}
	public static void find_size(int a,ArrayList<Integer>[] arr) {
		count=count+1;
		if(arr[a].isEmpty())
			return;
		for(int i:arr[a]) {
			find_size(i,arr);
		}
		
	}
	
}
