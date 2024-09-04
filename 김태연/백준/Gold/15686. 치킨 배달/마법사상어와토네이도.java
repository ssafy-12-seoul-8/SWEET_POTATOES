package 마법사상어와토네이도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    // 좌,하,우,상
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { -1, 0, 1, 0 };
    static int sum;

    // 좌 하 우 상
    // 5 10 a 10 2 7 y 7 2 1 x 1
    // 일단 왼쪽방향만 만들고
    static int[][] tdr = { { 0, 1, -1, 2, 1, -1, -2, 1, 1 , 0}, 
                        { 2, 1, 1, 0, 0, 0, 0, -1, -1 , 1},
                        { 0, -1, 1, -2, -1, 1, 2, -1, 1 , 0},
                        { -2, -1, -1, 0, 0, 0, 0, 1, 1, 2 , -1}
            };
    static int[][] tdc = { { -2, -1,  -1, 0, 0,0, 0, 1, 1, -1 }, 
                        { 0, -1,  1, -2, -1, 1, 2, -1, 1 , 0},
                        { 2, 1,  1, 0, 0, 0, 0, -1, -1 , 1},
                        { 0, -1,  1, -2, -1, 1, 2, -1, 1 , 0} };
    
    static int[] tPercent = { 5, 10, 10, 2, 7, 7, 2, 1, 1, 0 };

    // 방향을 더 구현하는게 좋을것같은데
    // 2칸 가는거랑
    // 1.1칸씩 가는거랑 다 구현해놓고 방향만 돌리면 안되냐?
    // 부호로 방향 조절할 수 있을것 같은데.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sum = 0;
        // 토네이도는 한 번에 한 칸 이동함

        // 시작 위치(r,c)
        // 1. 격자의 가운데를 찾는다.
        int r = N / 2;
        int c = N / 2;

        for (int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j=0; j<N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        

        System.out.println(Arrays.deepToString(map));
        // 이동할 대 마다 모래가 흩날림..
        // a는 남은 모래의 양과 같음.
        // 총 45% 니깐 알파는 55%일꺼임.

        // 소수점 아래는 버림(정수형으로 처리)

        // 방향에 맞게 알아서 잘 회전해야함(중요)
        // 토네이도는 (1,1) 까지 이동한 뒤 소멸 -> 이 때, '격자의 밖으로 나간 모래의 양' 을 구하는 문제

        // 2. 모래 바람을 움직이기 시작한다.
        int dir = 0; // 방향은 0번 인덱스부터 시작한다

        // 특정 조건을 만족할 때 까지, 토네이도를 움직인다. : 특정 조건이 뭔지 알아내야함.
        int L = 1;
        int moveCount = 1;
        int evenCount = 0;
        while (!(r==0 & c==0)) {
        	System.out.println("토네이도 좌표 : ( " + r + " , " + c + " )");
        	System.out.println("토네이도 dir : " + dir);
        	System.out.println("방향전환 전까지 남은 움직임 횟수: : " + moveCount);
        	System.out.println("토네이도움직이기");
        	System.out.println();
        	
        	// -1 단계
        	// dir 이 정해짐.
        	// 타겟 row, column
        	// (2,2)
        	moveSand(r, c, dir);	// 0 단계
        	moveCount--;
        	// 한 칸씩 움직여라.
            
        	r = r + dr[dir];		// 1단계
        	c = c + dc[dir];
            if (moveCount == 0) {
            	dir++;
            	dir %= 4;
            	evenCount++;
            	if (evenCount % 2 == 0) L++;
            	moveCount = L;
            }
        }
        System.out.println(sum);

    }

    // 토네이도의 위치를 x	(2,2)
    static void moveSand(int r, int c, int dir) {
        // 좌,하,우,상
    	// (2,1)
    	r = r + dr[dir];		// 1단계
    	c = c + dc[dir];

        // 이 좌표의 위치는 y
        int sand = map[r][c];
        System.out.println("모래의 양 : " + sand);

        for (int i = 0; i < 10; i++) {
            int row = r + tdr[dir][i];
            int column = c + tdc[dir][i];
            int movingSandAmount = (int) (sand * 0.01 * tPercent[i]);
            
            if (isBoundary(row, column)) {
            	
            	System.out.println("범위 안 입니다. r : " + row + " , column : " + column);
                map[row][column] += movingSandAmount;
                map[r][c] -= movingSandAmount;
                
                if (i == 9) {
                	// 나머지 모래는 10번째 항으로 넣어야함
                	map[row][column] += map[r][c];
                	map[r][c] = 0;
                }
                // 모래 처리 로직
            } else {
            	System.out.println("범위 밖 입니다. r : " + row + " , column : " + column);
                sum += movingSandAmount;
                map[r][c] -= movingSandAmount;
            }
            
        }
        

    }

    static boolean isBoundary(int row, int column) {
        if (row >= 0 && row < N && column >= 0 && column < N) return true;
        else return false;
    }

}




//// 제일 왼쪽에 있는 5% (확실함)
//// 진행방향 * 2
//map[r + 2*dr[dir]][c + 2*dc[dir]] = (int) (0.05 * sand);
//
//// 왼쪽위에 있는 10
//// 진행방향 + 90도 꺾은 방향
//map[r + dr[dir] + dc[dir]] [c + dc[dir] + dr[dir]] = (int) (0.1 * sand);
//
//// 왼쪽 아래에 있는 10
//// 진행방향 + 반시계로 꺾은 방향
//map[r + dr[dir] -dc[dir]] [c + dc[dir] - dr[dir]] = (int) (0.1 * sand);
//
//// 2칸위에 있는 2
//// 진행방향*2의 90도로 꺽은 방향
//map[r + 2*dr[dir]] [c + 2*dc[dir]] = (int) (0.02 * sand);
//
//// 1칸 위에 있는 7
//// 진행방향의 90도로 꺽은 방향
//map[r + dc[dir]] [c + dr[dir]] = (int) (0.07 * sand);
//
//// 1칸 아래에 있는 7
//// 진행 방향의 반시계로 꺾은 방향
//map[ r - dc[dir]] [c + dr[dir]] = (int) (0.07 * sand);
//
//// 2칸 아래에 있는 2
//// 진행방향*2의 반시계로 꺾은 방향
//map[r - 2*dr[dir]] [c + 2*dc[dir]] = (int) (0.02 * sand);
//
//// 1칸 뒤에 있는 1
//map[r + dc[dir]] [ c - dr[dir]] = (int) (0.01 * sand);
//
//// 1칸 뒤에 있는 1
//map[r - dc[dir]][c - dr[dir]] = (int) (0.01 * sand);
//
//
//
// 직진방향 : dr[dir] , dc[dir]

//      (r-2,c)
//      (r-1, c-1) (r-1,c) , (r+1,c) 
//      (r,c-2) 
//      (r+1,c-1) (r+1, c) (r+1, c+1)
//      (r+2,c)
