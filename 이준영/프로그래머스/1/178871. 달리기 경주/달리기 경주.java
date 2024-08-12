import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        int len = players.length;
	        Map<String, Integer> map = new HashMap<>();
	        for (int i=0;i<len;i++) {
	        	map.put(players[i], i);
	        }
	        for (String player1:callings) {
	        	int location = map.get(player1);
	        	String player2 = players[location-1];
	        	map.put(player1, location-1);
	        	map.put(player2, location);
	        	players[location]=player2;
	        	players[location-1]=player1;
	        }
	        return players;
    }
}