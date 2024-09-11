import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] len = new int[M];
		HashSet<Integer>[] set_array = new HashSet[M];
		ArrayList<Integer>[] set_lst = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			
			set_lst[i] = new ArrayList<>();
			
		}

		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			set_array[i] = new HashSet<>();
			
			for (int j = 0; j < K; j++) {
				
				int a = Integer.parseInt(st.nextToken());
				
				set_array[i].add(a);
				set_lst[a].add(i);
				
				if (a == 1) {
					queue.add(i);
					len[i] = 2;
				}
			}
		}
		if (N == 1) {
			System.out.println(1);
		} else {
			int ans = -1;
			
			while (!queue.isEmpty()) {
				int a = queue.poll();
				
				if (set_array[a].contains(N)) {
					ans = len[a];
					break;
				}
				
				for (int i : set_array[a]) {
					for (int j : set_lst[i]) {
						if (len[j] == 0) {
							len[j] = len[a] + 1;
							queue.add(j);
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
}
