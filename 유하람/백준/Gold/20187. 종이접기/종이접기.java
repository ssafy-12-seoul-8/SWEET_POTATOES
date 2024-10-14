import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종이의 크기
		int k = Integer.parseInt(br.readLine());

		int N = (int) Math.pow(2, k);

		// 행, 열 위치
		int r_start = 0;
		int r_end = N - 1;
		int c_start = 0;
		int c_end = N - 1;

		// 접는 순서
		StringTokenizer st = new StringTokenizer(br.readLine());

		String[] folding = new String[2 * k];
		
		String lastFoldRow = null;
		String lastFoldCol = null;

		for (int i = 0; i < 2 * k; i++) {
			folding[i] = st.nextToken();
			
			if(folding[i].equals("R") || folding[i].equals("L")) {
				lastFoldCol = folding[i];
			}else {
				lastFoldRow = folding[i];
			}
			
			
			switch (folding[i]) {
			case "R": // 오른쪽으로 접기
				c_start = (c_start + c_end) / 2 + 1;
				break;
			case "L": // 왼쪽으로 접기
				c_end = (c_start + c_end)/2;
				break;
			case "U": // 위로 접기
				r_end = (r_start + r_end)/2;
				break;
			case "D": // 아래로 접기
				r_start = (r_start + r_end)/2 + 1;
				break;
			}
		}

		// 구멍 뚫는 위치
		int h = Integer.parseInt(br.readLine());

		// 종이
		int[][] paper = new int[N][N];
		
		paper[r_start][c_start] = h;
		
		int[][] smallPaper = new int[2][2];
		
		if(lastFoldRow.equals("U") && lastFoldCol.equals("L")) {
			// 왼 쪽 위
			smallPaper[0][0] = h;
			smallPaper[0][1] = h<2?(h+1)%2:(h+1)%2+2;
			smallPaper[1][0] = (h+2)%4;
			smallPaper[1][1] = (smallPaper[0][1]+2)%4;
		}else if(lastFoldRow.equals("U") && lastFoldCol.equals("R")) {
			// 오른쪽 위
			smallPaper[0][0] = h<2?(h+1)%2:(h+1)%2+2;
			smallPaper[0][1] = h;
			smallPaper[1][0] = (smallPaper[0][0]+2)%4;
			smallPaper[1][1] = (h+2)%4;
			
		}else if(lastFoldRow.equals("D") && lastFoldCol.equals("L")) {
			// 왼쪽 아래
			smallPaper[0][0] = (h+2)%4;
			smallPaper[1][1] = h<2?(h+1)%2:(h+1)%2+2;
			smallPaper[0][1] = (smallPaper[1][1]+2)%4;
			smallPaper[1][0] = h;
			
		}else {
			// 오른쪽 아래
			smallPaper[1][0] = h<2?(h+1)%2:(h+1)%2+2;
			smallPaper[0][0] = (smallPaper[1][0]+2)%4;
			smallPaper[0][1] = (h+2)%4;
			smallPaper[1][1] = h;
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(i%2==0 && j%2==0) {
					sb.append(smallPaper[0][0]).append(" ");
				}else if(i%2==0 && j%2!=0) {
					sb.append(smallPaper[0][1]).append(" ");
				}else if(i%2!=0 && j%2==0) {
					sb.append(smallPaper[1][0]).append(" ");
				}else {
					sb.append(smallPaper[1][1]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		

	} // main

} // Main class