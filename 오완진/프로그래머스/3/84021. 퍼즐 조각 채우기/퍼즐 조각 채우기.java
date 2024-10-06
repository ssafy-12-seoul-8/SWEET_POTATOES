import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    static int[] dn = new int[]{-1, 0, 1, 0};
    static int[] dm = new int[]{0, 1, 0, -1};

    static int answer, N;
    static boolean[][] tableVisited, boardVisited;
    static List<int[][]>[] tableList, boardList;

    public int solution(int[][] board, int[][] table) {
        answer = 0;
        N = board.length;
        tableVisited = new boolean[N][N];
        boardVisited = new boolean[N][N];

        tableList = new ArrayList[7];
        boardList = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            tableList[i] = new ArrayList<>();
            boardList[i] = new ArrayList<>();
        }

        for (int n = 0; n < N; n++)
            for (int m = 0; m < N; m++)
                if (table[n][m] == 1 && !tableVisited[n][m])
                    searchBlock(n, m, table, true);

        for (int n = 0; n < N; n++)
            for (int m = 0; m < N; m++)
                if (board[n][m] == 0 && !boardVisited[n][m])
                    searchBlock(n, m, board, false);

        for (int i = 1; i <= 6; i++) {
            for (int[][] boardInfo : boardList[i]) {
            	for (int j = 0; j < tableList[i].size(); j++) {
            		int[][] tableInfo = tableList[i].get(j);
                    if (canMatch(boardInfo, tableInfo)) {
                    	tableList[i].remove(j);
                        answer += i;
                        break;
                    }
            	}
            }
        }

        return answer;
    }
    
    static void searchBlock(int n, int m, int[][] map, boolean isTable) {
    	
        int target = isTable ? 1 : 0;
        boolean[][] visited = isTable ? tableVisited : boardVisited;
        List<int[][]>[] infoList = isTable ? tableList : boardList;
        
        int limitT = n;
        int limitB = n;
        int limitL = m;
        int limitR = m;
        
        Queue<int[]> bfs = new LinkedList<>();
        List<int[]> realBlocks = new ArrayList<>();
        
        bfs.add(new int[] {n, m});
        visited[n][m] = true;
        
        while (!bfs.isEmpty()) {
        	
        	int[] now = bfs.poll();
        	int nNow = now[0];
        	int mNow = now[1];
        	
        	limitT = Math.min(limitT, nNow);
        	limitB = Math.max(limitB, nNow);
            limitL = Math.min(limitL, mNow);
            limitR = Math.max(limitR, mNow);
            realBlocks.add(new int[] {nNow, mNow});
            
            for (int d = 0; d < 4; d++) {
            	
                int nNext = nNow + dn[d];
                int mNext = mNow + dm[d];
                
                if (nNext < 0 || N <= nNext || mNext < 0 || N <= mNext ||
                		visited[nNext][mNext] || map[nNext][mNext] != target) continue;
            	
                bfs.add(new int[] {nNext, mNext});
                visited[nNext][mNext] = true;
            }
        }
        
        int height = limitB - limitT + 1;
        int length = limitR - limitL + 1;
        int[][] info = new int[height][length];
        
        for (int[] realBlock : realBlocks)
        	info[realBlock[0] - limitT][realBlock[1] - limitL] = 1;
        
        infoList[realBlocks.size()].add(info);
    }
    
    static boolean canMatch(int[][] boardInfo, int[][] tableInfo) {
        for (int r = 0; r < 4; r++) {
            if (checkBlock(boardInfo, tableInfo))
                return true;
            tableInfo = rotateBlock(tableInfo);
        }
        return false;
    }
    
    static boolean checkBlock(int[][] boardInfo, int[][] tableInfo) {
    	int boardHeight = boardInfo.length;
    	int tableHeight = tableInfo.length;
    	int boardLength = boardInfo[0].length;
    	int tableLength = tableInfo[0].length;
    	
    	if (boardHeight != tableHeight || boardLength != tableLength) 
    		return false;
    	
    	for (int n = 0; n < boardHeight; n++)
    		for (int m = 0; m < boardLength; m++)
    			if (boardInfo[n][m] != tableInfo[n][m])
    				return false;
    	
    	return true;
    }
    
    static int[][] rotateBlock(int[][] info) {
        int height = info.length;
        int length = info[0].length;
        int[][] rotated = new int[length][height];
        
        for (int r = 0; r < height; r++)
            for (int c = 0; c < length; c++)
                rotated[c][height - 1 - r] = info[r][c];
        
        return rotated;
    }
}