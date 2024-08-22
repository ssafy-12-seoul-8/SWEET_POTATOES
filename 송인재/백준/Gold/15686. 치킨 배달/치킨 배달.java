import java.io.*;
import java.util.*;

public class Main {
	
	static int finalSum = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		List<int[]> houses = new ArrayList<>();
		List<int[]> chickens = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) {
					houses.add(new int[] {i, j});
				}
				
				if (map[i][j] == 2) {
					chickens.add(new int[] {i, j});
				}
			}
		}
		
		combination(chickens, new ArrayList<>(), houses, n, 0, m);
		
		System.out.println(finalSum);
	}
	
	static void combination(List<int[]> chickens, List<int[]> included, List<int[]> houses, int n, int index, int left) {
		if (index == chickens.size() || left == 0) {
			finalSum = Math.min(finalSum, getSum(houses, included, n));
			
			return;
		}
		
		for (int i = index; i < chickens.size(); i++) {
			included.add(chickens.get(i));
			
			combination(chickens, included, houses, n, i + 1, left - 1);
			
			included.remove(included.size() - 1);
		}
	}
	
	static int getSum(List<int[]> houses, List<int[]> chickens, int n) {
		int sum = 0;
		Queue<Integer> pq = new PriorityQueue<>();
		
		for (int[] house : houses) {
			int houseRow = house[0];
			int houseCol = house[1];
			int min = 2 * n;
			
			for (int[] chicken : chickens) {
				int chickenRow = chicken[0];
				int chickenCol = chicken[1];
				int distance = Math.abs(houseRow - chickenRow) + Math.abs(houseCol - chickenCol);
				min = Math.min(distance, min);
			}
			
			pq.add(min);
		}
		
		while (!pq.isEmpty()) {
			sum += pq.poll();
		}
		
		return sum;
	}
	
}