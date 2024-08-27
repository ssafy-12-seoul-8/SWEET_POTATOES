import java.io.*;
import java.util.*;

public class Main {

    static class Dragon {

        List<int[]> coordinates;

        Dragon(int row, int col, int direction) {
            coordinates = new ArrayList<>();
            map[row][col] = true;

            coordinates.add(new int[] { row, col });

            int nextRow = row + dr[direction];
            int nextCol = col + dc[direction];
            map[nextRow][nextCol] = true;

            coordinates.add(new int[] { nextRow, nextCol });
        }

        void upgrade(int generation) {
            for (int i = 0; i < generation; i++) {
                int lastIndex = coordinates.size() - 1;

                for (int j = lastIndex; j > 0; j--) {
                    grow(j);
                }
            }
        }

        void grow(int offset) {
            int[] last = coordinates.get(offset);
            int direction = getDirection(offset, last);
            int[] currentLast = coordinates.get(coordinates.size() - 1);
            int nextRow = currentLast[0] + dr[direction];
            int nextCol = currentLast[1] + dc[direction];
            map[nextRow][nextCol] = true;

            coordinates.add(new int[] { nextRow, nextCol });
        }

        int getDirection(int offset, int[] last) {
            int lastRow = last[0];
            int lastCol = last[1];
            int[] prev = coordinates.get(offset - 1);
            int prevRow = prev[0];
            int prevCol = prev[1];
            int direction = 0;

            for (int i = 0; i < 4; i++) {
                int newRow = lastRow + dr[i];
                int newCol = lastCol + dc[i];

                if (prevRow != newRow || prevCol != newCol) {
                    continue;
                }

                direction = (i + 4 - 1) % 4;
            }
            return direction;
        }

    }

    static final int[] dr = { 0, -1, 0, 1 };
    static final int[] dc = { 1, 0, -1, 0 };
    static final int SIZE = 101;

    static int n;
    static boolean[][] map = new boolean[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());
            Dragon dragon = new Dragon(row, col, direction);

            dragon.upgrade(generation);
        }

        int count = 0;

        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[i][j] && map[i + 1][j] && map[i + 1][j + 1] && map[i][j + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}
