import java.util.*;
import java.io.*;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 점의 개수 n
		int N = Integer.parseInt(st.nextToken());

		// 차례의 수 m
		int M = Integer.parseInt(st.nextToken());

		// 각 점의 부모 배열
		parent = new int[N];

		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		// 답
		int answer = 0;

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			if (!check(n1, n2)) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);

	} // main

	private static boolean check(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 != p2) {
			if (p1 > p2) {
				parent[p1] = p2;
			} else {
				parent[p2] = p1;
			}
			return true;
		}
		return false;
	}

	private static int find(int n) {
		if (n == parent[n]) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

} // Main class
