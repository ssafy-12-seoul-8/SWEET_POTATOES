import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static int N;
	static int M;
	static int K;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static char[][] world;
	static Trie[][] tries;

	static class Node {
		// 해당 경우가 몇 개 있는지
		int cnt;
		// 해당 문자가 몇 번째인지
		int idx;
		// 다음 노드들
		Map<Character, Node> child = new TreeMap<>();

		Node() {
		}

		Node(int idx) {
			this.cnt = 1;
			this.idx = idx;
		}
	}

	static class Trie {
		Node root;
		Node curr;

		Trie() {
			this.root = new Node();
			this.curr = root;
		}

		void Insert(int r, int c, int idx) {
			Insert(r, c, idx, root); // 초기 호출에서는 root를 사용
		}

		void Insert(int r, int c, int idx, Node currentNode) {
			if (idx > 5) {
				return;
			}

			char word = world[r][c];

			// 현재 노드에 문자를 삽입
			if (currentNode.child.containsKey(word)) {
				currentNode.child.get(word).cnt++;
			} else {
				currentNode.child.put(word, new Node(idx));
			}

			Node nextNode = currentNode.child.get(word);

			// 인접한 8방향을 탐색
			for (int d = 0; d < 8; d++) {
				int nr = (r + dr[d] + N) % N;
				int nc = (c + dc[d] + M) % M;

				// 재귀적으로 삽입
				Insert(nr, nc, idx + 1, nextNode);
			}
		}


		int Count(String target) {
		    curr = root;
		    int count = 0;

		    for (int i = 0; i < target.length(); i++) {
		        char c = target.charAt(i);
		        if (!curr.child.containsKey(c)) {
		            return 0; // 해당 문자가 없으면 바로 0 반환
		        }
		        curr = curr.child.get(c); // 다음 노드로 이동
		    }

		    // target 문자열이 Trie에 존재하면, 해당 노드의 cnt를 반환
		    return curr.cnt; 
		}


//		///////////////////////////////////////////////////
//		void Print(Node node, StringBuilder prefix) {
//			if (node != root) {
//				System.out.println(prefix.toString() + " : " + node.cnt);
//			}
//			for (Map.Entry<Character, Node> entry : node.child.entrySet()) {
//				char ch = entry.getKey();
//				Node childNode = entry.getValue();
//				Print(childNode, new StringBuilder(prefix).append(ch));
//			}
//		}
//
//		void Check() {
//			System.out.println("-----------------------");
//			System.out.println("Trie 상태:");
//			Print(root, new StringBuilder());
//			System.out.println("-----------------------");
//		}
//
//		////////////////////////////////////////////////////

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 행 (3 <= N <= 10)
		N = Integer.parseInt(st.nextToken());
		// 열 (3 <= M <= 10)
		M = Integer.parseInt(st.nextToken());
		// 신이 좋아하는 문자열 (1<= K <= 5)
		K = Integer.parseInt(st.nextToken());

		// 세상을 이루는 소문자
		world = new char[N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				world[i][j] = row.charAt(j);
			}
		}

		tries = new Trie[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {

				tries[r][c] = new Trie();
				tries[r][c].Insert(r, c, 1);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			int answer = 0;
			
			String target = br.readLine();

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
//					tries[r][c].Check();
					answer += tries[r][c].Count(target);
				}
			}

			sb.append(answer).append("\n");

		}

		System.out.println(sb.toString());

	} // main

} // Main class
