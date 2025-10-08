import java.util.*;

class Solution {
    Deque<Deque<Integer>> rowDeque;
    Deque<Integer> firstColumn;
    Deque<Integer> lastColumn;
    
    public int[][] solution(int[][] rc, String[] operations) {
        firstColumn = new ArrayDeque<>();
        lastColumn = new ArrayDeque<>();
        rowDeque = new ArrayDeque<>();
        
        for (int[] row : rc) {
            Deque<Integer> deque = new ArrayDeque<>();
            
            firstColumn.add(row[0]);
            
            for (int i = 1; i < row.length - 1; i++) {
                deque.add(row[i]);
            }
            
            lastColumn.add(row[row.length - 1]);
            rowDeque.add(deque);
        }
        
        for (String operation : operations) {
            switch (operation) {
                case "ShiftRow":
                    shiftRow();
                    break;
                case "Rotate":
                    rotate();
            }
        }
        
        int[][] result = new int[rc.length][rc[0].length];
        
        for (int i = 0; i < result.length; i++) {
            result[i][0] = firstColumn.poll();
            Deque<Integer> row = rowDeque.poll();
            
            for (int j = 1; j < result[0].length - 1; j++) {
                result[i][j] = row.poll();
            }
            
            result[i][result[0].length - 1] = lastColumn.poll();
        }
        
        return result;
    }
    
    void shiftRow() {
        rowDeque.addFirst(rowDeque.pollLast());
        firstColumn.addFirst(firstColumn.pollLast());
        lastColumn.addFirst(lastColumn.pollLast());
    }
    
    void rotate() {
        int firstHeader = firstColumn.poll();
        Deque<Integer> firstRow = rowDeque.peekFirst();
        
        firstRow.addFirst(firstHeader);
        
        int lastHeader = firstRow.pollLast();
        
        lastColumn.addFirst(lastHeader);
        
        int lastFooter = lastColumn.pollLast();
        Deque<Integer> lastRow = rowDeque.peekLast();
        
        lastRow.add(lastFooter);
        
        int firstFooter = lastRow.pollFirst();
        
        firstColumn.add(firstFooter);
    }
}