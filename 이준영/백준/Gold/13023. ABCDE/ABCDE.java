import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean check=false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N];
		ArrayList<Integer>[] fri = new ArrayList[N];
		for(int i=0;i<N;i++) {
			fri[i]= new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			fri[a].add(b);
			fri[b].add(a);
		}
		for(int i=0;i<N;i++) {
			if(check)
				break;
			visited[i]=true;
			btk(i,0,visited,fri);
			visited[i]=false;
		}
		if(check) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	public static void btk(int cur,int count,boolean[] visited,ArrayList<Integer>[] fri) {
		if(check)
			return;
		if(count==4) {
			check=true;
			return;
		}
		for(int i:fri[cur]) {
			if (!visited[i]) {
				visited[i]=true;
				btk(i,count+1,visited,fri);
				visited[i]=false;
			}
		}
	}
}
