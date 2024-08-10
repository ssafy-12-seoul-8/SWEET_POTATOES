class Solution {
    public String[] solution(String[] quiz) {
        int n = quiz.length;
        
        String[] answer = new String[n];
        
        for(int i=0 ; i<n ; i++){
            String tmp = quiz[i];
            String[] tmpS = tmp.split(" ");
            int num1 = Integer.parseInt(tmpS[0]);
            int num2 = Integer.parseInt(tmpS[2]);
            int ans = Integer.parseInt(tmpS[4]);
            String oper = tmpS[1];
            
            
            switch(oper){
                case "+":
                    if(num1+num2==ans){
                        answer[i] = "O";
                    }else{
                        answer[i] = "X";
                    }
                    break;
                case "-":
                    if(num1-num2==ans){
                        answer[i] = "O";
                    }else{
                        answer[i] = "X";
                    }
                    break;
            }
            
            
        }
        
        
        return answer;
    }
}