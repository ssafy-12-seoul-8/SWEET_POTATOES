import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int rNow = Integer.parseInt(st.nextToken());
        int cNow = Integer.parseInt(st.nextToken());
        int dNow = Integer.parseInt(st.nextToken());
        
        boolean[][] cleaned = new boolean[R][C];
        boolean[][][] visited = new boolean[R][C][4];
        int[][] ruleA = new int[R][C];
        int[][] ruleB = new int[R][C];
        
        for (int r = 0; r < R; r++) {
        	String line = br.readLine();
        	for (int c = 0; c < C; c++)
        		ruleA[r][c] = line.charAt(c) - '0';
        }
        
        for (int r = 0; r < R; r++) {
        	String line = br.readLine();
        	for (int c = 0; c < C; c++)
        		ruleB[r][c] = line.charAt(c) - '0';
        }

        int cleanCnt = 0;
        int emptyCnt = 0;
        int totalCnt = 0;
        
        while (true) {
        	
        	if (!cleaned[rNow][cNow]) {
        		cleaned[rNow][cNow] = true;
        		visited = new boolean[R][C][4];
        		emptyCnt = 0;
        		dNow = (dNow + ruleA[rNow][cNow]) % 4;
        	} else {
        		
                if (visited[rNow][cNow][dNow]) {
                	totalCnt += cleanCnt - emptyCnt;
                	break;
                }
                
                visited[rNow][cNow][dNow] = true;
        		emptyCnt++;
        		dNow = (dNow + ruleB[rNow][cNow]) % 4;
        	}
        	
        	int rNext = rNow + dr[dNow];
        	int cNext = cNow + dc[dNow];
        	cleanCnt++;
        	
            if (rNext < 0 || R <= rNext || cNext < 0 || C <= cNext) {
            	totalCnt += cleanCnt - emptyCnt;
            	break;
            }
            
            rNow = rNext;
            cNow = cNext;
        }
        
        System.out.println(totalCnt);
	}
}