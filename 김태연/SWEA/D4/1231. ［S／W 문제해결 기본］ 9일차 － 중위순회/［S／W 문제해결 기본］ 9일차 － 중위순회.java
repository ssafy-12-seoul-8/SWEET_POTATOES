import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int idx;
	int left;
	int right;
	String data;
//	public Node() {
//		
//	}
//	public Node(int idx) {
//		this.idx = idx;
//	}
}

class Solution
{
	
	static List<Node> nodeList;
	static String result;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			result="";
			nodeList = new ArrayList<Node>();
			int N = sc.nextInt();	// 각 테스트 케이스의 N
			sc.nextLine();
			
			nodeList.add(null);
			for (int i=0; i<N; i++) {
				
				String line = sc.nextLine();
				String[] words = line.split(" ");
//				System.out.println("line 출력하기 : ");
//				System.out.println(line);
				Node node = new Node();
				node.idx = Integer.parseInt(words[0]);
//				node.idx = line.charAt(0) - '0';
				node.data = words[1];
//				node.data = line.charAt(2);
				
				if (words.length == 4) {
					node.left = Integer.parseInt(words[2]);
					node.right = Integer.parseInt(words[3]);
				}

				else if (words.length == 3) {
					node.left = Integer.parseInt(words[2]);
				}
				
//				System.out.println("node 의 idx 값 : " + node.idx);
//				System.out.println("node 의 data 값 : " + node.data);
//				System.out.println("node 의 left 값 : " + node.left);
//				System.out.println("node 의 right 값 : " + node.right);
			
				nodeList.add(node);
			}

			inorder(1);
			
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}
	
	
	// inorder 는 중위순회, LVR
	static void inorder(int index) {
//		System.out.println(index + "번호의 inorder");
		// index에 있는 Node가 null 이거나, out of boundary 면 종료
		// 8 >= nodeList.size(현재 9임)
		if (nodeList.get(index) == null || index >= nodeList.size()) 
			return;
		
		inorder(nodeList.get(index).left);
		result += nodeList.get(index).data;
//		System.out.print(nodeList.get(index).data);
		inorder(nodeList.get(index).right);
	}
}