import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] nums;
	static boolean[] visited;
	static List<Character> operators;
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		operators = new ArrayList<>();
		
		// operators C (N - 1)
		
		for (int i = 0; i < 4; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < num; j++) {
				if (i == 0) {
					operators.add('+');
				} else if (i == 1) {
					operators.add('-');
				} else if (i == 2) {
					operators.add('*');
				} else if (i == 3) {
					operators.add('/');
				}
			}
		}
		
		int[] selection = new int[N - 1];
		visited = new boolean[N - 1];
		
		combination(0, selection);
		
		bw.write(max + "\n");
		bw.write(min + "");
		
		br.close();
		bw.close();
	}
	
	public static void combination(int sel_idx, int[] selection) {
		if (sel_idx == N - 1) {
			// System.out.println(Arrays.toString(selection));
			
			int total = nums[0];
			
			for (int i = 1; i < nums.length; i++) {
				char op = operators.get(selection[i - 1]);
				
				if (op == '+') {
					total += nums[i];
				} else if (op == '-') {
					total -= nums[i];
				} else if (op == '*') {
					total *= nums[i];
				} else if (op == '/') {
					total /= nums[i];
				}
			}
			
			if (max < total) {
				max = total;
			} 
			
			if (min > total) {
				min = total;
			}
			
			return;
		}
			for (int i = 0; i < operators.size(); i++) {
				if (visited[i] == false) {
					visited[i] = true;
					selection[sel_idx] = i;
					combination(sel_idx + 1, selection);
					visited[i] = false;
				}
			}
	}
	
}
