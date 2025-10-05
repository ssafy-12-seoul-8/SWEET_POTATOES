import java.util.*;

class Solution {
    int[][] dices;
    int max;
    int n;
    int[] resultDices;
    
    public int[] solution(int[][] dice) {
        dices = dice;
        max = 0;
        n = dices.length;
        
        for (int i = 0; i < n; i++) {
            boolean[] aDices = new boolean[n];
            
            aDices[i] = true;
            
            combination(i, aDices, 1);
            
            aDices[i] = false;
        }
        
        return resultDices;
    }
    
    void combination(int index, boolean[] aDices, int count) {
        if (count == n / 2) {
            calculate(aDices);
            
            return;
        }
        
        for (int i = index + 1; i < dices.length; i++) {
            aDices[i] = true;
            
            combination(i, aDices, count + 1);
            
            aDices[i] = false;
        }
    }
    
    void calculate(boolean[] isA) {
        Queue<Integer> aScore = new PriorityQueue<>();
        Queue<Integer> bScore = new PriorityQueue<>();
        int[] aDices = new int[n / 2];
        int[] bDices = new int[n / 2];
        int aIndex = 0;
        int bIndex = 0;
        
        for (int i = 0; i < n; i++) {
            if (isA[i]) {
                aDices[aIndex++] = i + 1;
            } else {
                bDices[bIndex++] = i + 1;
            }
        }
        
        combinationScore(0, aDices, 0, aScore);
        combinationScore(0, bDices, 0, bScore);
        
        int canWin = 0;
        int aWin = 0;
        
        while (!aScore.isEmpty()) {
            if (bScore.isEmpty()) {
                aScore.poll();
                
                aWin += canWin;
                
                continue;
            }
            
            while(!aScore.isEmpty() && !bScore.isEmpty()) {
                if (bScore.peek() < aScore.peek()) {
                    bScore.poll();
                    
                    canWin++;
                } else {
                    aScore.poll();
                    
                    aWin += canWin;
                }
            }
        }
        
        if (aWin > max) {
            resultDices = aDices;
            max = aWin;
        }
    }
    
    void combinationScore(int index, int[] indices, int score, Queue<Integer> scores) {
        if (index == n / 2) {
            scores.add(score);
            
            return;
        }
        
        int diceIndex = indices[index] - 1;
        int[] dice = dices[diceIndex];
        
        for (int num : dice) {
            combinationScore(index + 1, indices, score + num, scores);
        }
    }
}