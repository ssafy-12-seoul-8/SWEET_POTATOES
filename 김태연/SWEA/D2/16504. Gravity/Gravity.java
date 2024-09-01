import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
//			boolean[][] map = new boolean[N][N];
			int[] building = new int[N];
			
			for (int i=0; i<N; i++) {
				int height = sc.nextInt();
				building[i] = height;
//				for (int j=0; j<height; j++) {
//					map[i][j] = true;
//				}
			}
			
			// 왼쪽에서 오른쪽으로 보면서, 가장 높은 건물이 나올때마다 연산을 갱신시켜야함.
			int fall = 0;
			int max = 0;
			int highestBuilding = building[0];
			
			for (int i=0; i<N; i++) {
				// 제일 높았던 건물이 지금의 건물보다 높으면
				if (highestBuilding > building[i]) {
					fall++;
				} else {
					highestBuilding = building[i];
					max = Math.max(fall, max);
//					fall = 0;
				}
//				System.out.println(i +" 번째 건물, fall 값은 : " + fall);
			}
			
			max = Math.max(max, fall);
			System.out.println("#" + test_case + " " + max);
			
		}
	}
}
