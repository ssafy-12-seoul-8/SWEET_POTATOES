package 미로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_DFS {

	static int N, M;
	static int[][] maize;
	static boolean[][] isVisited;
	static int[] dr = { 0, 0, 1, -1 }; // 동 서 남 북
	static int[] dc = { 1, -1, 0, 0 }; // 동 서 남 북
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maize = new int[N][M];
		isVisited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				maize[i][j] = line.charAt(j) - '0';
			}
		}

		// 시작 위치 세팅
		int myRow = 0;
		int myColumn = 0;
		
		// 결과값 최악의 값으로 세팅
		result = N * M;
		
		// 시행
		search(myRow, myColumn, 1);

		// 출력
		System.out.println(result);
		br.close();

	}

	static void search(int myRow, int myColumn, int depth) {

		if (depth >= result) return;
		
		// 목적지에 도착하면 그만함.
		if (myRow == (N - 1) && myColumn == (M - 1)) {
			// result 를 갱신하고 종료한다.
//			System.out.println("도착했습니다");
			result = Math.min(result, depth);
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nextRow = myRow + dr[dir]; // 움직일 X 좌표
			int nextColumn = myColumn + dc[dir]; // 움직일 Y 좌표

			// 방문 조건 만족?
			if (canVisit(nextRow, nextColumn)) {
				isVisited[nextRow][nextColumn] = true;
				search(nextRow, nextColumn, depth + 1);
				isVisited[nextRow][nextColumn] = false;
			} else {
//				System.out.println("길이없다. return, 현재 depth : " + depth);
			}
		}

	}

	static boolean canVisit(int nextRow, int nextColumn) {
		//	범위 내 인지?							갔던 곳은 아닌지?						 '길'이 맞는지(1인지)
		if (inBoundary(nextRow, nextColumn) && !isVisited[nextRow][nextColumn] && maize[nextRow][nextColumn] == 1)
			return true;
		else
			return false;
	}

	static boolean inBoundary(int row, int colulmn) {
		if (row >= 0 && row < N) {
			if (colulmn >= 0 && colulmn < M) {
				return true;
			}
		}
		return false;
	}
}
