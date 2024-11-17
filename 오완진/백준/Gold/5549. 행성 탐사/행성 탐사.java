import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		int[][][] map = new int[N + 1][M + 1][3];
		for (int n = 1; n <= N; n++) {
			String line = br.readLine();
			for (int m = 1; m <= M; m++) {
				char cell = line.charAt(m - 1);
                if (cell == 'J')
                    map[n][m][0] = 1;
                else if (cell == 'O')
                    map[n][m][1] = 1;
                else
                    map[n][m][2] = 1;
                
                for (int i = 0; i < 3; i++) {
                    map[n][m][i] += (map[n - 1][m][i] + map[n][m - 1][i] - map[n - 1][m - 1][i]);
                }
			}
		}
		
        StringBuilder sb = new StringBuilder();
		for (int k = 0; k < K; k++) {
			
			int[] S = new int[2];
			int[] E = new int[2];
			st = new StringTokenizer(br.readLine());
			S[0] = Integer.parseInt(st.nextToken());
			S[1] = Integer.parseInt(st.nextToken());
			E[0] = Integer.parseInt(st.nextToken());
			E[1] = Integer.parseInt(st.nextToken());
			
			sb.append(map[E[0]][E[1]][0] - map[S[0]-1][E[1]][0] - map[E[0]][S[1]-1][0] + map[S[0]-1][S[1]-1][0]);
			sb.append(" ");
			sb.append(map[E[0]][E[1]][1] - map[S[0]-1][E[1]][1] - map[E[0]][S[1]-1][1] + map[S[0]-1][S[1]-1][1]);
			sb.append(" ");
			sb.append(map[E[0]][E[1]][2] - map[S[0]-1][E[1]][2] - map[E[0]][S[1]-1][2] + map[S[0]-1][S[1]-1][2]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}