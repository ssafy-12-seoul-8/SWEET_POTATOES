import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0 ; t<T ; t++) {
			
			String str = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			
			boolean isOk = true;
			
			for(int i=0 ; i<str.length() ; i++) {
				char c = str.charAt(i);
				
				if(c=='(') {
					stack.push(c);
				}else if(!stack.isEmpty()) {
					stack.pop();
				}else {
					isOk = false;
					break;
				}
			}
			
			if(isOk && stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
		

	} // main

} // Main class