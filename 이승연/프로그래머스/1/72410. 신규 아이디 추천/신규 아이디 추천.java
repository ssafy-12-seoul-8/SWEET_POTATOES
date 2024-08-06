import java.util.regex.*;

class Solution {
    public String solution(String new_id) {
        String defaultRegExp = "^(?!.*\\.\\.)(?!\\.$)(?!^\\.)[a-z0-9._-]{3,5}$";
        Pattern defaultPattern = Pattern.compile(defaultRegExp);
        Matcher defaultMatcher = defaultPattern.matcher(new_id);
        
        if (defaultMatcher.matches()) {
            return new_id;
        }
        
        String answer = "";
        
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        answer = new_id.toLowerCase();
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        answer = answer.replaceAll("[^a-z0-9._-]", "");
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        answer = answer.replaceAll("\\.{2,}", ".");
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        answer = answer.replaceAll("^\\.|\\.$", "");
        
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (answer.length() == 0) {
            answer += 'a';
        }
        
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        
        //      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, 14);
        }
        
        if (answer.length() <= 2) {
            char c = answer.charAt(answer.length() - 1);
            
            while(answer.length() < 3) {
                answer += c;
            }
        }
        
        // System.out.println(answer);
        
        return answer;
    }
}