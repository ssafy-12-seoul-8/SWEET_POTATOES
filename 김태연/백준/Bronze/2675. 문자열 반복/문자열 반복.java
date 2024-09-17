import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int R = sc.nextInt();
			
			String line = sc.nextLine().trim();
			for (int i = 0; i < line.length(); i++) {
				for (int j = 0; j < R; j++) {
					sb.append(line.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
