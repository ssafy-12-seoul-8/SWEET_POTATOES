import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        
        Map<String, Integer> ranking = new HashMap<>();
        
        for (int i=0; i<players.length; i++) {
        	ranking.put(players[i], i);	// 등수는 i+1 로 해줌 -> 다시 i로 해줌
        }
        
        // 1등부터 3등까지. mumu , soe , poe
        // calling 순회 (1번콜 ~ N번콜)
        for (int i=0; i<callings.length; i++) {

        	// callings[i] 에 해당하는 랭커를 찾음.
        	// 예를 들어 callings[0] 이 kai 면, kai의 인덱스인 3을 반환함
        	int cIdx = ranking.get(callings[i]);	// cIdx=3
        	int newIdx = cIdx -1;
        	// 그럼 2등의 이름은 어떻게 알아옴..?
        	String name = players[newIdx];		// 이렇게 알아오면 되지.

        	ranking.replace(callings[i], newIdx);	// kai 의 등수를 1 줄임.
        	ranking.replace(name, cIdx);
        	
        	players[newIdx] = callings[i];
        	players[cIdx] = name;
        	
        }
        
        answer = players;
        return answer;
    }
}