import java.util.Arrays;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int row = park.length;
        int col = park[0].length();
        
        char[][] p = new char[row][col];
        
        int x = 0;
        int y = 0;
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                char w = park[r].charAt(c);
                
                if (w == 'S') { x = r; y = c; }
                
                p[r][c] = w;
            }
        
        }
        
        for (int r = 0; r < routes.length; r++) {
            char direction = routes[r].charAt(0);
            int count = Integer.parseInt(String.valueOf(routes[r].charAt(2)));
    
            int ox = x;
            int oy = y;

            // right
            if (direction == 'E') {
    
                for (int e = 0; e < count; e++) {
                    int ry = y + 1;
                    
                    if (ry >= col || p[x][ry] == 'X') {
                        y = oy;
                        break;
                    } else {
                        y = ry;
                    }
                }
                
            // left
            } else if (direction == 'W') {
                
                for (int w = 0; w < count; w++) {
                    int ly = y - 1;
                    
                    if (ly < 0 || p[x][ly] == 'X') {
                        y = oy;
                        break;
                    } else {
                        y = ly;
                    }
                }
                
            // down
            } else if (direction == 'S') {

                for (int d = 0; d < count; d++) {
                    int dx = x + 1;
                    
                    if (dx >= row || p[dx][y] == 'X') {
                        x = ox;
                        break;
                    } else {
                        x = dx;
                    }
                    
                }
                
            // up
            } else if (direction == 'N') {
                
                for (int u = 0; u < count; u++) {
                    int ux = x - 1;
                    
                    if (ux < 0 || p[ux][y] == 'X') {
                        x = ox;
                        break;
                    } else {
                        x = ux;
                    }
                }
                
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}