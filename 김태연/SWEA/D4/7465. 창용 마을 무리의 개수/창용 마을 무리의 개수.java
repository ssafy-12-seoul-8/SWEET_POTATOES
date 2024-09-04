import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();

			parent = new int[N + 1];

			// 일단 각자가 자신의 대표가 되도록 설정
			for (int i=1; i <= N; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				int memberA = sc.nextInt();
				int memberB = sc.nextInt();
				
				parent[findParent(memberA)] = findParent(memberB);
				
			}
			
			for (int i=1; i<=N; i++) {
				if (parent[i] == i) result++;
			}

			System.out.println("#" + test_case + " " + result);
		}

	}
	
	static int findParent (int index) {
		
		if (parent[index] == index) return index;
		
		else return findParent(parent[index]);
	}

}
