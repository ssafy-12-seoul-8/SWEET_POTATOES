import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int len = str.length();
			int i=0;
			int count=0;
			while(i<len-1) {
				char c = str.charAt(i);
				if (c=='(') {
					count+=1;
					i=i+2;
				} else if (c=='|') {
					char tmp = str.charAt(i+1);
					if (tmp == ')') {
						count+=1;
						i=i+2;
					} else {
						i=i+1;
					}
				} else {
					i+=1;
				}
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
}
