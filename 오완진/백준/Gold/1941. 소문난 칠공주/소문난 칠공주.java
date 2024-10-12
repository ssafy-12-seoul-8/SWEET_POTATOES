import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] mapIdx = {0, 1, 2, 3, 4,
						   10, 11, 12, 13, 14,
						   20, 21, 22, 23, 24,
						   30, 31, 32, 33, 34,
						   40, 41, 42, 43, 44};
	
	static char[][] map;
	static int answer;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		map = new char[5][5];
		answer = 0;
		
		for (int r = 0; r < 5; r++)
			map[r] = sc.nextLine().toCharArray();
		
		combination(new int[7], 0, 0);
		
		System.out.println(answer);
	}
	
	static void combination(int[] picked, int idx, int start) {
		
		if (idx == 7) {
			if (isSurvived(picked) && isConnected(picked))
				answer++;
			return;
		}
		
		for (int i = start; i < 25; i++) {
			picked[idx] = mapIdx[i];
			combination(picked, idx + 1, i + 1);
		}
	}
	
	static boolean isSurvived(int[] picked) {
		int cntS = 0;
		for (int i = 0; i < 7; i++) {
			int r = picked[i] / 10;
			int c = picked[i] % 10;
			
			if (map[r][c] == 'S') cntS++;
		}
		
		return cntS >= 4;
	}
	
	static boolean isConnected(int[] picked) {
		
		Queue<Integer> bfs = new LinkedList<>();
		boolean[] visited = new boolean[7];
		
		bfs.add(0);
		visited[0] = true;
		
		while (!bfs.isEmpty()) {
			int idx= bfs.poll();
			
			for (int i = 0; i < 7; i++) {
				if (visited[i]) continue;
				
				int diff = Math.abs(picked[i] - picked[idx]);
				if (diff == 1 || diff == 10) {
					bfs.add(i);
					visited[i] = true;
				}
			}
		}
		
		for (int i = 0; i < 7; i++)
			if (!visited[i]) return false;
		return true;
	}
}