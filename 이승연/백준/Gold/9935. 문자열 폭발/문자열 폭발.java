import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String string = br.readLine();
		String boom = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < string.length(); i++) {
			stack.add(string.charAt(i));
		
			// stack 이 찼을 때 비교  
			if (stack.size() >= boom.length()) {
				boolean isBoom = true;
				for (int b = 1; b <= boom.length(); b++) {
					if (stack.get(stack.size() - b) != boom.charAt(boom.length() - b)) {
						isBoom = false;
						break;
					}
				}
				
				if (isBoom == true) {
					for (int b = 1; b <= boom.length(); b++) {
						stack.pop();
					}
				}
			}
		}
		
		// System.out.println(stack);
		
		if (stack.size() == 0) {
			bw.write("FRULA");
		} else {
			for (int b = 0; b < stack.size(); b++) {
				bw.write(stack.get(b));
			}
		}
		
		br.close();
		bw.close();
		
	}

}