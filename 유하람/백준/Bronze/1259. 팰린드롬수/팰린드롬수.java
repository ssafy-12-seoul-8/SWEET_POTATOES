import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String num = br.readLine();

			if (num.equals("0"))
				break;

			if (check(num)) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
			

		}

		System.out.println(sb);

	} // main

	private static boolean check(String num) {
		int len = num.length();

		for (int i = 0; i < len; i++) {
			if (num.charAt(i) != num.charAt(len - i - 1)) {
				return false;
			}
		}

		return true;
	}

}
// Main class
