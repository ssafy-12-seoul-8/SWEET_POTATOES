import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] maze = new int[n][m];
        int[][] distance = new int[n][m];
        
        init(br, maze);
        bfs(maze, distance);
        
        System.out.println(distance[n - 1][m - 1]);
    }
    
    private static void init(BufferedReader br, int[][] maze) throws IOException {
        for (int i = 0; i < maze.length; i++) {
            String row = br.readLine();
            
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = row.charAt(j) - '0';
            }
        }
    }
    
    private static void bfs(int[][] maze, int[][] distance) {
        Queue<List<Integer>> queue = new LinkedList<>();
        
        queue.add(List.of(0, 0));
        distance[0][0] = 1;
        
        while (!queue.isEmpty()) {
            List<Integer> indices = queue.poll();
            int i = indices.get(0);
            int j = indices.get(1);
            
            if (i > 0 && maze[i - 1][j] == 1 && distance[i - 1][j] == 0) {
                distance[i - 1][j] = distance[i][j] + 1;
                queue.add(List.of(i - 1, j));
            }
            
            if (i < maze.length - 1 && maze[i + 1][j] == 1 && distance[i + 1][j] == 0) {
                distance[i + 1][j] = distance[i][j] + 1;
                queue.add(List.of(i + 1, j));
            }
            
            if (j > 0 && maze[i][j - 1] == 1 && distance[i][j - 1] == 0) {
                distance[i][j - 1] = distance[i][j] + 1;
                queue.add(List.of(i, j - 1));
            }
            
            if (j < maze[0].length - 1 && maze[i][j + 1] == 1 && distance[i][j + 1] == 0) {
                distance[i][j + 1] = distance[i][j] + 1;
                queue.add(List.of(i, j + 1));
            }
        }
    }
}