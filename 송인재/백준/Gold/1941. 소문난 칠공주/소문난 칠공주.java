import java.io.*;
import java.util.*;

public class Main {
    
    static int count;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        int r = 7;
        char[][] map = new char[n][n];
        
        
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine()
                    .toCharArray();
        }
        
        combination(map, new int[r][2], 0, 0, 0, r);
        System.out.println(count);
    }
    
    static void combination(char[][] map, int[][] indices, int current, int index, int yCount, int r) {
        if (yCount >= 4) {
            return;
        }
        
        if (current == r) {
            if (isNearby(indices, new boolean[map.length][map[0].length])) {
                count++;
            }
            
            return;
        }
        
        for (int i = index; i < map.length * map[0].length; i++) {
            int row = i / map.length;
            int col = i % map.length;
            indices[current][0] = row;
            indices[current][1] = col;
            
            combination(map, indices, current + 1, i + 1, map[row][col] == 'Y' ? yCount + 1 : yCount, r);
        }
    }
    
    static boolean isNearby(int[][] indices, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        int cnt = 0;
        
        queue.add(indices[0]);
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int row = current[0] + dr[i];
                int col = current[1] + dc[i];
                
                if (row < 0 || col < 0 || row >= visited.length || col >= visited.length) {
                    continue;
                }
                
                for (int[] index : indices) {
                    if (index[0] == row && index[1] == col && !visited[row][col]) {
                        visited[row][col] = true;
                        queue.add(new int[] {row, col});
                        cnt++;
                    }
                }
            }
        }
        
        return cnt == indices.length;
    }
   
}