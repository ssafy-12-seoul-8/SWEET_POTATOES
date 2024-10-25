import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());

		boolean[] arr = new boolean[21];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x = 0;
			if (!cmd.equals("all") && !cmd.equals("empty")) {
				x = Integer.parseInt(st.nextToken());
			}
			switch (cmd) {
			case "add":
				arr[x] = true;
				break;
			case "remove":
				arr[x] = false;
				break;
			case "check":
				if (arr[x]) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "toggle":
				if (arr[x]) {
					arr[x] = false;
				} else {
					arr[x] = true;
				}
				break;
			case "all":
				Arrays.fill(arr, true);
				break;
			case "empty":
				arr = new boolean[21];
				break;
			}
		}
		
		
		System.out.println(sb);
		
	} // main

}
// Main class
