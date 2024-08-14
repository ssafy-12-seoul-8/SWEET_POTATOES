import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            String backPlayer = callings[i];
            String frontPlayer = players[map.get(backPlayer) - 1];
            
            int frontIndex = map.get(frontPlayer) + 1;
            int backIndex = map.get(backPlayer) - 1;
            
            map.put(frontPlayer, frontIndex);
            map.put(backPlayer, backIndex);
            
            players[frontIndex] = frontPlayer;
            players[backIndex] = backPlayer;
        }
        
        return players;
    }
}