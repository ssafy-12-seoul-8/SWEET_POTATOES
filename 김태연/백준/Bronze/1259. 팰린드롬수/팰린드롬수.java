import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		
		while (true) {
			String line = br.readLine();
			
			int input = Integer.parseInt(line);
			
			if (input == 0) break;
			
			if (isPelindrome(line) ) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
		}
	}
	
	static boolean isPelindrome(String input) {
		for (int i=0; i< input.length() / 2; i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}
}
