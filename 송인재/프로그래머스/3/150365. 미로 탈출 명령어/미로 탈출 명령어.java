import java.util.*;

class Solution {
    int n;
    int m;
    int r;
    int c;
    int[] dr = { 1, 0, 0, -1 };
    int[] dc = { 0, -1, 1, 0 };
    char[] path = { 'd', 'l', 'r', 'u' };
    String command;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        
        dfs(x, y, k, new StringBuilder());
        
        if (command == null) {
            command = "impossible";
        }
        
        return command;
    }
    
    void dfs(int row, int col, int left, StringBuilder sb) {
        if (command != null) {
            return;
        }
        
        if (left == 0) {
            if (row != r || col != c) {
                return;
            }
            
            command = sb.toString();
            
            return;
        }
        
        int distance = Math.abs(row - r) + Math.abs(col - c);
        boolean distanceEven = distance % 2 == 0;
        boolean leftEven = left % 2 == 0;
        
        if (distance > left || distanceEven != leftEven) {
            return;
        }
        
        for (int i = 0; i < dr.length; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            
            if (isOutOfBox(newRow, newCol)) {
                continue;
            }
            
            StringBuilder newSb = new StringBuilder(sb.toString())
                .append(path[i]);
            
            dfs(newRow, newCol, left - 1, newSb);
        }
    }
    
    boolean isOutOfBox(int row, int col) {
        return row < 1 || col < 1
            || row > n
            || col > m;
    }
}