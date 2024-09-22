import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class FireBall {
	int row;
	int column;
	int mass;
	int speed;
	int dir;
	
    public FireBall(int row, int column, int mass, int speed, int dir) {
    	super();
    	this.row = row;
        this.column = column;
        this.mass = mass;
        this.speed = speed;
        this.dir = dir;
    }
}

public class Main {

	static int N,M,K;
	static List<FireBall>[][] map;
	// 방향은 12시부터 시계방향 (문제 그림과 같음)
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; 
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1][N+1];

		// 격자의 행과 열은 1번부터 N번까지 번호가 매겨져 있음 (0이 없음)
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		List<FireBall> fireBallList = new ArrayList<>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			// r, c, m ,s ,d
			// row column mass speed direction
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				FireBall fireBall = new FireBall(r, c, m, s, d);
				fireBallList.add(fireBall);
		}
		
		// 입력 끝
		
		// 이동 명령
		for (int i=0; i<K; i++) {
			move(fireBallList);
			effect(fireBallList);
		}
		
		// 남은 파이어볼 질량의 합
		
		int sum = 0;
		for (int i=0; i<fireBallList.size(); i++) {
			sum += fireBallList.get(i).mass;
		}
		
		System.out.println(sum);
		
	}
	
	static void move(List<FireBall> fireBallList) {
		// 초기화
		for (int i=1; i<= N; i++) {
			for (int j=1; j<= N; j++) {
				map[i][j].clear();
			}
		}
		
		// 이동 로직 구현
		// 자신의 방향 dir 로 속력 s만큼 이동
		
		for (int i=0; i<fireBallList.size(); i++) {
			FireBall fireBall = fireBallList.get(i);
			// nextRow = 현재위치 + 방향 곱하기 속도(초과하면 순환)
			int nr = (fireBall.row + dr[fireBall.dir] * ( fireBall.speed % N ) + N ) % N;
			int nc = (fireBall.column + dc[fireBall.dir] * (fireBall.speed % N) + N) % N;
			
			// 만약 나머지가 0이라면, 끝에 위치한것과 같음
			if (nr == 0) nr = N;
			if (nc == 0) nc = N;
			
			fireBall.row = nr;
			fireBall.column = nc;
			map[nr][nc].add(fireBall);
			
			
		}
	}
	
	// 파이어볼의 움직임이 끝나면 생기는 효과(4단계)
	static void effect(List<FireBall> fireBallList) {
		List<FireBall> newFireBallList = new ArrayList<>();
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<= N; j++) {
				// 1. 파이어볼이 한 좌표에 2개 이상 이라면
				if (map[i][j].size() >= 2) {
					int massSum = 0;
					int speedSum = 0;
					boolean allEven = true;
					boolean allOdd = true;
					
					List<FireBall> currentList = map[i][j];
					for (int k=0; k<currentList.size(); k++) {
						FireBall fireBall = currentList.get(k);
						
						massSum += fireBall.mass;
						speedSum += fireBall.speed;
						
						// 하나라도 짝수면, 전체 홀수를 false로 하고
						// 하라나도 홀수면, 전체 짝수를 false로 함
						if (fireBall.dir % 2 == 0) {
							allOdd = false;
						} else {
							allEven = false;
						}
					}
					
					// 질량 -> 합/5
					int newMass = massSum / 5;
					int newSpeed = speedSum / currentList.size();
					
					// 질량 0 파이어볼 소멸
					if (newMass == 0) continue;
					else {
						// 모두 짝수이거나 모두 홀수
						int[] newDirs;
						if (allOdd || allEven) {
							newDirs = new int[] {0,2,4,6};
						} else {	// 섞임
							newDirs = new int[] {1,3,5,7};
						}
						
						for (int k=0; k<4; k++) {
							newFireBallList.add(new FireBall(i, j, newMass, newSpeed, newDirs[k]));
						}
					}
						
					// 속력 -> 합/개수
					// 방향이 모두 홀수, 모두 짝수, 또는 홀짝이 섞임
					
				} else if (map[i][j].size() == 1) {
					// 파이어볼이 하나인 경우
					newFireBallList.add(map[i][j].get(0));
					
				}
			}
		}
//		fireBallList = newFireBallList;
		fireBallList.clear();
		fireBallList.addAll(newFireBallList);
	}
}










