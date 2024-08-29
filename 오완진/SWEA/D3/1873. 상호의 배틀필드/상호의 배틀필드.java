import java.util.Scanner;

public class Solution {
	
	static int H;
	static int W;
	static char[][] map;
	
	static int[] dh = {-1, 0, 1, 0};	// 상 우 하 좌
	static int[] dw = {0, 1, 0, -1};
	static int tD;						// 탱크 Direction
	static int tH;						// 탱크 H 좌표
	static int tW;						// 탱크 W 좌표
	
	public static void main(String[] args) {
		
		/*
			.	평지(전차가 들어갈 수 있다.)
			*	벽돌로 만들어진 벽				-> 포탄 평지화
			#	강철로 만들어진 벽				-> 포탄 소멸
			-	물(전차는 들어갈 수 없다.)
			^	위쪽을 바라보는 전차(아래는 평지이다.)
			v	아래쪽을 바라보는 전차(아래는 평지이다.)
			<	왼쪽을 바라보는 전차(아래는 평지이다.)
			>	오른쪽을 바라보는 전차(아래는 평지이다.)
			
			U	up		방향을 바꾸고 평지라면 이동1칸
			D	down	22
			L	left	33
			R	right	44
			S	shoot	현재 방향으로 포탄 발사
			
			맵 밖 이동x
			
		 */
		
		Scanner sc = new Scanner (System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			H = sc.nextInt();
			W = sc.nextInt();
			sc.nextLine();
			map = new char[H][W]; 
			
			boolean checkedInit = false;
			for (int h = 0; h < H; h++) {
				String str = sc.nextLine();
				map[h] = str.toCharArray();
				if (checkedInit) continue;
				for (int w = 0; w < W; w++) {		// 탱크 현재 좌표 & 방향
					if (map[h][w] == '^') {
						tD = 0;
						tH = h;
						tW = w;
						checkedInit = true;
					} else if (map[h][w] == '>') {
						tD = 1;
						tH = h;
						tW = w;
						checkedInit = true;
					} else if (map[h][w] == 'v') {
						tD = 2;
						tH = h;
						tW = w;
						checkedInit = true;
					} else if (map[h][w] == '<') {
						tD = 3;
						tH = h;
						tW = w;
						checkedInit = true;
					}
				}
			}
			
			int N = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			char[] cmd = new char[N];
			for (int n = 0; n < N; n++)
				cmd[n] = str.charAt(n);
			
			for (int n = 0; n < N; n++) {
				switch(cmd[n]) {
					case 'U': 	tD = 0;
								move();
								break;
					case 'R': 	tD = 1;
								move();
								break;
					case 'D': 	tD = 2;
								move();
								break;
					case 'L': 	tD = 3;
								move();
								break;
					case 'S': 	shoot();
								break;
				}
			}
			
			System.out.print("#" + tc + " ");
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					System.out.print(map[h][w]);
				}
				System.out.println();
			}
		}
	}
	
	static boolean canMove(int tHnext, int tWnext) {
		if (tHnext < 0 || H <= tHnext) return false;
		if (tWnext < 0 || W <= tWnext) return false;
		if (map[tHnext][tWnext] == '*') return false;
		if (map[tHnext][tWnext] == '#') return false;
		if (map[tHnext][tWnext] == '-') return false;
		return true;
	}
	
	static boolean canShoot(int tHnext, int tWnext) {
		if (tHnext < 0 || H <= tHnext) return false;
		if (tWnext < 0 || W <= tWnext) return false;
		if (map[tHnext][tWnext] == '#') return false;
		return true;
	}

	static void move() {
		int tHnext = tH + dh[tD];
		int tWnext = tW + dw[tD];
		if (canMove(tHnext, tWnext)) {
			if (tD == 0) map[tHnext][tWnext] = '^';
			if (tD == 1) map[tHnext][tWnext] = '>';
			if (tD == 2) map[tHnext][tWnext] = 'v';
			if (tD == 3) map[tHnext][tWnext] = '<';
			map[tH][tW] = '.';			// 탱크 지나간 자리
			tH = tHnext;
			tW = tWnext;
		} else {
			if (tD == 0) map[tH][tW] = '^';
			if (tD == 1) map[tH][tW] = '>';
			if (tD == 2) map[tH][tW] = 'v';
			if (tD == 3) map[tH][tW] = '<';
		}
	}
	
	static void shoot() {
		int tHnext = tH + dh[tD];
		int tWnext = tW + dw[tD];
		if (tD == 0 || tD == 2) {	// 상하
			while (canShoot(tHnext, tW)) {
				if (map[tHnext][tW] == '*') {
					map[tHnext][tW] = '.';
					break;
				}
				tHnext += dh[tD];
			}
		} else {					// 좌우
			while (canShoot(tH, tWnext)) {
				if (map[tH][tWnext] == '*') {
					map[tH][tWnext] = '.';
					break;
				}
				tWnext += dw[tD];
			}
		}
	}
	
}
