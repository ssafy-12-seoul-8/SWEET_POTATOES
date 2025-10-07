import java.util.*;

class Solution {
    int[] discounts = { 10, 20, 30, 40 };
    int[][] users;
    int[] emoticons;
    int maxCount;
    int maxBought;
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        maxCount = 0;
        maxBought = 0;
        
        combination(0, new int[emoticons.length]);
        
        return new int[] { maxCount, maxBought };
    }
    
    void combination(int index, int[] emojiDiscounted) {
        if (index == emoticons.length) {
            calculate(emojiDiscounted);
            
            return;
        }
        
        for (int i = 0; i < discounts.length; i++) {
            emojiDiscounted[index] = discounts[i];
            
            combination(index + 1, emojiDiscounted);
        }
    }
    
    void calculate(int[] emojiDiscounted) {
        boolean[] joined = new boolean[users.length];
        int[] bought = new int[users.length];
        
        for (int i = 0; i < emojiDiscounted.length; i++) {
            int amount = emoticons[i] * (100 - emojiDiscounted[i]) / 100;
            
            for (int j = 0; j < users.length; j++) {
                if (joined[j]) {
                    continue;
                }
                
                if (users[j][0] <= emojiDiscounted[i]) {
                    bought[j] += amount;
                }
                
                if (bought[j] >= users[j][1]) {
                    joined[j] = true;
                }
            }
        }
        
        int count = 0;
        int totalBought = 0;
        
        for (int i = 0; i < users.length; i++) {
            if (joined[i]) {
                count++;
                
                continue;
            }
            
            totalBought += bought[i];
        }
        
        if (maxCount == count) {
            maxBought = Math.max(maxBought, totalBought);
        }
        
        if (maxCount < count) {
            maxCount = count;
            maxBought = totalBought;
        }
    }
}