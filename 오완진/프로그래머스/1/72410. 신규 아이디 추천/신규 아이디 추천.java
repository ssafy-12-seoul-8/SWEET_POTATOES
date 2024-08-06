import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String newId) {
        List<Character> tmpArr = new ArrayList<>();
        for (int i = 0; i < newId.length(); i++) {
        	tmpArr.add(newId.charAt(i));
        }
        
	    // 0. " " -> a
	    if (tmpArr.size() == 0) tmpArr.add('a');
        	
    	// 1 대문자 -> 소문자
    	for (int i = tmpArr.size() - 1; i >= 0; i--) {
    		if ('A' <= tmpArr.get(i) && tmpArr.get(i) <= 'Z') {
    			tmpArr.set(i, (char)(tmpArr.get(i)+32));
    		}
    	}
    	
    	// 2 소문자 숫자 - _ . 제외 제거
    	for (int i = tmpArr.size() - 1; i >= 0; i--) {
    		if (!(('a' <= tmpArr.get(i) && tmpArr.get(i) <= 'z') ||
    				('0' <= tmpArr.get(i) && tmpArr.get(i) <= '9') ||
    				(tmpArr.get(i) == '-') || (tmpArr.get(i) == '_') || (tmpArr.get(i) == '.'))) {
    			tmpArr.remove(i);
    		}
    	}
    	
	    // 0. " " -> a
	    if (tmpArr.size() == 0) tmpArr.add('a');
    	
    	// 3 .. -> .
    	for (int i = tmpArr.size() - 2; i >= 0; i--) {
    		if (tmpArr.get(i) == '.' && tmpArr.get(i+1) == '.') {
    			tmpArr.remove(i);
    		}
    	}
    	
    	// 4 .( ). -> ( )
    	if (tmpArr.size() == 1) {
    		if (tmpArr.get(0) == '.') tmpArr.remove(0);
    	} else {
    		if (tmpArr.get(0) == '.') tmpArr.remove(0);
    		if (tmpArr.get(tmpArr.size() - 1) == '.') tmpArr.remove(tmpArr.size() - 1);
    	}
    
	    // 5 " " -> a
	    if (tmpArr.size() == 0) tmpArr.add('a');
        
        // 6 16자+ -> 15자 & 제거 후 ( ). -> ( )
        if (tmpArr.size() > 15) {
        	while (tmpArr.size() > 15)
        		tmpArr.remove(tmpArr.size() - 1);
        }
        if (tmpArr.size() == 15) {
        	if (tmpArr.get(14) == '.') tmpArr.remove(14);
        }
        
        // 7 2자(ab) -> abb
    	if (tmpArr.size() == 1) {
    		tmpArr.add(tmpArr.get(0));
    		tmpArr.add(tmpArr.get(0));
    	} else if (tmpArr.size() == 2) {
    		tmpArr.add(tmpArr.get(1));
    	}
    	
        newId = "";
        for (char ch : tmpArr)
        	newId += ch;
        
        return newId;
    }
}