import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] visited;
	static int count;
	static int[] arr1;
	static int[] arr2;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1; tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			count = 0; 
			arr1 = new int[9];
			arr2 = new int[9];
			visited = new boolean[9];
			Set<Integer> set = new HashSet<>();
			for(int i=0;i<9;i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
				set.add(arr1[i]);
			}
			int size = 0 ;
			for(int i=1;i<=18;i++) {
				if(!set.contains(i)) {
					arr2[size++]=i;
				}
			}
			btk(0,0);
			sb.append("#").append(tc).append(" ").append(362880-count).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	static void btk(int cur,int score) {
		if(cur==9) {
			if(score>=86) {
				count+=1;
			}
			return;
		} 
		for(int i=0;i<9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				if(arr2[i]>arr1[cur]) {
					btk(cur+1,score+arr2[i]+arr1[cur]);
				} else {
					btk(cur+1,score);
				}
				visited[i]=false;
			}
		}
	}
}
