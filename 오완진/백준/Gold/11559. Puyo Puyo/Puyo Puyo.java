import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R = 12, C = 6;
	static char[][] ppuyo;
	static int combo;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ppuyo = new char[R][C];
		for (int r = 0; r < R; r++) {
			char[] line = sc.nextLine().toCharArray();
			for (int c = 0; c < C; c++)
				ppuyo[r][c] = line[c];
		}//input
		
		combo = 0;
		
		playing:
		while (true) {
			
            List<int[]> boomList = new ArrayList<>();
            boolean[][] visited = new boolean[R][C];
            
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					char block = ppuyo[r][c];
					
					if (block != '.' && !visited[r][c]) {
						
						Queue<int[]> bfs = new LinkedList<>();
						List<int[]> boom = new ArrayList<>();
						
						bfs.add(new int[] {r, c});
						boom.add(new int[]{r, c});
						visited[r][c] = true;
						
						int count = 0;
						while(!bfs.isEmpty()) {
							int[] now = bfs.poll();
							int rNow = now[0];
							int cNow = now[1];
							count++;
							
							for (int d = 0; d < 4; d++) {
								int rNext = rNow + dr[d];
								int cNext = cNow + dc[d];
								
								if (rNext < 0 || R <= rNext) 		continue;
								if (cNext < 0 || C <= cNext)		continue;
								if (ppuyo[rNext][cNext] != block) 	continue;
								if (visited[rNext][cNext]) 			continue;
								
								bfs.add(new int[] {rNext, cNext});
                                boom.add(new int[]{rNext, cNext});
								visited[rNext][cNext] = true;
							}//for d
						}//while
						if (count >= 4)
							boomList.addAll(boom);
					}// if .
				}//c
			}//r
			
			if (boomList.isEmpty()) break playing;
			
			for (int c = 0; c < C; c++) {
				
				Stack<Character> stack = new Stack<>();
				
				int count = 0;
				safe:
				for (int r = R - 1; r >= 0; r--) {
					for (int[] boom : boomList) {
						if (boom[0] == r && boom[1] == c) {
							count++;
							continue safe;
						}
					}//boom
					stack.push(ppuyo[r][c]);
				}//r
				for (int r = 0; r < count; r++)
					stack.push('.');
				for (int r = 0; r < R; r++)
					ppuyo[r][c] = stack.pop();
				
			}//c
			
			combo++;
			
		}//while true
		
		System.out.println(combo);
		
	}//main
}//Main