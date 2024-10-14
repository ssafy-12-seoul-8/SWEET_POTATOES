import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, H, W;

	public static void main(String[] args) throws IOException {
		// 건물은 H * W 개의 방이 있음
		// N 개의 방을 모두 방문

		// 높이는 H, 한 층에 W 개의 방이 있음. 왼쪽부터 1 ~ W
		// 같은층, 인접한 방 : 1초 (양옆으로 1초)
		// 같은 호, 인접한 방 : 100초 (위아래로 100초)

		// 1층 1호 출발, N 개의 방을 방문하는데 걸리는 최소시간 ?

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		// 왼쪽 끝 방과, 오른쪽 끝 방의 정보를 담는 배열
		int[][] room = new int[H + 1][2]; 

		
		// 초기화 시 각 방의 값을 적절히 설정
		for (int i = 1; i <= H; i++) {	// 최대 H층까지 생성
			room[i][0] = 101;			// 호수는 1~100 까지 존재
			room[i][1] = 0;
		}
		
		room[0][0] = 1;
		room[0][1] = 1;

		room[1][0] = 1;	// 1번방의 가장 왼쪽 방은 1로 설정
		room[1][1] = 1;	// 일단 1번방의 가장 오른쪽 방도 1로 설정
		
		int top = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int floor = Integer.parseInt(st.nextToken()); // 층수
			int number = Integer.parseInt(st.nextToken()); // 호수

			top = Math.max(floor, top); // 꼭대기층 갱신 ( 가장 마지막으로 방문해야 함 )

			room[floor][0] = Math.min(room[floor][0], number); // 제일 왼쪽 좌표
			room[floor][1] = Math.max(room[floor][1], number); // 제일 오른쪽 좌표
		}

		int[][] dp = new int[H + 1][2];

//        // 아래층에서 왼쪽에서 출발해서, 위쪽 왼쪽으로 오는 경우
//        // 2층까지 = 1층누적	+ 왼쪽좌표 - 왼쪽좌표
//        dp[2][0] = dp[1][0] + Math.abs(room[2][0] - room[1][0]);
//        
//        // 아래층 오른쪽에서 출발해서, 위쪽 왼쪽으로 오는 경우
//        dp[2][0] = dp[1][1] + Math.abs(room[2][0] - room[1][1]);
//        
//        // 이렇게 두개를 비교해서, 최소값 선택
//        
//        
//        // 아래층 왼쪽에서 출발해서, 위쪽 오른쪽으로 오는 경우
//        dp[2][1] = dp[1][0] + Math.abs(room[2][1] - room[1][0]);
//        
//        // 아래층 오른쪽에서 출발해서, 위쪽 오른쪽으로 오는 경우
//        dp[2][1] = dp[1][1] + Math.abs(room[2][1] - room[1][1]);

		// 0층(존재하지 않음) 가장 왼쪽방, 가장 오른쪽 방 까지 가는데 걸리는 시간을 -100 으로 설정.(그래야 1층으로 올라왔을때 0이 됨)
		dp[0][0] = -100;
		dp[0][1] = -100;
		
		// 꼭대기층 까지만 반복함
		for (int i = 1; i <= top; i++) {

			// 입력 받지 않은 층에 대해서
			if (room[i][0] > room[i][1]) { // 입력받지 않은 층. pass!
				dp[i][0] = dp[i - 1][0] + 100; // 그냥 위층으로 이동하는 시간만 더해줌
				dp[i][1] = dp[i - 1][1] + 100;
				room[i][0] = room[i - 1][0];
				room[i][1] = room[i - 1][1];
				// 위치를 업데이트해줌 ( 만약 이번층을 이동하지 않았다면, 아래층에서 고스란히 올라오는 로직임)
				continue;
			}
			
			// 입력 받은 층에 대해서

			int gap = room[i][1] - room[i][0];
			// 점화식으로 만들면
			dp[i][0] = Math.min(dp[i - 1][0] + Math.abs(room[i][1] - room[i - 1][0]),
					dp[i - 1][1] + Math.abs(room[i][1] - room[i - 1][1])) + gap + 100;
			// 왼쪽 위로 가는건데, 시작점이 1. 왼쪽 아래인 경우, 2. 오른쪽 아래인 경우. MAth.min
			
			// 으론쪽 위로 가는 로직.
			dp[i][1] = Math.min(dp[i - 1][0] + Math.abs(room[i][0] - room[i - 1][0]),
					dp[i - 1][1] + Math.abs(room[i][0] - room[i - 1][1])) + gap + 100;

		}

		// 마지막 층에서 왼쪽 끝이나 오른쪽 끝 중에서 더 작은 값 선택
		int result = Math.min(dp[top][0], dp[top][1]);

		System.out.println(result);

//        for (int i=0; i<= top; i++) {
//        	System.out.println("room[" + i + "][0] : " + room[i][0]);
//        	System.out.println("room[" + i + "][1] : " + room[i][1]);
//        }
//        for (int i=1; i<= top; i++) {
//        	System.out.println("dp[" + i + "][0] : " + dp[i][0]);
//        	System.out.println("dp[" + i + "][1] : " + dp[i][1]);
//        }
	}

}
