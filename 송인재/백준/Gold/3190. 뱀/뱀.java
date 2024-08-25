import java.io.*;
import java.util.*;

public class Main {
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int n, k, l;
    
    static class Node {
        
        Node next;
        int[] coordinates;
        
        Node(Node next, int[] coordinates) {
            this.next = next;
            this.coordinates = coordinates;
        }
        
    }
    
    static class Python {
        
        Node head;
        Node tail;
        int face;
        int time;
        
        Python() {
            head = new Node(null, new int[2]);
            tail = new Node(head, new int[2]);
            face = 1;
            time = 1;
        }
        
        boolean isMoving(int x) {
            for (int i = time - 1; i < x; i++) {
                int headRow = head.coordinates[0] + dr[face];
                int headCol = head.coordinates[1] + dc[face];
            
                if (!isInMap(headRow, headCol) || map[headRow][headCol] == 2) {
                    return false;
                }
                
                time++;
            
                Node newHead = new Node(null, new int[] {headRow, headCol});
                head.next = newHead;
                head = newHead;
            
                if (map[headRow][headCol] == 0) {
                    tail = tail.next;
                    map[tail.coordinates[0]][tail.coordinates[1]] = 0;
                }
                
                map[headRow][headCol] = 2;
            }
            
            return true;
        }
        
        boolean isInMap(int row, int col) {
            return row >= 0
                && row < map.length
                && col >= 0
                && col < map[0].length;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        Python python = new Python();
        
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int appleRow = Integer.parseInt(st.nextToken()) - 1;
            int appleCol = Integer.parseInt(st.nextToken()) - 1;
            
            map[appleRow][appleCol] = 1;
        }
        
        map[0][0] = 2;
        
        l = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int nextFace = st.nextToken().equals("D") ? 1 : -1;
            
            if (!python.isMoving(x)) {
                break;
            }
            
            python.face = (python.face + 4 + nextFace) % 4;
        }
        
        python.isMoving(python.time + n);
        
        System.out.println(python.time);
    }
    
}