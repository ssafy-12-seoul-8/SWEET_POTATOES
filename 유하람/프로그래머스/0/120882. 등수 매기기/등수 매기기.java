class Solution {
    public int[] solution(int[][] score) {
        double[] answer = new double[score.length];
        
        for(int i=0 ; i<score.length ; i++){
            answer[i] = ((double)score[i][0]+score[i][1])/2;
        }
        
        int[] result = new int[score.length];
        
        for(int i=0 ; i<score.length ; i++){
            result[i] = 1;
            for(int j =0 ; j<score.length ; j++){
                if(answer[i]<answer[j]){
                    result[i]++;
                }
            }
        }
        
        return result;
    }
}