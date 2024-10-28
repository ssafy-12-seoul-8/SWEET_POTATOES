import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static Map<String, String[]> tree;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 노드의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 트리 
		tree = new HashMap<>();
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String parent = st.nextToken();
			tree.put(parent, new String[2]);
			tree.get(parent)[0] = st.nextToken();
			tree.get(parent)[1] = st.nextToken();
		}
		
		sb = new StringBuilder();
		
		pre("A");
		sb.append("\n");
		mid("A");
		sb.append("\n");
		post("A");
		
		System.out.println(sb);
	}

	private static void pre(String curr) {
		sb.append(curr);
		if(!tree.get(curr)[0].equals(".")) {
			pre(tree.get(curr)[0]);
		}
		if(!tree.get(curr)[1].equals(".")) {
			pre(tree.get(curr)[1]);
		}
	}

	private static void mid(String curr) {
		if(!tree.get(curr)[0].equals(".")) {
			mid(tree.get(curr)[0]);
		}
		sb.append(curr);
		if(!tree.get(curr)[1].equals(".")) {
			mid(tree.get(curr)[1]);
		}
		
	}

	private static void post(String curr) {
		if(!tree.get(curr)[0].equals(".")) {
			post(tree.get(curr)[0]);
		}
		if(!tree.get(curr)[1].equals(".")) {
			post(tree.get(curr)[1]);
		}
		sb.append(curr);
		
	}
}
