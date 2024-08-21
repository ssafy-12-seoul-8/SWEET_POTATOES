import java.util.Arrays;
import java.util.Scanner;

// DFS

public class Solution {

	static int D;
	static int W;
	static int K;
	static int[][] map;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[D][W];
			min = Integer.MAX_VALUE;
			
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			dfs(0, 0);
			
			System.out.printf("#%d ", test_case);
			System.out.println(min == Integer.MAX_VALUE ? 0 : min);
		}
	}
	
	private static void dfs(int k, int cnt) {
		// 약물 투여 회수가 min을 넘어가면 의미 없으니까 return
		if (cnt >= min) {
			return;
		}
		
		// k 가 필름 두께와 같을 때
		if (k == D) {
			for (int w = 0; w < W; w++) {
				int same = 1;
				
				for (int d = 0; d < D - 1; d++) {
					// 위 아래 0 or 1 검사
					if (map[d][w] == map[d + 1][w]) {
						same++;
					} else {
						same = 1;
					}
					
					// K를 한번이라도 만족하면 다음 열 검사
					if (same >= K) {
						break;
					}
				}
				
				// 하나의 열을 모두 검사했는데 K를 만족하지 못하면 불합격
				if (same < K) {
					return;
				}
			}
			
			min = Math.min(min, cnt);
			return;
		}
		
		int[] tmp = map[k].clone();
		
		// 약품 투입 x
		dfs(k + 1, cnt);
		
		// A 약품 투입
		Arrays.fill(map[k], 0);
		dfs(k + 1, cnt + 1);
		
		// B 약품 투입
		Arrays.fill(map[k], 1);
		dfs(k + 1, cnt + 1);
		
		map[k] = tmp;
	}

}
