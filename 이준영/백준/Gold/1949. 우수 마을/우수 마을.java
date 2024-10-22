import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[] value;
	static ArrayList<Integer>[] child;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		value = new int[N + 1]; // 주민 수를 저장할 배열
		ArrayList<Integer>[] tree = new ArrayList[N + 1]; // 각 마을에 연결된 마을을 저장

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b); // a마을에도 b가 연결되고
			tree[b].add(a); // b마을에도 a가 연결된다.
		}

		boolean[] visited = new boolean[N + 1]; // 1번 마을을 루트 노드로 생각했을 때 각 노드의 자식노드를 저장할 것이다.
		Queue<Integer> queue = new LinkedList<>();
		child = new ArrayList[N + 1]; // 각 마을의 자식 노드들 저장

		for (int i = 1; i <= N; i++) {
			child[i] = new ArrayList<>();
		}

		queue.offer(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			visited[tmp] = true;
			for (int i : tree[tmp]) {
				if (!visited[i]) {
					child[tmp].add(i);
					queue.offer(i);
				}
			}
		}
		// 나를 포함한 하위트리에서 우수마을 선정 시 최대 주민수를 dp로 할 것이다.
		dp = new int[N + 1][3]; // 0번은 자신은 우수마을이 아니지만 우수자식이 존재, 1번은 자신도 우수하지 않고 자식들도 우수하지 않는 경우,
		fill(1); // 2번은 자신이 우수마을인 경우

		System.out.println(Math.max(dp[1][2], dp[1][0]));
	}

	static void fill(int a) {
		if (child[a].isEmpty()) {						// 자식이 없다는 건 리프 노드라는 뜻
			dp[a][2] = value[a];						// 따라서 2번 인덱스만 바꿔주면 된다.
			return;	
		}
		dp[a][2] = value[a];							// 내가 우수 마을이라면 자식들은 모두 우수마을이 아니므로 각 자식들을 포함한 하위트리에서 0번 인덱스와 1번인덱스중 최대를 더한다.
		for (int i : child[a]) {
			fill(i);
			dp[a][2] += Math.max(dp[i][0], dp[i][1]);
			dp[a][1] += dp[i][0];						// 내가 우수마을도 아니고 자식들도 우수마을이 아니라면 자식들의 자식들중 적어도 하나는 우수마을이어야 문제의 조건을 만족하므로 0번인덱스를 더한다.
		}

		boolean check = false;							// 내가 우수마을이 아닐 때 자식중에 우수마을이 하나라도 있는지를 확인할 변수
		int sum = 0;									// 일단 다 더하는 변수
		int min = 1000000001;							// 기본적으로 자식이 우수마을인지 아닌지에 대해 최적을 더할 것이다. 							
		for (int i : child[a]) {						// 하지만 부모가 우수마을이 아니므로 자식의 자식이 모두 우수마을이 아닌 경우는 고려하지 않으므로 2번 인덱스와 0번 인덱스만 비교하여 더한다.
			if (dp[i][2] >= dp[i][0]) {					// 2번 인덱스가 더 크면 이걸 고를거고 그렇다면 자식 중 하나는 우수마을이었다는 것이다.				
				check = true;		
				sum = sum + dp[i][2];
			} else {
				sum = sum + dp[i][0];					// 0번 인덱스가 더 크면 이걸 고를 것이다.
				if (min > dp[i][0]-dp[i][2]) {		    // min에는 0번인덱스와 2번인덱스의 차 중 가장 작은 것을 저장할 것이다.	
					min = dp[i][0]-dp[i][2];
				}
			}
		}

		if (check) {									// check가 true라는 것은 내 자식 중 적어도 1명은 우수마을이라는 것이다. 따라서 유효하게 우수마을을 골랐다.
			dp[a][0] = sum;
		} else {										// check가 false라는 것은 내 자식들이 모두 우수마을로 선정이 되지 않았다는 것이므로 하나의 마을은 우수마을로 선정해야 한다. 따라서 0번 인덱스와 2번 인덱스의 차이가 가장 작은 마을을 우수마을로 선정한다.
			dp[a][0] = sum -min;
		}
	}
}
