import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	static int N, aliveTime;
	static int[][] map;
	static int[] shark;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 9) {
					map[r][c] = 0;					// 아오
					shark = new int[] {r, c, 2, 0};
				}
			}
		}//input
		
		aliveTime = 0;
		
		alive:
		while (true) {
			
//			System.out.println();
//			System.out.println("shark: \t" + Arrays.toString(shark));
			
	        PriorityQueue<int[]> fishList = new PriorityQueue<>(
	        	(o1, o2) -> {
	        		int cmp = o1[2] - o2[2];		// time 기준 오름차순
	        		if (cmp == 0) {
	        			cmp = o1[0] - o2[0];		// r좌표 기준 오름차순
	        			if (cmp == 0) {
	        				return o1[1] - o2[1];	// c좌표 기준 오름차순
	        			}
	        		}
	        		return cmp;
	        	}
	        );

			int rNow = shark[0];
			int cNow = shark[1];
			int size = shark[2];
			int exp = shark[3];
			int rNext, cNext;
			int time = 0;
			
			// 탐색시작
			Queue<int[]> bfs = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			
			bfs.add(new int[] {rNow, cNow, time});
			visited[rNow][cNow] = true;
			
			while (!bfs.isEmpty()) {

				int[] now = bfs.poll();
				rNow = now[0];
				cNow = now[1];
				time = now[2];
				
				for (int d = 0; d < 4; d++) {
					
					rNext = rNow + dr[d];
					cNext = cNow + dc[d];
					
					if (rNext < 0 || N <= rNext) continue;
					if (cNext < 0 || N <= cNext) continue;
					if (visited[rNext][cNext]) continue;
					if (map[rNext][cNext] > size) continue;
					
					visited[rNext][cNext] = true;
					if (1 <= map[rNext][cNext] && map[rNext][cNext] < size)
						fishList.add(new int[] {rNext, cNext, time + 1});
					else
						bfs.add(new int[] {rNext, cNext, time + 1});
						
				}//d
			}//bfs
			// 탐색완료
			
			// 엄마 소환 (유일한 종료 기저조건)
			if (fishList.isEmpty()) break alive;

//			for (int[] fish : fishList) {
//				System.out.println("fish: \t" + Arrays.toString(fish));
//			}
			
			// 타겟선정
			int[] targetFish = fishList.poll();
			
			// 이동시작
			rNext = targetFish[0];
			cNext = targetFish[1];
			time = targetFish[2];
			
			map[rNext][cNext] = 0;
			aliveTime += time;
			// 이동완료
			
			// 냠냠시작
			if (exp + 1 == size) {
				size++;
				exp = 0;
			} else
				exp++;
			
			shark = new int[] {rNext, cNext, size, exp};
			// 냠냠완료
			
		}//alive
			
		System.out.println(aliveTime);
		
	}//main
}//Main