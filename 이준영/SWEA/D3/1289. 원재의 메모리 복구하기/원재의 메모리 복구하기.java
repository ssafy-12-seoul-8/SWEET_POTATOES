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
			int arr[] = new int[len];
			for (int i=0;i<len;i++) {
				arr[i] = Character.getNumericValue(str.charAt(i));
			}
			int check=0;
			int count=0;
			for (int i=0;i<len;i++) {
				if (arr[i]!=check) {
					check=arr[i];
					count+=1;
				}
			}
			sb.append('#').append(tc).append(' ').append(count).append('\n');
		}
		System.out.println(sb);
	}
}