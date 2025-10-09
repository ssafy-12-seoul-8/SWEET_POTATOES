import java.util.*;

class Solution {
    int[] apeach;
    Queue<int[]> pq;
    int max;
    int count = 0;
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        pq = new PriorityQueue<>(this::compareScores);
        max = -1;
        int[] ryan = new int[apeach.length];
        
        combination(0, ryan, n);
        
        ryan[0] = apeach[0] + 1;
        
        combination(0, ryan, n - ryan[0]);
        
        if (max == -1) {
            return new int[] { -1 };
        }
        
        return pq.peek();
    }
    
    void combination(int index, int[] ryan, int left) {
        if (index == 10 && left > 0) {
            ryan[10] += left;
            left = 0;
        }
        
        if (left < 0) {
            return;
        }
        
        if (left == 0) {
            int scoreDifference = calculateScores(ryan);
            
            if (scoreDifference <= 0 || max > scoreDifference) {
                return;
            }
            
            if (max < scoreDifference) {
                pq.clear();
            }
            
            max = scoreDifference;
            pq.add(Arrays.copyOf(ryan, ryan.length));
            
            return;
        }
        
        for (int i = index + 1; i < ryan.length; i++) {
            ryan[i] = 0;
            
            combination(i, ryan, left);
            
            ryan[i] = apeach[i] + 1;
            
            combination(i, ryan, left - ryan[i]);
            
            ryan[i] = 0;
        }
    }
    
    int calculateScores(int[] ryan) {
        int apeachScore = 0;
        int ryanScore = 0;
        
        for (int i = 0; i < ryan.length; i++) {
            int thisScore = 10 - i;
            
            if (apeach[i] == 0 && ryan[i] == apeach[i]) {
                continue;
            }
            
            if (ryan[i] > apeach[i]) {
                ryanScore += thisScore;
            } else {
                apeachScore += thisScore;
            }
        }
        
        return ryanScore - apeachScore;
    }
    
    int compareScores(int[] o1, int[] o2) {
        for (int i = o1.length - 1; i >= 1; i--) {
            if (o2[i] != o1[i]) {
                return o2[i] - o1[i];
            }
        }
        
        return o2[0] - o1[0];
    }
}