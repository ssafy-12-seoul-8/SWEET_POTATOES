import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 1. ext 값이 val_ext 보다 작은 데이터만 뽑아낸다
        int[][] answer = getFilteredData(data, ext, val_ext);
        
        int idx = 0;
        
        if (sort_by.equals("code")) { Arrays.sort(answer, comp0); } 
        else if (sort_by.equals("date")) { Arrays.sort(answer, comp1); } 
        else if (sort_by.equals("maximum")) { Arrays.sort(answer, comp2); } 
        else if (sort_by.equals("remain")) { Arrays.sort(answer, comp3); }
        
        return answer;
    }
    
    public int[][] getFilteredData(int[][] data, String ext, int val_ext) {
        int idx = 0;
        
        if (ext.equals("code")) { idx = 0; } 
        else if (ext.equals("date")) { idx = 1; } 
        else if (ext.equals("maximum")) { idx = 2; } 
        else if (ext.equals("remain")) { idx = 3; }
        
        int cnt = 0;
        
        for (int[] d : data) {
            if (d[idx] < val_ext) {
                cnt++;
            }
        }
        
        int[][] arr = new int[cnt][4];
        
        for (int i = 0, c = 0; i < data.length; i++) {
            if (data[i][idx] < val_ext) {
                arr[c++] = data[i];
            }
        }
        
        return arr;
    }
    
    static Comparator<int[]> comp0 = new Comparator<int[]>() {
        public int compare(int[] value1, int[] value2) {
            return value1[0] - value2[0];
        }
    };
    
    static Comparator<int[]> comp1 = new Comparator<int[]>() {
        public int compare(int[] value1, int[] value2) {
            return value1[1] - value2[1];
        }
    };
    
    static Comparator<int[]> comp2 = new Comparator<int[]>() {
        public int compare(int[] value1, int[] value2) {
            return value1[2] - value2[2];
        }
    };
    
    static Comparator<int[]> comp3 = new Comparator<int[]>() {
        public int compare(int[] value1, int[] value2) {
            return value1[3] - value2[3];
        }
    };
}