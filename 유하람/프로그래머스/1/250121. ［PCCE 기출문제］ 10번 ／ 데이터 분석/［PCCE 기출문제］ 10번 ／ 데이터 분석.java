
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int extInt = 0;
        int sort_byInt = 0;
        
        // data 개수
        int len = data.length;
        
        // ext 값 확인
        switch(ext){
            case "code" :
                extInt = 0 ;
                break;
            case "date" :
                extInt = 1 ;
                break;
            case "maximum" :
                extInt = 2 ;
                break;
            case "remain" :
                extInt = 3 ;
                break;
        }
        
         // sort_by 값 확인
        switch(sort_by){
            case "code" :
                sort_byInt = 0 ;
                break;
            case "date" :
                sort_byInt = 1 ;
                break;
            case "maximum" :
                sort_byInt = 2 ;
                break;
            case "remain" :
                sort_byInt = 3 ;
                break;
        }
        
        // ext 값이 val_ext 보다 작은 데이터 추출
        int cnt = 0;
        
        for(int i=0 ; i<len ; i++){
            if(data[i][extInt]<val_ext){
                cnt++;
            }
        }
        
        int[][] ans = new int[cnt][4];
        
        int idx = 0;
        for(int i=0 ; i<len ; i++){
            if(data[i][extInt]<val_ext){
                ans[idx++] = data[i];
            }
        }
        for(int i=0 ; i<cnt ; i++){
            for(int j=i+1 ; j<cnt ; j++){
                if(ans[i][sort_byInt]>ans[j][sort_byInt]){
                    int[] temp = ans[i];
                    ans[i] = ans[j];
                    ans[j] = temp;
                }
        
            }
        }    
        
        return ans;
    }
}