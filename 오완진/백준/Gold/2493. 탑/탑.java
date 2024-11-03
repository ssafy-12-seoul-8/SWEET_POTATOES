import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		Stack<int[]> tower = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			
			int height = Integer.parseInt(st.nextToken());
			
			while (!tower.isEmpty()) {
				
				if (tower.peek()[1] >= height) {
					sb.append(tower.peek()[0]).append(" ");
					break;
				}
				
				tower.pop();
			}
			
			if (tower.isEmpty())
				sb.append(0).append(" ");
			
			tower.push(new int[] {i, height});
		}
		
		System.out.println(sb);
	}
}