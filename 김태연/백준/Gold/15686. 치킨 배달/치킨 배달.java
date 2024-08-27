import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<int[]> chicken;
	static List<int[]> home;
	static int N;
	static int M;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] array = new int[N][N];
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		
		// 0. 입력받기
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int X = Integer.parseInt(st.nextToken());
				array[i][j] = X;
				int[] location = {i,j};

				// X 가 2면, 치킨집에 추가하고
				if (X == 2) {
					chicken.add(location);
				} else if (X == 1) {	// X가 1이면 home에 추가함
					home.add(location);
				}
			}
		}
		

		// 처리
		
		int count = 0;
		int idx = 0;
		List<int[]> 생존자 = new ArrayList<>();
		
		
		btk(idx , 생존자, count);
		// ( 0,   0 ,   0);
		// idx : 판단하는 치킨집의 인덱스 번호
		// 생존자 : 폐업시키지 않은 집들의 리스트
		// count : 폐업시키지 않은 집들의 수
		
		System.out.println(result);
		
	}
	
	
	static void btk(int idx, List<int[]> 생존자 , int count ) {
		
		if (count == M) {
//			System.out.println("M개만 살리고 폐업 종료!");
			// 이번 경우의 도시의 치킨 거리 : 
			int 도시의치킨거리 = 0;
			for (int i=0; i<home.size(); i++) {
				// 치킨거리 구해야함
				int 치킨거리 = Integer.MAX_VALUE;
				for (int j=0; j<생존자.size(); j++) {
														// 집 주소    // 치킨 집 주소
					치킨거리 = Math.min(치킨거리 , findRoute(home.get(i), 생존자.get(j)));
				}
				도시의치킨거리 += 치킨거리;
			}
			
			if (도시의치킨거리 <= 0) return;
//			System.out.println("도시의 치킨거리 : " + 도시의치킨거리);
			result = Math.min(도시의치킨거리, result);
			return;
		}
		
		
		if (idx == chicken.size()) {
//			System.out.println("실패");
			return;
		}
		
		
		// 생존자에 0(index)번 치킨집을 추가하지 않음 / 즉, 폐업시킴
		btk(idx+1 , 생존자 , count);		// 인덱스 번호 올리고, 폐업시키지 않은 집의 수에 1 추가함
		
		// 생존자에 0번 치킨집을 추가
		생존자.add(chicken.get(idx));
		btk(idx+1 , 생존자 , count+1);
		생존자.remove(chicken.get(idx));
	}
	
	// 집의 위치와, 치킨집의 위치를 입력받음
	static int findRoute(int[] home, int[] chicken) {
		
		int x = Math.abs(home[0] - chicken[0]);
		int y = Math.abs(home[1] - chicken[1]);
		
		return x+y;
	}
}



