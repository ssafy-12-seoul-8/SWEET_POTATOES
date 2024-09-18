import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 역 개수
		int K = sc.nextInt();	// 하이퍼튜브 연결 역 개수
		int M = sc.nextInt();	// 하이퍼튜브 개수
		
		List<List<Integer>> tubesByStation = new ArrayList<>();
		for (int n = 0; n <= N; n++)
			tubesByStation.add(new ArrayList<>());
		
		List<List<Integer>> hyperTubes = new ArrayList<>();
		for (int m = 0; m < M; m++) {
			List<Integer> stations = new ArrayList<>();
			for (int k = 0; k < K; k++) {
				int station = sc.nextInt();
				stations.add(station);
				tubesByStation.get(station).add(m);
			}
			hyperTubes.add(stations);
		}
		
		Queue<int[]> bfs = new LinkedList<>();
		boolean[] visitedStations = new boolean[N + 1];
		boolean[] visitedTubes = new boolean[M];
		
		bfs.add(new int[] {1, 1});
		visitedStations[1] = true;
		
		while (!bfs.isEmpty()) {
			int[] now = bfs.poll();
			int stationNow = now[0];
			int count = now[1];
			
			if (stationNow == N) {
				System.out.println(count);
				return;
			}
			
			for (int tubeIdx : tubesByStation.get(stationNow)) {
				if (visitedTubes[tubeIdx]) continue;
				visitedTubes[tubeIdx] = true;
				
				for (int stationNext : hyperTubes.get(tubeIdx)) {
                    if (!visitedStations[stationNext]) {
                        visitedStations[stationNext] = true;
                        bfs.add(new int[] {stationNext, count + 1});
                    }
				}
			}
		}
		
		System.out.println(-1);
	}
}