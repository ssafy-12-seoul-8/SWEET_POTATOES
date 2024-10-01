import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static int N, M, K;
	static int[][] foodMap, foodPlan;
	static Set<Integer> greenSet, newGreenSet;
	static Deque<Integer>[][] treeAgeMap;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		foodMap = new int[N][N];				// 양분지도
		foodPlan = new int[N][N];				// 겨울양분지도
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				foodMap[r][c] = 5;
				foodPlan[r][c] = sc.nextInt();
			}
		}
		
		greenSet = new HashSet<>();				// 녹지목록(나무>=1 좌표목록), key: N*r + c
		treeAgeMap = new Deque[N][N];			// 나무나이지도
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				treeAgeMap[r][c] = new LinkedList<>();
		
		// 입력데이터가 나이 순으로 정렬된 데이터가 주어진다는 가정하에..
		for (int m = 0; m < M; m++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int age = sc.nextInt();
			treeAgeMap[r][c].addLast(age);
			
			int key = N * r + c;
			greenSet.add(key);
		}
		
		for (int k = 1; k <= K; k++) {
			
			// 봄 & 여름
            newGreenSet = new HashSet<>();
			for (int key : greenSet) {
				int r = key / N;
				int c = key % N;
				int food = foodMap[r][c];
				
				Queue<Integer> aliveTreeList = new LinkedList<>();
				
				int energy = 0;
				boolean enough = true;
				while (!treeAgeMap[r][c].isEmpty()) {
					int treeAge = treeAgeMap[r][c].pollFirst();

					if (enough) {
						if (food >= treeAge) {
							food -= treeAge;
							aliveTreeList.add(treeAge + 1);
						} else {
							energy += treeAge / 2;
							enough = false;
						}
					} else
						energy += treeAge / 2;
				}
				
				foodMap[r][c] = food + energy;
				
				if (!aliveTreeList.isEmpty()) {
					newGreenSet.add(key);

					while(!aliveTreeList.isEmpty()) {
						int aliveTree = aliveTreeList.poll();
						treeAgeMap[r][c].addLast(aliveTree);
					}
				}
			}
			
			greenSet = newGreenSet;
			
			// 가을
            newGreenSet = new HashSet<>();
			for (int key : greenSet) {
				int r = key / N;
				int c = key % N;
				
				Queue<Integer> aliveTreeList = new LinkedList<>();
				
				while (!treeAgeMap[r][c].isEmpty()) {
					aliveTreeList.add(treeAgeMap[r][c].peekFirst());
					int treeAge = treeAgeMap[r][c].pollFirst();
					
					if (treeAge % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							int rn = r + dr[d];
							int cn = c + dc[d];
							
							if (rn < 0 || N <= rn || cn < 0 || N <= cn) continue;
							
							treeAgeMap[rn][cn].addFirst(1);
							
							int newKey = rn * N + cn;
							newGreenSet.add(newKey);
						}
					}
				}
				
				while(!aliveTreeList.isEmpty()) {
					int aliveTree = aliveTreeList.poll();
					treeAgeMap[r][c].addLast(aliveTree);
				}
			}
			
			greenSet.addAll(newGreenSet);
			
			// 겨울
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N; c++)
					foodMap[r][c] += foodPlan[r][c];
		}
		
		int aliveTrees = 0;
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				aliveTrees += treeAgeMap[r][c].size();
		
		System.out.println(aliveTrees);
	}
}