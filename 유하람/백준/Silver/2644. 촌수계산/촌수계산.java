

import java.util.Scanner;

public class Main {
	
	static int answer;
	static int N;
	static int p1;
	static int p2;
	static int[][] adjArr;
	static boolean[] visited;
	static int cnt;
	

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 전체 사람의 수
		p1 = sc.nextInt(); // 촌수 계산해야 하는 사람1
		p2 = sc.nextInt(); // 촌수 계산해야 하는 사람2
		int E = sc.nextInt(); // 관계의 개수
		
		adjArr = new int[N+1][N+1]; // 인접 배열
		for(int i=0 ; i<E ; i++) {
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			adjArr[tmp1][tmp2] = 1;
			adjArr[tmp2][tmp1] = 1;
		}
		
		visited = new boolean[N+1];
		cnt = 0;
		answer = -1;
		visited[p1] = true;
		dfs(p1, cnt);
		
		System.out.println(answer);
		
		
	} // main


	private static void dfs(int p1, int cnt) {
		if(p1==p2) {
			answer = cnt;
			return;
		}
		
		for(int i=0 ; i<N+1 ; i++) {
			if(adjArr[p1][i]==1 && !visited[i]) {
				visited[i] = true;
				dfs(i,cnt+1);
			}
		}
	}


}
