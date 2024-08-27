import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int max_k=0;
	static int L;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			max_k=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			btk(0,0,0,arr);
			sb.append("#").append(tc).append(" ").append(max_k).append("\n");
			
		}
		System.out.println(sb);
	}
	public static void btk(int index,int score,int cal,int[][] arr) {
		if(cal>L)
			return;
		if(index==N) {
			max_k=Math.max(max_k, score);
			return;
		}
		btk(index+1,score+arr[index][0],cal+arr[index][1],arr);
		btk(index+1,score,cal,arr);
		
	}
}
