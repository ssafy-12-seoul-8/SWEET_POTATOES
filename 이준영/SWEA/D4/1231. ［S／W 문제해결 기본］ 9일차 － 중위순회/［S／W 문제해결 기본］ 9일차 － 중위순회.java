import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;	
		for (int tc=1;tc<=10;tc++) {
			char[] arr = new char[257];
			int[] num = new int[129];
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			num[1]=1;
			for (int i=0;i<N;i++) {
				String[] tmp = br.readLine().split(" ");
				int a = Integer.parseInt(tmp[0]);
				char b = tmp[1].charAt(0);
				arr[num[a]] = b;
				if (tmp.length==4) {
					int c = Integer.parseInt(tmp[2]);
					int d =Integer.parseInt(tmp[3]);
					num[c] = num[a]*2;
					num[d] = num[a]*2+1;
				} else if (tmp.length==3) {
					int c = Integer.parseInt(tmp[2]);
					num[c] = num[a]*2;
				}
				
			}
			sb.append("#").append(tc).append(" ");
			inorder(1,arr,num);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	public static void inorder(int root,char[] arr,int[] num) {
		if (num[root]==0)
			return;
		inorder(root*2,arr,num);
		sb.append(arr[num[root]]);
		inorder(root*2+1,arr,num);
	}
}
