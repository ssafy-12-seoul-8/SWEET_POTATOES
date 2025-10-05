import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> giveAndTake = new HashMap<>();
        Map<String, Integer> giftDegree = new HashMap<>();
        Map<String, Integer> nextMonth = new HashMap<>();
        int max = 0;
        
        for (String friend : friends) {
            giveAndTake.put(friend, new HashMap<>());
            giftDegree.put(friend, 0);
            nextMonth.put(friend, 0);
        }
        
        for (String gift : gifts) {
            String[] giveTake = gift.split(" ");
            String give = giveTake[0];
            String take = giveTake[1];
            Map<String, Integer> friend = giveAndTake.get(give);
            
            friend.put(take, friend.getOrDefault(take, 0) + 1);
            giftDegree.put(give, giftDegree.get(give) + 1);
            giftDegree.put(take, giftDegree.get(take) - 1);
        }
        
        for (String giver : giveAndTake.keySet()) {
            for (String taker : giftDegree.keySet()) {
                if (taker.equals(giver)) {
                    continue;
                }
                
                int given = giveAndTake.get(giver)
                    .getOrDefault(taker, 0);
                int taken = giveAndTake.get(taker)
                    .getOrDefault(giver, 0);
                
                if (given > taken) {
                    nextMonth.put(giver, nextMonth.get(giver) + 1);
                }
                
                if (given == taken && giftDegree.get(giver) > giftDegree.get(taker)) {
                    nextMonth.put(giver, nextMonth.get(giver) + 1);
                }
            }

            max = Math.max(max, nextMonth.get(giver));
        }
        
        return max;
    }
}