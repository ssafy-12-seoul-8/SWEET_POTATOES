class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0 ; i<babbling.length ; i++){
            babbling[i] = babbling[i].replace("aya","1");
            babbling[i] = babbling[i].replace("ye","1");
            babbling[i] = babbling[i].replace("woo","1");
            babbling[i] = babbling[i].replace("ma","1");
            babbling[i] = babbling[i].replaceAll("1","");
            
            if(babbling[i].isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}