import java.util.LinkedList;
import java.util.Scanner;


class Node {
	int idx;
	Node parent;
	Node left;
	Node right;
	int howManyNodes = 1;
}

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
//		T=1;	//10
		T=sc.nextInt();	//10

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int V = sc.nextInt();	// 13
			int E = sc.nextInt();	// 12
			int X1 = sc.nextInt();	// 8
			int X2 = sc.nextInt();	// 13
			
			Node[] nodeArr = new Node[V+1];

			// Node 의 부모 자식 설정
			for (int i = 0; i < E; i ++) {
				// 1(부모) 2(자식)
				int parentIdx = sc.nextInt();	// 1 (부모)
				int childIdx = sc.nextInt();	// 2 (자식)
				
				Node parent;
				Node child;

				// 부모로 받은 노드가 처음 받은 노드일 때
				if (nodeArr[parentIdx] == null) {
					parent = new Node();
					parent.idx = parentIdx;
					nodeArr[parentIdx] = parent;
				} else {
					parent = nodeArr[parentIdx];
				}
				
				// 자식으로 받은 노드가 처음 받은 노드일 때
				if (nodeArr[childIdx] == null) {
					child = new Node();
					child.idx = childIdx;
					nodeArr[childIdx] = child;
				} else {
					child = nodeArr[childIdx];
				}

				// 부모의 왼쪽 노드가 비어있으면 왼쪽에 넣고, 아니면 오른쪽에 넣어라
				if (parent.left == null) parent.left = child;
				else parent.right = child;

				// 자식에게 부모를 지정해준다.
				child.parent = parent;
				
				}
			
			// 문제는 8번 노드와 13번 노드의 공통 조상을 찾는 것
			
			Node n1 = nodeArr[X1];	// 8번 노드 호출
			Node n2 = nodeArr[X2];  // 13번 노드 호출
			
			
			LinkedList<Node> n1ParentList = new LinkedList<Node>();
			LinkedList<Node> n2ParentList = new LinkedList<Node>();

			findParent(n1 , n1ParentList);
			findParent(n2 , n2ParentList);
			
			
			int commonIdx = 0;
			
			공통조상찾기 : for (int i=0; i < n1ParentList.size(); i++) {
				for (int j=0; j<n2ParentList.size() ; j++) {
					if (n1ParentList.get(i).idx == n2ParentList.get(j).idx) {
						commonIdx = n1ParentList.get(i).idx;
						break 공통조상찾기;
					}
				}
			}
			int count = 0;
			count = findChild(nodeArr[commonIdx]);
			System.out.println("#" + test_case + " " + commonIdx + " " + count);
		}
	}
	
	
	static Node findParent (Node node, LinkedList<Node> list ) {
		// 기저조건 : 부모 노드가 없으면 탈출한다.
		if (node.parent == null) return null;
		// 부모가 있을 경우, 해당 부모를 리스트에 추가하고 재귀함수 호출한다.
		Node parent = node.parent;
		list.add(parent);
		return findParent(parent, list);
	}
	
	
	static int findChild (Node node) {
		// 기저조건 : 리프노드이면 종료한다
		if (node == null) return 0;
		if (node.left == null && node.right == null) return 1;
		return findChild(node.left) + findChild(node.right) + 1;
	}

}
