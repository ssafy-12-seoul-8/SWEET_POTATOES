import java.io.*;
import java.util.*;

class Shape {
    
    int rowSize;
    int colSize;
    int[][] coordinates;
    int shapeSize;
    
    Shape(int rowSize, int colSize, int[][] coordinates, int shapeSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.coordinates = coordinates;
        this.shapeSize = shapeSize;
    }
    
    static Shape create(int[][] map, int[] initCondition) {
        int startRow = initCondition[0];
        int startCol = initCondition[1];
        int rowSize = initCondition[2];
        int colSize = initCondition[3];
        int shapeSize = initCondition[4];
        
        int[][] coordinates = new int[rowSize][colSize];
        
        for (int i = startRow; i < startRow + rowSize; i++) {
            for (int j = startCol; j < startCol + colSize; j++) {
                coordinates[i - startRow][j - startCol] = map[i][j];
            }
        }
        
        return new Shape(rowSize, colSize, coordinates, shapeSize);
    }
    
    Shape turnClockwise() {
        int[][] turnedCoordinates = new int[colSize][rowSize];
        
        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                turnedCoordinates[i][j] = coordinates[rowSize - 1 - j][i];
            }
        }
        
        return new Shape(colSize, rowSize, turnedCoordinates, shapeSize);
    }
    
    boolean isPossible(Shape blank) {
        if (blank.shapeSize != this.shapeSize 
            || blank.rowSize != this.rowSize
            || blank.colSize != this.colSize) {
            return false;
        }
        
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (this.coordinates[i][j] == blank.coordinates[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }    
    
}

class Solution {
    
    final int[] dr = {-1, 0, 1, 0};
    final int[] dc = {0, 1, 0, -1};
    
    int[][] gameBoard;
    int[][] table;
    List<Shape> shapes;
    List<Shape> blanks;
    int total;
    
    public int solution(int[][] game_board, int[][] table) {
        this.gameBoard = game_board;
        this.table = table;
        this.shapes = new ArrayList<>();
        this.blanks = new ArrayList<>();
        int n = gameBoard.length;
        boolean[][] visitedShapes = new boolean[n][n];
        boolean[][] visitedBlanks = new boolean[n][n];
        total = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1 && !visitedShapes[i][j]) {
                    int[] initCondition = bfs(table, i, j, visitedShapes, 1);
                    
                    shapes.add(Shape.create(table, initCondition));
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (gameBoard[i][j] == 0 && !visitedBlanks[i][j]) {
                    int[] initCondition = bfs(gameBoard, i, j, visitedBlanks, 0);
                    total += initCondition[4];
                    
                    blanks.add(Shape.create(gameBoard, initCondition));
                }
            }
        }
        
        return fillBlanks();
    }
    
    int fillBlanks() {
        boolean[] filledBlanks = new boolean[blanks.size()];
        int size = 0;
        
        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            
            for (int j = 0; j < blanks.size(); j++) {
                if (filledBlanks[j]) {
                    continue;
                }
                
                int afterTrial = tryRotation(filledBlanks, shape, j, size);
                
                if (afterTrial > size) {
                    size = afterTrial;
                    
                    break;
                }
            }
        }
        
        return size;
    }
    
    int tryRotation(boolean[] filledBlanks, Shape shape, int blankIndex, int size) {
        Shape blank = blanks.get(blankIndex);
        
        for (int i = 0; i < 4; i++) {
            if (shape.isPossible(blank)) {
                filledBlanks[blankIndex] = true;
                
                return size += shape.shapeSize;
            }
            
            shape = shape.turnClockwise();
        }
        
        return size;
    }
    
    int[] bfs(int[][] map, int row, int col, boolean[][] visited, int condition) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] { row, col });
        visited[row][col] = true;
        int startRow = row;
        int startCol = col;
        int rowMax = row;
        int colMax = col;
        int shapeSize = 1;
        
        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int thisRow = element[0];
            int thisCol = element[1];
            
            for (int i = 0; i < 4; i++) {
                int newRow = thisRow + dr[i];
                int newCol = thisCol + dc[i];
                
                if (!isInMap(newRow, newCol) || visited[newRow][newCol]) {
                    continue;
                }
                
                if (map[newRow][newCol] == condition) {
                    visited[newRow][newCol] = true;
                    startRow = Math.min(startRow, newRow);
                    startCol = Math.min(startCol, newCol);
                    rowMax = Math.max(rowMax, newRow);
                    colMax = Math.max(colMax, newCol);
                    shapeSize++;
                    
                    queue.add(new int[] { newRow, newCol });
                }
            }
        }
        
        int rowSize = rowMax - startRow + 1;
        int colSize = colMax - startCol + 1;
        
        return new int[] { startRow, startCol, rowSize, colSize, shapeSize };
    }
    
    boolean isInMap(int row, int col) {
        return row >= 0
            && row < gameBoard.length
            && col >= 0
            && col < gameBoard[0].length;
    }
    
}