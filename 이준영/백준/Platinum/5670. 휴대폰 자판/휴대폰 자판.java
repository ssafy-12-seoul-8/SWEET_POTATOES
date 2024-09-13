import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int count;

	public static class Node {
		HashMap<Character, Node> child;
		boolean end;
		int child_count;

		public Node() {
			this.child = new HashMap<>();
			this.end = false;
			this.child_count = 0;
		}
	}

	public static class Trie {
		Node root;

		public Trie() {
			this.root = new Node();
		}

		public void insert(String str) {
			Node node = this.root;
			for (int i = 0; i < str.length(); i++) {
				node.child_count += 1;
				char c = str.charAt(i);
				node.child.putIfAbsent(c, new Node());
				node = node.child.get(c);
			}
			node.child_count+=1;
			node.end = true;
		}

		public void find_sum(Node node) {
			if (node.child.isEmpty()) {
				return;
			}
			if (node.child.size() >= 2 || node == root || node.end) {
				for (Node tmp : node.child.values()) {
					count += tmp.child_count;
					find_sum(tmp);
				}
			} else {
				for (Node tmp : node.child.values()) {
					find_sum(tmp);
				}
			}
			return;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb1 = new StringBuilder();
		while (true) {
			try {
				count = 0;
				st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				Trie trie = new Trie();
				
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					String str = st.nextToken();
					trie.insert(str);
				}
				
				trie.find_sum(trie.root);
				
				double result = (double) count / N * 100;
				result = (double) Math.round(result) / 100;
				String formattedNumber = String.format("%.2f", result);
				sb1.append(formattedNumber).append("\n");
			} catch (Exception e) {
//				System.out.println(e);
				break;
			}
		}
		System.out.println(sb1);
	}

}