

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N,M;
	static int[] parent;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {

		// 대표가 같으면 같은 집합에 속해있음
		// 최고 대표는 재귀적으로 타고 들어가서 확인한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		
		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			parent = new int[N + 1]; // 1 ~ N 까지 숫자 있음.

			// 스스로를 대표로 설정 : 초기상태
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			sb.append("#").append(test_case).append(" ");
			// 입력받기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				
				switch (command) {
				case 0:
					if (parent[a] == parent[b]) continue;
					union(a,b);
					break;
				case 1:
					isTeam(a,b);
					break;
				}
			}

			// 최고 조상으로 연결
			sb.append("\n");

		}
		
		System.out.println(sb);

	}
	
	// union
	static void union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		
		// a 조상에 b 조상 합하기
		parent[pa] = pb;
		
	}
	
	// findSet
	static int findSet(int x) {
		// 조상이 자기 자신이면 스스로를 리턴하고
		if (parent[x] == x) return parent[x];
		// 아니면 재귀를 돌려서 최고 조상 찾음
		return parent[x] = findSet(parent[x]);
		
	}
	
	static void isTeam(int a, int b) {
		if (findSet(a) == findSet(b)) sb.append(1);
		else sb.append(0);
		
	}
	

}
