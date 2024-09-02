import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
     
	static int N; // N번만 구슬을 쏠 수 있음
    static int H; // 높이
    static int W; // 너비
    
    static int[][] board;
    static int min = Integer.MAX_VALUE;
     
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int test_case = 1; test_case <= T; test_case++) {
        	N = sc.nextInt();
        	W = sc.nextInt();
        	H = sc.nextInt();
        	
        	board = new int[H][W];
        	
        	for (int h = 0; h < H; h++) {
        		for (int w = 0; w < W; w++) {
        			board[h][w] = sc.nextInt();
        		}
        	}
        	
        	int[] arr = new int[N];
             combination(0, arr);
        	
        	// for test
        	int tmp[][] = new int[H][W];
    		
    		for (int h = 0; h < H; h++) {
    			tmp[h] = board[h].clone();
    		}
        	
        	System.out.printf("#%d %d%n", test_case, min);
        	
        	min = Integer.MAX_VALUE;
        }
         
    }
    
    // 구슬이 떨어질 수 있는 경우의 수
    // // W 너비에서 N번 중복조합
    public static void combination(int depth, int[] arr) {
    	if (depth == N) {
    		// 원본 배열 복사해서 테스트 배열 만듦
    		int tmp[][] = new int[H][W];
    		
    		for (int h = 0; h < H; h++) {
    			tmp[h] = board[h].clone();
    		}
    		
    		// 구해진 N번의 카운트만큼 구슬 떨어트리기
    		for (int i = 0; i < N; i++) {
    			game(tmp, arr[i]);
    		}
			
    		int count = 0;
    		
    		for (int i = 0; i < H; i++) {
    			for (int j = 0; j < W; j++) {
    				if (tmp[i][j] != 0) {
    					count++;
    				}
    			}
    		}

    		min = Math.min(min, count);
    		
    		return;
    	}
    	
    	for (int w = 0; w < W; w++) {
    		arr[depth] = w;
    		combination(depth + 1, arr);
    	}
    }
    
    public static void game(int[][] board, int idx) {
    	// u d l r
    	int[] dy = {-1, 1, 0, 0};
    	int[] dx = {0, 0, -1, 1};
    	
    	// queue 에 담아서 탐색
    	Queue<int[]> queue = new LinkedList<>();
    	
    	for (int h = 0; h < H; h++) {
    		// 블럭 만났을 때
    		if (board[h][idx] != 0) {
    			queue.add(new int[] {h, idx});
    			break;
    		}
   
    	}
    	
    	while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int y = curr[0];
			int x = curr[1];
			
			// 상 하 좌 우 순회
			for (int i = 1; i < board[y][x]; i++) {
				int u = y + (dy[0] * i);
				int d = y + (dy[1] * i);
				int l = x + (dx[2] * i);
				int r = x + (dx[3] * i);
				
				// 비어있는 블럭이 아닌 경우만 queue 에 넣어줄건데
				if (u >= 0 && board[u][x] != 0) {
					// 해당 블럭이 1이면 터트리기만 하고 queue 에 담지 않음
					if (board[u][x] == 1) {
						board[u][x] = 0;
					} else {
						queue.add(new int[] {u, x});
					}
				} 
				
				if (d < H && board[d][x] != 0) {
					if (board[d][x] == 1) {
						board[d][x] = 0;
					} else {
						queue.add(new int[] {d, x});
					}
				} 
				
				if (l >= 0 && board[y][l] != 0) {
					if (board[y][l] == 1) {
						board[y][l] = 0;
					} else {
						queue.add(new int[] {y, l});
					}
				} 
				
				if (r < W && board[y][r] != 0) {
					if (board[y][r] == 1) {
						board[y][r] = 0;
					} else {
						queue.add(new int[] {y, r});
					}
				}
			}
			
			board[y][x] = 0;
			
		}
		
    	// 블럭 내리기 (정말 귀찮구만..)
		for (int j = 0; j < W; j++) {
			int d = 0;
			for (int i = H - 1; i >= 0; i--) {
				if (board[i][j] == 0) {
					// 0 아닌 숫자 찾기
					for (int k = i - 1; k >= 0; k--) {
						if (board[k][j] != 0) {
							d = k;
							break;
						}
					}
					board[i][j] = board[d][j];
					board[d][j] = 0;
				}
			}
		}
    	
//    	for (int k = 0; k < H; k++) {
//			System.out.println(Arrays.toString(board[k]));
//		}
    }
 
}
