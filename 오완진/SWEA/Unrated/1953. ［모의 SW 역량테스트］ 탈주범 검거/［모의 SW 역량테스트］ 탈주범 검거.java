import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
	
	static int R, C, rNow, cNow, L, answer, cnt;
	static int[][] map;
	
	static int[] dr = {-1, 0, 1, 0};	// 북 동 남 서
	static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
        	
        	R = sc.nextInt();
        	C = sc.nextInt();
        	rNow = sc.nextInt();
        	cNow = sc.nextInt();
        	L = sc.nextInt();
        	answer = 0;
        	
        	map = new int[R][C];
        	for (int r = 0; r < R; r++)
        		for (int c = 0; c < C; c++)
        			map[r][c] = sc.nextInt();
        	
        	boolean[][] visited = new boolean[R][C];
        	Queue<int[]> bfs = new LinkedList<>();
        	
        	visited[rNow][cNow] = true;
    		bfs.add(new int[] {rNow, cNow, 1});
        	
        	while (!bfs.isEmpty()) {
        		
        		int[] now = bfs.poll();
        		rNow = now[0];
        		cNow = now[1];
        		cnt = now[2];
        		answer++;
        		
        		List<Integer> doorList = new ArrayList<>();
        		doorList = getDoor(map[rNow][cNow]);
        		for (int d = 0; d < doorList.size(); d++) {
        			int dWay = doorList.get(d);
        			int rNext = rNow + dr[dWay];
        			int cNext = cNow + dc[dWay];
        			
        			if (rNext < 0 || R <= rNext) continue;
        			if (cNext < 0 || C <= cNext) continue;
        			if (visited[rNext][cNext]) continue;
        			if (map[rNext][cNext] == 0) continue;
        			
        			if (canMove(map[rNext][cNext], dWay)) {
        				if (cnt + 1 <= L) {
        					visited[rNext][cNext] = true;
        					bfs.add(new int[] {rNext, cNext, cnt + 1});
        				}
        			}
        		}
        		
        	}
    
            System.out.println("#" + tc + " " + answer);
             
        }
    }
    
    static List<Integer> getDoor(int type) {
    	
    	List<Integer> doorList = new ArrayList<>();
    	
    	switch (type) {
    	case 1: doorList.add(0);
				doorList.add(1);
				doorList.add(2);
				doorList.add(3);
				break;
		case 2: doorList.add(0);
				doorList.add(2);
				break;
		case 3: doorList.add(1);
				doorList.add(3);
				break;
		case 4: doorList.add(0);
				doorList.add(1);
				break;
		case 5: doorList.add(1);
				doorList.add(2);
				break;
		case 6: doorList.add(2);
				doorList.add(3);
				break;
		case 7: doorList.add(3);
				doorList.add(0);
				break;
    	}
    	
    	return doorList;
    	
    }
    
    static boolean canMove(int type, int dWay) {
    	
    	boolean tf = false;
    	
    	switch (type) {
	    	case 1: 							tf = true;
	    			break;
	    	case 2: if (dWay == 0 || dWay == 2) tf = true;
	    			else						tf = false;
	    			break;
	    	case 3: if (dWay == 1 || dWay == 3) tf = true;
	    			else						tf = false;
	    			break;
	    	case 4: if (dWay == 2 || dWay == 3) tf = true;
	    			else						tf = false;
					break;
	    	case 5: if (dWay == 0 || dWay == 3) tf = true;
	    			else						tf = false;
					break;
	    	case 6: if (dWay == 0 || dWay == 1) tf = true;
	    			else						tf = false;
					break;
	    	case 7: if (dWay == 1 || dWay == 2) tf = true;
	    			else						tf = false;
					break;
    	}
    	
    	return tf;
    }
    
}
