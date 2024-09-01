import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
class Solution
{
    static int H;
	static int W;
	static int[][] board;
	static List<int[]> list;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int minCnt;
    
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			// 구슬은 쏠 수 있는 횟수
			int N = sc.nextInt();

			// 너비
			W = sc.nextInt();
			
			// 높이
			H = sc.nextInt();
			
			
			// 공간
			board = new int[H][W];
			
			for(int r=0 ; r<H ; r++) {
				for(int c=0 ; c<W ; c++) {
					
					board[r][c] = sc.nextInt();
					
				}
			}
			
			
			// W개의 col 중에서 N개 순열로 고름
			// 고른 후 list에 저장
			
			int[] data = new int[N];
			list = new ArrayList<>();
			
			selectCol(N, 0, data);
			
			// list에 저장한 순서로 구슬 쏘기
			minCnt = Integer.MAX_VALUE;
			
			for(int[] Col : list) {
				shoot(Col);
			}
			
			System.out.println("#"+tc+" "+minCnt);
			
		}
	}
    private static void shoot(int[] col) {
		int[][] tmp = clone(board);
		
		for(int i : col) {
			int r = 0;
			
			// 가장 위의 벽돌까지 이동
			while(r<H && tmp[r][i]==0) {
				r++;
			}

			//비어있는 col이 아니라면
			if(r<H) {
				// 지우기
				tmp = remove(tmp, r, i);
				// 중력 작용
				tmp = gravity(tmp);
			}

			
		}
		
		// 남은 블럭 수 세기
		int cnt = count(tmp);
		minCnt = Math.min(cnt, minCnt);
		
		
	}


	private static int count(int[][] tmp) {
		int cnt = 0;
		
		for(int i=0 ; i<H ; i++) {
			for(int j=0 ; j<W ; j++) {
				if(tmp[i][j]>0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}


	private static int[][] gravity(int[][] tmp) {
		
		Stack<Integer> stack = new Stack<>();
		
		for(int c=0 ; c<W ; c++) {
			for(int r=0 ; r<H ; r++) {
				if(tmp[r][c]>0) {
					stack.add(tmp[r][c]);
					tmp[r][c] = 0;
				}
				
			}
			int r = H-1;
			while(!stack.isEmpty()) {
				tmp[r--][c] = stack.pop();
			}
		}
		
		return tmp;
	}


	private static int[][] remove(int[][] tmp, int r, int c) {
		int num = tmp[r][c];
		tmp[r][c] = 0;
		
		
		for(int i=0 ; i<4 ; i++) {
			for(int j=1 ; j<num ; j++) {
				int nr = r + dr[i]*j;
				int nc = c + dc[i]*j;
				
//				System.out.println("nr : "+nr+", nc : "+nc);
				
				if(nr>=0 && nr<H && nc>=0 && nc<W && tmp[nr][nc]>0) {
					tmp = remove(tmp, nr, nc);
					
				}
			}
		}
		
		
		return tmp;
	}


	private static int[][] clone(int[][] board) {
		int[][] tmp = new int[H][W];
		
		for(int r=0 ; r<H ; r++) {
			for(int c=0 ; c<W ; c++) {
				tmp[r][c] = board[r][c];
			}
		}
		
		
		return tmp;
	}


	private static void selectCol(int n, int depth, int[] data) {
		
		if(n==depth) {
			list.add(data.clone());
			return;
		}
		
		for(int i=0 ; i<W ; i++) {
				data[depth] = i;
				selectCol(n,depth+1, data);
		}
	}
}