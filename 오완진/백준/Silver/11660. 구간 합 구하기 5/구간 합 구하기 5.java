import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[][] NN, MM;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		NN = new int[N + 1][N + 1];			// 누적합 2차원배열
		MM = new int[M][4];
		
		for (int n1 = 1; n1 <= N; n1++)
			for (int n2 = 1; n2 <= N; n2++)
				NN[n1][n2] = NN[n1-1][n2] + NN[n1][n2-1] - NN[n1-1][n2-1] + sc.nextInt();
		
		for (int m = 0; m < M; m++)
			for (int i = 0; i < 4; i++)
				MM[m][i] = sc.nextInt();

//		for (int n1 = 1; n1 <= N; n1++) {
//			for (int n2 = 1; n2 <= N; n2++)
//				System.out.print(NN[n1][n2] + " ");
//			System.out.println();
//		}
		
		for (int m = 0; m < M; m++) {
			int x1 = MM[m][0];
			int y1 = MM[m][1];
			int x2 = MM[m][2];
			int y2 = MM[m][3];
			
			int sum = NN[x2][y2] - NN[x1-1][y2] - NN[x2][y1-1] + NN[x1-1][y1-1];
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}