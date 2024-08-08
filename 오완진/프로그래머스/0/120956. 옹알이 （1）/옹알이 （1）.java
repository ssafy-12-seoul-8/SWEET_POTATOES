class Solution {
    public int solution(String[] babbling) {
    	
    	int count = 0;
    	String[] babbles = {"aya", "ye", "woo", "ma"};
    	
    	outer:
    	for (int i = 0; i < babbling.length; i++) {

    		for (int j = 0; j < babbles.length; j++)	// aya ye woo ma 반복 탐색
    			babbling[i] = babbling[i].replace(babbles[j], " ");
    		
    		char[] babblesArr = babbling[i].toCharArray();
    		
    		for (char c : babblesArr)
    			if (c != ' ') continue outer;
    		count++;
    	
    	}
    	return count;
    }
}