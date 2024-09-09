import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int N, M, K;
	static List<int[]> fbList;								// 전체 파이어볼 (유령볼 포함)
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		fbList = new ArrayList<>();
		
		for (int m = 0; m < M; m++) {
			int[] fb = new int[5];
			fb[0] = sc.nextInt() - 1;	// rNow
			fb[1] = sc.nextInt() - 1;	// cNow
			fb[2] = sc.nextInt();		// 질량m
			fb[3] = sc.nextInt();		// 속력s
			fb[4] = sc.nextInt();		// 방향d
			
			fbList.add(fb);
		}//input
		
		for (int k = 0; k < K; k++) {
			
			boolean[][] visited = new boolean[N][N];		// contact 중복조회 방지
			List<int[]> contactList = new ArrayList<>();	// contact 인덱스 조회용
			Stack<Integer>[][] contact = new Stack[N][N];	// fb 합체 판단용
			for (int n1 = 0; n1 < N; n1++)
				for (int n2 = 0; n2 < N; n2++)
					contact[n1][n2] = new Stack<>();
			
			// 이동
			for (int fbIdx = 0; fbIdx < fbList.size(); fbIdx++) {
				int[] fb = fbList.get(fbIdx);
				int rNow = fb[0];
				int cNow = fb[1];
				int m = fb[2];
				int s = fb[3];
				int d = fb[4];
				
				if (m == 0) continue;				// 유령볼(질량 0) 제외
				
				// 격자의 행과 열은 1번부터 N번까지 번호가 매겨져 있고,
				// 1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있다.
				// 이거 땜에 다시 푸는 중인데 한 번에 이해하신 분????
				
				int rNext = (rNow + dr[d] * s + 1000 * N) % N;	// N보다 s가 큰 경우(음수) 처리
				int cNext = (cNow + dc[d] * s + 1000 * N) % N;
				
				contact[rNext][cNext].push(fbIdx);
				contactList.add(new int[] {rNext, cNext});
			}//이동
			
			//합체
			outer:
			for (int[] check : contactList) {
				int rCheck = check[0];
				int cCheck = check[1];
				
				if (visited[rCheck][cCheck]) continue outer;
				visited[rCheck][cCheck] = true;
				
				List<Integer> fbCheckList = new ArrayList<>();	// 합체 조건 만족한 fb 리스트
				
				while (!contact[rCheck][cCheck].isEmpty()) {
					int fbIdx = contact[rCheck][cCheck].pop();
					int[] fb = fbList.get(fbIdx);
					
					if (fb[2] == 0) continue;		// 유령볼(질량 0) 제외
					
					fbCheckList.add(fbIdx);
				}
				
				int fbCnt = fbCheckList.size();
				if (fbCnt == 1) {					// 이동만
					int fbIdx = fbCheckList.get(0);
					int[] fb = fbList.get(fbIdx);
					fb[0] = rCheck;
					fb[1] = cCheck;
					
					fbList.set(fbIdx, fb);
				}
				
				else if (fbCnt > 1) {
					
					int sumM = 0;					// 질량합
					int sumS = 0;					// 속력합
					boolean isAllOdd = true;
					boolean isAllEven = true;
					
					for (int fbIdx : fbCheckList) {
						int[] fb = fbList.get(fbIdx);
						int m = fb[2];
						int s = fb[3];
						int d = fb[4];
						
						sumM += m;
						sumS += s;
						if (d % 2 == 0) isAllOdd = false;
						if (d % 2 != 0) isAllEven = false;
						
						fb[2] = 0;					// 기존것들 소멸
						
						fbList.set(fbIdx, fb);
					}
					
					if (sumM < 5) continue outer;	// 유령볼(질량 0) 제외
					
					// 이동은 합체 단계에서 하지 않음
					
					if (isAllOdd || isAllEven) {
						
						for (int newIdx = 0; newIdx < 4; newIdx++) {
							int[] fb = new int[5];	// 업데이트된 새로운 fb x4 생성
							fb[0] = rCheck;
							fb[1] = cCheck;
							fb[2] = sumM / 5;
							fb[3] = sumS / fbCnt;
							fb[4] = newIdx * 2;
							
							fbList.add(fb);
						}
						
					} else {
						
						for (int newIdx = 0; newIdx < 4; newIdx++) {
							int[] fb = new int[5];	// 업데이트된 새로운 fb x4 생성
							fb[0] = rCheck;
							fb[1] = cCheck;
							fb[2] = sumM / 5;
							fb[3] = sumS / fbCnt;
							fb[4] = newIdx * 2 + 1;
							
							fbList.add(fb);
						}
						
					}// 방향 0246 or 1357
					
				}// if fbCnt > 1
			}//합체
			
		}//K번
		
		int answer = 0;
		for (int[] fb : fbList)
			answer += fb[2];
		
		System.out.println(answer);
		
	}//main
}//Main
