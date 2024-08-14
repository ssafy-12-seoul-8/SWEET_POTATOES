import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		for (int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] arr = new String[2049];
			int[][] num1 = new int[N+1][2];
			for (int i=0;i<N;i++) {
				String[] tmp = br.readLine().split(" ");
				int a = Integer.parseInt(tmp[0]);
				String b = tmp[1];
				arr[a]=b;
				if (b.equals("-") ||b.equals("+")||b.equals("*")||b.equals("/")) {
					int c =Integer.parseInt(tmp[2]);
					int d =Integer.parseInt(tmp[3]);
					num1[a][0]=c;
					num1[a][1]=d;
				} 	
			}
			double k = inorder(1,arr,num1);
			int l=(int)k;
			sb.append("#").append(tc).append(" ").append(l).append("\n");
		}
		System.out.println(sb);
	
	}
	public static double inorder(int root, String[] arr,int[][] num1) {
		String str = arr[root];
		if (str.equals("-")) {
			return inorder(num1[root][0],arr,num1)-inorder(num1[root][1],arr,num1);
		} else if (str.equals("+")) {
			return inorder(num1[root][0],arr,num1)+inorder(num1[root][1],arr,num1);
		} else if (str.equals("*")) {
			return inorder(num1[root][0],arr,num1)*inorder(num1[root][1],arr,num1);
		} else if (str.equals("/")) {
			return inorder(num1[root][0],arr,num1)/inorder(num1[root][1],arr,num1);
		} else {
			return (double) Integer.parseInt(str);
		}
	}
}
