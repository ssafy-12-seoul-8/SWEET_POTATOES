import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int R, C, rNow, cNow, dNow, rNext, cNext, visitCnt = 0, cleanCnt = 0, emptyCnt = 0, totalCnt = 0;
	static boolean[][] cleaned;
	static int[][][] visited;
	static int[][] ruleA, ruleB;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        rNow = Integer.parseInt(st.nextToken());
        cNow = Integer.parseInt(st.nextToken());
        dNow = Integer.parseInt(st.nextToken());
        
        cleaned = new boolean[R][C];
        visited = new int[R][C][4];
        ruleA = new int[R][C];
        ruleB = new int[R][C];
        
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
        
        while (true) {
        	
        	if (!cleaned[rNow][cNow]) {
        		cleaned[rNow][cNow] = true;
        		visitCnt++;
        		emptyCnt = 0;
        		dNow = (dNow + ruleA[rNow][cNow]) % 4;
        	} else {
        		
                if (visited[rNow][cNow][dNow] == visitCnt) {
                	totalCnt += cleanCnt - emptyCnt;
                	break;
                }
                
                visited[rNow][cNow][dNow] = visitCnt;
        		emptyCnt++;
        		dNow = (dNow + ruleB[rNow][cNow]) % 4;
        	}
        	
        	rNext = rNow + dr[dNow];
        	cNext = cNow + dc[dNow];
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