import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String str1 = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String str2 = st.nextToken();
		
		int len1 = str1.length();
		int len2 = str2.length();
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<len1;i++) {
			if(str1.charAt(i)!=str2.charAt(len2-1)) {
				stack.add(str1.charAt(i));
			} else if(stack.size()<len2-1){
				stack.add(str1.charAt(i));
			} else {
				stack.add(str1.charAt(i));
				List<Character> tmp = stack.subList(stack.size()-len2,stack.size());
				sb = new StringBuilder();
				for(Character j:tmp) {
					sb.append(j);
				}
				String tmp2 = sb.toString();
				if(tmp2.equals(str2)) {
					for(int j=0;j<len2;j++) {
						stack.pop();
					}
				}
			}
		}
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			sb = new StringBuilder();
			for(char i:stack) {
				sb.append(i);
			}
			System.out.println(sb);
		}
	}
}
