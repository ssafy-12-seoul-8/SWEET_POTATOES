import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		for (int i=1;i<=N;i++) {
			int count=0;
			String str = String.valueOf(i);
			int len = str.length();
			for (int j=0;j<len;j++) {
				char c = str.charAt(j);
				if (c=='3'||c=='6'||c=='9')
					count+=1;
			}
			if (count==0) {
				sb.append(i).append(" ");
			} else {
				for (int j=0;j<count;j++) {
					sb.append("-");
				}
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}
}
