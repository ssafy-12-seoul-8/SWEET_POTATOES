import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static class Node {

		Map<String, Node> child;
		int depth;
		String cur;
		ArrayList<Node> lst;

		public Node() {
			this.child = new HashMap<>();
			this.lst = new ArrayList<>();
			this.cur = "";
			this.depth = 0;
		}

	}

	public static class Trie {
		Node root;

		public Trie() {
			this.root = new Node();
		}

		public void insert(String[] str_arr) {
			int dep = 0;
			int len = str_arr.length;
			Node tmp = this.root;
			for (int i = 0; i < len; i++) {
				dep += 1;
				if (tmp.child.containsKey(str_arr[i])) {
					tmp = tmp.child.get(str_arr[i]);
				} else {
					Node new_node = new Node();
					new_node.cur = str_arr[i];
					tmp.child.put(str_arr[i], new_node);
					tmp.lst.add(new_node);
					tmp = new_node;
				}
				tmp.depth = dep;
			}
		}

		public void print() {

			StringBuilder sb = new StringBuilder();
			Set<Node> visited = new HashSet<>();
			Stack<Node> stack = new Stack<>();
			stack.push(root);

			while (!stack.isEmpty()) {
				Node tmp = stack.pop();
				if (!visited.contains(tmp)) {
					for (int i = 1; i < tmp.depth; i++) {
						sb.append("--");
						
					}
					if(tmp != this.root) {
						sb.append(tmp.cur).append("\n");
					}

					if (tmp.child.isEmpty()) {
						continue;
					} else {
						Collections.sort(tmp.lst, new Comparator<Node>() {
							@Override
							public int compare(Node p1, Node p2) {
								return p2.cur.compareTo(p1.cur);
							}
						});
						for (Node tmp_node : tmp.lst) {
							if (!visited.contains(tmp_node)) {
								stack.push(tmp_node);
							}
						}
					}
				}
			}

			System.out.println(sb);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] str_arr = new String[K];
			
			for (int j = 0; j < K; j++) {
				str_arr[j] = st.nextToken();
			}
			
			trie.insert(str_arr);
		}
		
		trie.print();

	}
}
