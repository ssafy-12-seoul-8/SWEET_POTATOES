import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	public Node(int index) {
		this.idx = index;
	}

	public Node() {
	}

	int idx;
	int left;
	int right;
	int data;
	String op;

	@Override
	public String toString() {
		return "Node [idx=" + idx + ", left=" + left + ", right=" + right + ", data=" + data + ", op=" + op + "]";
	}

}

class Solution {

	static List<Node> list;
	static int result;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			result = 0;
			list = new ArrayList<Node>();
			int N = sc.nextInt(); // 각 테스트 케이스의 N
			sc.nextLine();

			list.add(null);
			for (int i = 0; i < N; i++) {

				String line = sc.nextLine();
				String[] words = line.split(" "); // 1 , - , 2, 3 으로 쪼갬
				Node node = new Node(Integer.parseInt(words[0]));

//				System.out.println("입력받은 line : " + line);

				if (node.idx != list.size()) {
					list.add(new Node(0));	// 0 은 data 값
				}

				// words.length 는 2 아니면 4 밖에 없음

				if (words.length == 2) {
//					System.out.println("현재 i 값 : " + i);
					node.idx = Integer.parseInt(words[0]);
					node.data = Integer.parseInt(words[1]);
				}

				else if (words.length == 4) {
//					System.out.println("현재 i 값 : " + i);
					node.idx = Integer.parseInt(words[0]);
					node.op = words[1];
					node.left = Integer.parseInt(words[2]);
					node.right = Integer.parseInt(words[3]);
				}
//				System.out.println("node 추가 : " + node.toString());
				list.add(node);
			}
//			System.out.println("list 의 1번째 노드: " + list.get(1));

			// (9 / (6 - 4)) * 3
			result = calculate(1);

			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}

	static int calculate(int index) {
//		System.out.println("inorder : " + index);
		Node node = list.get(index);
		
		if (node.op != null) {
			switch (node.op) {
			case "+":
//				System.out.println("+호출");
				return calculate(node.left) + calculate(node.right);
			case "-":
//				System.out.println("-호출");
				return calculate(node.left) - calculate(node.right);
			case "*":
//				System.out.println("*호출");
				return calculate(node.left) * calculate(node.right);
			case "/":
//				System.out.println("/호출");
				return calculate(node.left) / calculate(node.right);
			}

		}
		return node.data;
	}
}