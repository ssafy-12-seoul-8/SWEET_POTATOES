import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			if (num1 == 0 && num2 == 0) {
				break;
			}

			if (num1 > num2) {
				sb.append("Yes\n");
			} else {
				sb.append("No\n");
			}

		}
		System.out.println(sb.toString());

	} // main

} // Main class
