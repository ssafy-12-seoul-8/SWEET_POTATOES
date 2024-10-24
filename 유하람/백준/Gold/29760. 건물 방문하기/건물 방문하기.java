import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 방문하고자 하는 방의 개수 N
		int N = Integer.parseInt(st.nextToken());

		// 건물의 층
		int H = Integer.parseInt(st.nextToken());

		// 건물의 호
		int W = Integer.parseInt(st.nextToken());

		// 방문하고자 하는 방의 위치 (왼쪽 끝, 오른쪽 끝)
		int[][] rooms = new int[H + 1][2];

		// 방문하고자 하는 첫번째 층, 마지막 층
		int min = 101;
		int max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int floor = Integer.parseInt(st.nextToken());
			int room = Integer.parseInt(st.nextToken());
			max = Math.max(floor, max);
			if(floor!=1) {
				min = Math.min(min, floor);
			}
			rooms[floor][0]= rooms[floor][0] != 0?Math.min(rooms[floor][0], room):room;
			rooms[floor][1] = Math.max(rooms[floor][1], room);
		}
		

		// 각 방까지의 시간 저장
		int[][] DP = new int[max + 1][2];
		
		DP[0][0] = DP[0][1] = -100;
		rooms[0][0] = rooms[0][1] = 1;


		for (int h = 1; h <= max; h++) {
			// h층에 가야할 방이 없을 경우
			if (rooms[h][0] == 0) {
				DP[h][0] = DP[h - 1][0] + 100;
				DP[h][1] = DP[h - 1][1] + 100;
				rooms[h][0] = rooms[h - 1][0];
				rooms[h][1] = rooms[h - 1][1];
				
				continue;
			}

			// 가야할 방이 있다면
			// 1. 왼쪽 끝 방에서 끝나는 경우
			// 1. 아래층의 왼쪽 끝 방에서 올라오는 경우
			// 2. 아래층의 오른쪽 끝 방에서 올라오는 경우
			DP[h][0] = Math.min(DP[h - 1][0] + Math.abs(rooms[h - 1][0] - rooms[h][1]),
					DP[h - 1][1] + Math.abs(rooms[h - 1][1] - rooms[h][1]))
					+ Math.abs(rooms[h][0] - rooms[h][1]) + 100;

			// 2. 오른쪽 끝 방에서 끝나는 경우
			// 1. 아래층의 왼쪽 끝 방에서 올라오는 경우
			// 2. 아래층의 오른쪽 끝 방에서 올라오는 경우
			DP[h][1] = Math.min(DP[h - 1][0] + Math.abs(rooms[h - 1][0] - rooms[h][0]),
					DP[h - 1][1] + Math.abs(rooms[h - 1][1] - rooms[h][0]))
					+ Math.abs(rooms[h][0] - rooms[h][1]) + 100;

		}

		System.out.println(Math.min(DP[max][0], DP[max][1]));

	} // main

} // Main class