package 개똥벌레;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;
//import java.util.StringTokenizer;

public class Main {

	static int N,H;
	static boolean[][] cave;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = sc.nextInt();
		H = sc.nextInt();
//		N = Integer.parseInt(st.nextToken());
//		H = Integer.parseInt(st.nextToken());
		
		// 동굴의 길이 N(짝수) 높이 H
		cave = new boolean[H][N];
		
		for (int i=0; i<N; i++) {
//			st = new StringTokenizer(br.readLine());
//			int input = Integer.parseInt(st.nextToken());
			int input = sc.nextInt();
			
			// 짝수번째 : 석순
			if (i%2 == 0) {
				for (int j=0; j<input; j++) {
					cave[H-1-j][i] = true;
				}
				
			} else {	// 홀수번째 : 종유석
				for (int j=0; j<input; j++) {
					cave[j][i] = true;
				}
			}
		}
		
		// 입력 끝
		int min = Integer.MAX_VALUE;
		for (int i=0; i<H; i++) {
			// 한줄뚫기
			int count = 0;
			for (int j=0; j<N; j++) {
				if (cave[i][j]) count++;
			}
			min = Math.min(min, count);
		}
		
		int result = 0;
		for (int i=0; i<H; i++) {
			// 한줄뚫기
			int count = 0;
			for (int j=0; j<N; j++) {
				if (cave[i][j]) count++;
			}
			if (count==min) result++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(result);
		System.out.println(sb);
	}
}
